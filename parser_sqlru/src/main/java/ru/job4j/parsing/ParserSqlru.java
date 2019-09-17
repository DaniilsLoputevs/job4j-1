package ru.job4j.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ParserSqlru implements ParsSite, Job {
    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private List<Vacancy> vac;
    private ValidatorSqlru validatorSqlru;
    private DataBaseApi dataBaseApi;
    private boolean work = true;
    private LocalDateTime last;


    public ParserSqlru()  {
        this.vac = new ArrayList<>();
        this.validatorSqlru = new ValidatorSqlru();
        this.dataBaseApi = new DataBaseApi();
    }

    public List<Vacancy> parsing(String url) {
        System.out.println("Начало работы парсера");
        this.last = this.dataBaseApi.takeLastDataInDb();
        int i = 1;
        try {
            while (this.work) {
                StringBuilder stringBuilder = new StringBuilder(url).append("/").append(i++);
                Document document = Jsoup.connect(stringBuilder.toString()).get();
                Elements table = document.getElementsByTag("table");
                Element ftable = table.select("table.forumTable").first();
                Elements vac = ftable.select("tr");
                for (Element v : vac) {
                    Element titlevac = v.select("td > a[href]").first();
                    Element date = v.select("td.altCol").last();
                    if (Objects.nonNull(titlevac)) {
                        String title = titlevac.text();
                        if (this.validatorSqlru.checkKeyWords(title)) {
                            String u = titlevac.attr("href");
                            Document textvac = Jsoup.connect(u).get();
                            Elements elementtab = textvac.getElementsByTag("table");
                            Element fmsg = elementtab.select("table.msgTable").first();
                            Elements m = fmsg.select("tr");
                            String text = m.select("td.msgBody").last().text();
                            String datevac = date.text();
                            this.conditionStopParsing(datevac);
                            this.vac.add(new Vacancy(u, title, text, this.validatorSqlru.convertTime(datevac)));
                        }
                    }
                }
            }
            this.outputDataInDb();
        } catch (Exception e) {
            LOG.error("error sql", e);
        }
        return this.vac;
    }

    private boolean conditionStopParsing(String time) {
        boolean rs = true;
        LocalDateTime current = this.conditionToParse(this.last);
        LocalDateTime check = this.validatorSqlru.convertTime(time);
        if (current.isAfter(check)) {
            rs = false;
            this.work = false;
        }

        return rs;

    }

    /**
     * Утилитный метод условия парсинга , если таблица пустая то возвращается начало года.
     *
     * @param value дата последней записи в таблице
     * @return LocalDateTime
     */
    private LocalDateTime conditionToParse(LocalDateTime value) {
        LocalDateTime rs = null;
        if (Objects.isNull(value)) {
            rs = LocalDateTime.of(2019, 1, 1, 0, 0);
        } else {
            rs = this.last;
        }

        return rs;
    }


    private void outputDataInDb() {
        if (!this.work) {
            this.dataBaseApi.insertData(this.vac);
        }


    }



    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        ParserSqlru parserSqlru = new ParserSqlru();
        parserSqlru.parsing("https://www.sql.ru/forum/job-offers");

    }
}


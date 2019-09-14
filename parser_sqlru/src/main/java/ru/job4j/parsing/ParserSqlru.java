package ru.job4j.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ParserSqlru implements ParsSite {
    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private List<Vacancy> vac;
    private ValidatorSqlru validatorSqlru;
    private DataBaseApi dataBaseApi;
    private boolean work = true;


    public ParserSqlru() {
        this.vac = new ArrayList<>();
        this.validatorSqlru = new ValidatorSqlru();
        this.dataBaseApi = new DataBaseApi();
    }

    public List<Vacancy> parsing(String url) {
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
                            this.conditionDateparsing(datevac);
                            this.vac.add(new Vacancy(u, title, text, this.validatorSqlru.convertTime(datevac)));
                        }
                    }
                }
            }
            this.outData();
        } catch (Exception e) {
            LOG.error("error sql", e);
        }
        return this.vac;
    }

    private boolean conditionDateparsing(String time) {
        boolean rs = true;
        LocalDateTime current = LocalDateTime.now().minusDays(365);
        LocalDateTime check = this.validatorSqlru.convertTime(time);
        if (current.isAfter(check)) {
            rs = false;
            this.work = false;
        }

        return rs;

    }

    private void outData() {
        if (!this.work) {
            this.dataBaseApi.init();
            this.dataBaseApi.insertData(this.vac);
        }


    }

//
//    public static void main(String[] args) {
//        ParserSqlru parserSqlru = new ParserSqlru();
//        System.out.println(parserSqlru.parsing("https://www.sql.ru/forum/job-offers"));
//
//
//    }

}


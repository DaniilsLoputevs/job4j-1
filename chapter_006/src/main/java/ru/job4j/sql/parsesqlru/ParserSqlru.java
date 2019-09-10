package ru.job4j.sql.parsesqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ParserSqlru implements ParsSite {
    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private List<Vacancy> vac;


    public ParserSqlru() {
        vac = new ArrayList<>();
    }

    public List<Vacancy> parsing(String url) {
        Vacancy vacancy;
        String u;
        String title;
        String text;
        String datevac;
        try {
            Document document = Jsoup.connect(url).get();
            Elements table = document.getElementsByTag("table");
            Element ftable = table.select("table.forumTable").first();
            Elements vac = ftable.select("tr");
            for (Element v : vac) {
                Element titlevac = v.select("td > a[href]").first();
                Element date = v.select("td.altCol").last();
                if (Objects.nonNull(titlevac)) {
                    title = titlevac.text();
                    u = titlevac.attr("href");
                    Document textvac = Jsoup.connect(u).get();
                    Elements elementtab = textvac.getElementsByTag("table");
                    Element fmsg = elementtab.select("table.msgTable").first();
                    Elements m = fmsg.select("tr");
                    text = m.select("td.msgBody").last().text();
                    datevac = date.text();


//                    System.out.println(title + " " + u + " url vacancy");
//                    System.out.println();
//                    System.out.println(text);
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
//                    System.out.println(datevac + " ------Время публикации");
//                    System.out.println();
                }

            }


        } catch (Exception e) {
            LOG.error("error parsing", e);
        }
        return this.vac;
    }


    public static void main(String[] args) {
        ParserSqlru parserSqlru = new ParserSqlru();
        parserSqlru.parsing("https://www.sql.ru/forum/job-offers");
    }

}


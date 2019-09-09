package ru.job4j.sql.parsesqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class ParserSqlru {
    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private List<Vacancy> vac;


    public ParserSqlru() {
        vac = new ArrayList<>();
    }

    public List<Vacancy> parsing(String url) {
        Vacancy vacancy;
        try {
            Document document = Jsoup.connect(url).get();
            Elements table = document.select("table[class=forumTable]");
            Elements vac = table.select("td[class=postslisttopic]");
            for (Element element : vac) {
                String uri = element.select("a[href]").attr("href");
                String title = element.text();
                System.out.println(uri);
                System.out.println(title);
            }
        } catch (Exception e) {
            LOG.error("error parsing", e);
        }
        return this.vac;
    }


//    private boolean checkVacancy(String title){
//        if (title.equals(""))
//    }

    public static void main(String[] args) {
        ParserSqlru parserSqlru = new ParserSqlru();
        parserSqlru.parsing("https://www.sql.ru/forum/job-offers");
    }

}


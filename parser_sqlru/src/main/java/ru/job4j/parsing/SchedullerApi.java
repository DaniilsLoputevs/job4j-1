package ru.job4j.parsing;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.quartz.TriggerBuilder.newTrigger;

public class SchedullerApi {
    private static final Logger LOG = LogManager.getLogger(SchedullerApi.class.getName());


    public void starting() throws SchedulerException {
        String crontimer = null;
        try (InputStream inputStream = SchedullerApi.class.getClassLoader().getResourceAsStream("app.properties3")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            crontimer = properties.getProperty("cron.time");
        } catch (IOException e) {
            LOG.error("error load propfile", e);
        }
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail jobDetail = JobBuilder.newJob(ParserSqlru.class).withIdentity("parsing_sql.ru", "gpoup1").build();
        Trigger t = newTrigger().withIdentity("trigereveryday").startNow().withSchedule(CronScheduleBuilder.cronSchedule(crontimer)).build();
        scheduler.scheduleJob(jobDetail, t);
        scheduler.start();
    }


    public static void main(String[] args) throws SchedulerException {
        SchedullerApi schedullerApi = new SchedullerApi();
        schedullerApi.starting();
    }
}


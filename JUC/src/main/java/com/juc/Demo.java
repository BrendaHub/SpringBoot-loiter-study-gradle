package com.juc;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Demo {
    private static Instant instant = LocalDateTime.of(2000, 1, 1, 1,1).atZone(ZoneId.systemDefault()).toInstant();
    public static void main(String[] args) {
        System.out.println("Hello, JUC");

        System.out.println(instant.plus(12, ChronoUnit.HOURS));
        System.out.println(Instant.now());
        System.out.println(ZonedDateTime.now());
        System.out.println(LocalDateTime.now());

        System.out.println(new Date());
        System.out.println(getLastModify(new Date()));


        Duration duration = Duration.ofSeconds(5);
        System.out.println(duration.getNano());
        Duration duration1 = duration.minusMillis(3);
        Duration duration2 = duration.minusMillis(4);
        System.out.println(duration1.getNano());
        System.out.println(duration2.getNano());//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/javatime/javatime_duration_minusmillis.html




    }

    private static Date getLastModify(Date modify){
        return Date.from(modify.toInstant().minusMillis(TimeUnit.DAYS.toMillis(1000)));
    }
}

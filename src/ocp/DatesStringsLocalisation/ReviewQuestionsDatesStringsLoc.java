/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.DatesStringsLocalisation;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author PietroS
 */
public class ReviewQuestionsDatesStringsLoc {

    public static void main(String... args) {
//13. Note that March 13, 2016, is the weekend that clocks spring ahead for daylight savings
//time. What is the output of the following?        
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone);
        ZonedDateTime dateTime2 = dateTime1.plus(1, ChronoUnit.HOURS);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2);
        int clock1 = dateTime1.getHour();
        int clock2 = dateTime2.getHour();
        System.out.println(hours + "," + clock1 + "," + clock2);
//15. Given the following code, which of the answer choices can fill in the blank to print true?
//(Choose all that apply.)
        System.out.println("-----------------------------15--------------------------------");
        String m1 = Duration.of(60, ChronoUnit.MINUTES).toString();
        String m2 = Duration.ofMinutes(1).toString();
        String s = Duration.of(60, ChronoUnit.SECONDS).toString();
        String mm = Duration.of(24, ChronoUnit.HOURS).toString();
        String d = Duration.ofDays(365).toString();
        String p = Period.ofDays(1).toString();
        String m = Period.ofMonths(12).toString();
        System.out.println(m1);
        System.out.println(m2);
        System.out.println(s);
        System.out.println(mm);
        System.out.println(d);
        System.out.println(p);
        System.out.println(m);
        System.out.println(m1 == m2);
        System.out.println(m1.equals(m2));
        System.out.println(m1.equals(s));
        System.out.println(d == p);
        System.out.println(d.equals(p));
//16. Given the following, which answers can correctly fill in the blank? (Choose all that apply.)
        LocalDate date2 = LocalDate.now();
        LocalTime time2 = LocalTime.now();
        LocalDateTime dateTime3 = LocalDateTime.now();
        ZoneId zoneId2 = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(dateTime3, zoneId2);
        long epochSeconds = 0;
        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochSecond(epochSeconds));
        System.out.println(zonedDateTime2.toInstant());
    }
}

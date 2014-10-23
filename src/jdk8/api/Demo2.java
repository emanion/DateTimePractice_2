package jdk8.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Demo2 {
    public static void main(String[] args) {
        // Get current date and time
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Current date/time with built-in LocalDateTime class format: " + date);
        
        // Now use new DateTimeFormatter class
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
        String strDate = date.format(format);
        System.out.println("Current date/time with custom format provided by DateTimeFormatter: " + strDate);

        // Just get Dates without time values and calculate payday
        format = DateTimeFormatter.ofPattern("MMM d yyyy");
        LocalDate today = LocalDate.now();
        LocalDate payday1 = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate payday2 = today.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println("Pretend Payday is at the end of this month: " + payday1.format(format));
        System.out.println("Pretend Payday is at the end of this month, less two days: " + payday2.format(format));
        
        // What else can you do? Do some research and share with class. You have one hour!
        
        
        
        LocalDate todayTwo = LocalDate.now();
        System.out.println(todayTwo);
        LocalDate myBirthday = LocalDate.of(1958,Month.MAY,31);
        System.out.println("My birthday is " + myBirthday);
        System.out.println("I was born on a " + myBirthday.getDayOfWeek());
        
        
        
        
        //getting next birthday.
        //start with Birthday  THIS YEAR
        //If your birthday has occurred this year already, add 1 to the year.
        LocalDate nextBDay = myBirthday.withYear(today.getYear());
        if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
            nextBDay = nextBDay.plusYears(1);
        }
        System.out.println("my next birthday is: " + nextBDay);
        System.out.println("My next birthday is on a " + nextBDay.getDayOfWeek());
        
        
        
        //calculate time until next birthday.
        Period p = Period.between(today, nextBDay);
        long p2 = ChronoUnit.DAYS.between(today, nextBDay);
        System.out.println("There are " + p.getMonths() + " months, and " +
                   p.getDays() + " days until my next birthday. (" +
                   p2 + " total)");
        
        
        
        //Using TemporalAdjusters on my birthday.
        //doing math with days after my birthday.
        LocalDate beforeBday = myBirthday.minusDays(2);
        System.out.println("Two days before my Birthday was " + beforeBday);
        LocalDate afterBday = myBirthday.plusDays(5);
        System.out.println("5 days after my Birthday was " + afterBday);
        System.out.println("That day was a " + afterBday.getDayOfWeek());
        
        
        //play with Duration of minutes....
        
        LocalDate nextFirstOfMonth = myBirthday.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println("\n\n\nthe next first of the month was " + nextFirstOfMonth);
        
        
        
        //LocalDate playing = myBirthday.
        
        
    }
}

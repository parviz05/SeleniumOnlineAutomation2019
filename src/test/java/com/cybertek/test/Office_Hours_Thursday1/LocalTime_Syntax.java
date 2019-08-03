package com.cybertek.test.Office_Hours_Thursday1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTime_Syntax {
    public static void main(String[] args) {

        /** Java date syntax
         * http://tutorials.jenkov.com/java-internationalization/simpledateformat.html
         *
         * Java date format
         * http://tutorials.jenkov.com/java-date-time/parsing-formatting-dates.html
         */
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyy")));
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
    }
}

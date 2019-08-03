package com.cybertek.test.Office_Hours_Thursday1;

public class library {

    public static void sleep(double a){// to avoid code repitations for handling exception in my project i need to customise Thead.sleep method
        // like bellow and then when ever i need to waid 3  second or whatever i want I just gonna use my own method by passing an argument

        try {
            Thread.sleep((long)a*1000);

        } catch (InterruptedException e) {

        }
    }


}

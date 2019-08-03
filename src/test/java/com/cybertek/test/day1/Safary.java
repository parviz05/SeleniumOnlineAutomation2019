package com.cybertek.test.day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safary {
    public static void main(String[] args)throws Exception {

        WebDriver driver=new SafariDriver();
        driver.get("http://google.com");
        Thread.sleep(3000);
        driver.navigate().to("http://amazon.com");
        driver.manage().window().maximize();

        Thread.sleep(3000);
        driver.close();


    }
}

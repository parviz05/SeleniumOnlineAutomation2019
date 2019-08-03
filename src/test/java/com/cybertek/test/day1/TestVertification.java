package com.cybertek.test.day1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.*;
public class TestVertification {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=BrowserFactory.getDriver("chrome");
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        //this expecting title for every website
       String expectingTitile="Practice";

       String expectingURL="http://practice.cybertekschool.com";

        for (String url:urls ) {
            Thread.sleep(5000);
            driver.manage().window().maximize();
            driver.get(url);// we are opening website
            Thread.sleep(3000);

            //we are checking if page title of every website is correct
            if (driver.getTitle().equals(expectingTitile)) {
                System.out.println("passed");

            } else {
                System.out.println("failed");
                System.out.println("Expecting Title" + expectingTitile);
            }
            System.out.println("verify page URL's");
            //to verify if every page url starts with expected URL
            if (driver.getCurrentUrl().startsWith(expectingURL)) {
                System.out.println("Passed");

            } else {
                System.out.println("failed");
                System.out.println("expecting URL" + expectingURL);

            }
        }
        driver.close();
    }
}

package com.cybertek.test.day6;

import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorPractice_ClassName {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        Method1();
    }
    public static void Method1(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/");
        List<WebElement>classes=driver.findElements(By.className("list-group-item"));
        int totla=0;
        for (WebElement eachclass:classes) {

            System.out.println(eachclass.getText());

        }

        driver.close();
    }

}

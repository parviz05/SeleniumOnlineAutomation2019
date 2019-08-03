package com.cybertek.test.MyPrictices;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ebay {

  static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        Method1();
    }

    public static void Method1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        library.sleep(2.5);
        driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("java book");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("gh-btn")).click();
        library.sleep(2.5);
        System.out.println(driver.findElement(By.className("srp-controls__count-heading")).getText());
        library.sleep(2.5);
        driver.close();




    }
}


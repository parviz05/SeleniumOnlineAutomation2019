package com.cybertek.test.day13_WebDriver_API;

import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleep_And_ImplicitWait_Test {


    WebDriver driver;
    String startButtonLocator="#start >button";
    String helloWorldLocator="#finish>h4";

    @BeforeMethod
    public void setUp(){

        driver= BrowserFactory.getDriver("chrome");

        //this implicit wait can handle NoSuchElementException, withng giving time frame.
        //driver will wait up to 10 second
        //no strictly 10 second it should wait up to 10 second
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void treatdrown(){
        driver.quit();
    }
    @Test
    public void waitTest1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.findElement(By.cssSelector(startButtonLocator)).click();
      String expectedResult = "Hello World";
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String actualResult= driver.findElement(By.cssSelector(helloWorldLocator)).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
    @Test
    public void waitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String expectedResult = "Hello World";
        String actualResult= driver.findElement(By.cssSelector(helloWorldLocator)).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
       // Assert.assertTrue(actualResult.contains(expectedResult));
    }



}

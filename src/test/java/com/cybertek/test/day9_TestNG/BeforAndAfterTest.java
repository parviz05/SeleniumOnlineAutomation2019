package com.cybertek.test.day9_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforAndAfterTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://google.com");

    }
    @Test(priority = 1)
    public void test1(){
         Assert.assertTrue(driver.getTitle().contains("Google"));
         driver.findElement(By.name("q")).sendKeys("Book", Keys.ENTER);

     }
     @Test(priority = 0)
    public void test2(){
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        driver.findElement(By.name("q")).sendKeys("Book", Keys.ENTER);

    }
     @AfterMethod
     public void tearDown(){
        driver.quit();
  }
}

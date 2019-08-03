package com.cybertek.test.day9_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DefaultData {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@BeforeMethod
    public void setUp(){

        driver.get("http://practice.cybertekschool.com/dropdown");


    }
    @Test
    public void tes1(){
        int expectedYear=2019;
        String expectedMonth="July";
        int expectedDay=9;
        Select selectedYear=new Select(driver.findElement(By.id("year")));
        Select selectedMonth=new Select(driver.findElement(By.id("month")));
        Select selectedDay=new Select(driver.findElement(By.id("day")));

      int actualYear= Integer.parseInt(selectedYear.getFirstSelectedOption().getText());
      String actualMonth=selectedMonth.getFirstSelectedOption().getText();
      int actualDay=Integer.parseInt(selectedDay.getFirstSelectedOption().getText());
      
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedMonth,actualMonth);
        Assert.assertEquals(expectedDay,actualDay);








    }
    public void tes2(){

    }

    @AfterMethod
    public void tearDown(){
    driver.quit();
    }
}

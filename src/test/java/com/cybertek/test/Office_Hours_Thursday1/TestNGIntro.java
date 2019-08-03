package com.cybertek.test.Office_Hours_Thursday1;

import com.cybertek.test.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestNGIntro {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();

    }
    @BeforeMethod
    public void seUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");


    }

    @Test
    public void openEtsyTest(){

        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Etsy")).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals("https://www.etsy.com/",driver.getCurrentUrl());


    }
    @Test
    public void openGooleTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Google")).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals("https://www.google.com/",driver.getCurrentUrl());

    }
    @Test
    public void openAmazonTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Amazon")).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals("https://www.amazon.com/",driver.getCurrentUrl());

    }
    @Ignore
    @Test
    public void openYahooTest(){
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Yahoo")).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals("https://www.yahoo.com/",driver.getCurrentUrl());

    }
    @Test
    public void openFaceBookTest() {
        String currentWindow=driver.getWindowHandle();
        driver.findElement(By.id("dropdownMenuLink")).click();
        driver.findElement(By.linkText("Facebook")).click();
        SeleniumUtils.waitPlease(2);
        Set<String>windows=driver.getWindowHandles();
        for (String w:windows) {
            if(!currentWindow.equals(w)){
                driver.switchTo().window(w);
            }

        }
        Assert.assertEquals("https://www.facebook.com/", driver.getCurrentUrl());
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

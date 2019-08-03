package com.cybertek.test.Office_Hours_Thursday1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class July_11_TestNGPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://facebook.com");
    }

    @Test(priority = 2, description = "verify URL", timeOut = 4000,enabled = false)
    public void test1(){
        System.out.println("URL verify");
      String URL = driver.getCurrentUrl();
        System.out.println(URL.contains("www.facebook.com"));


    }
    @Test(priority = -10,description = "Verify Title", timeOut = 4000,enabled = false)
    public void test2(){
        System.out.println("Title verify");
        String title=driver.getTitle().toLowerCase();
        System.out.println(title.contains("facebook"));

    }

    /*
    TagName:button
    linText: sing Up
     */
    @Test(description = "verify Sing Up button")
    public void test3(){
      WebElement signUp=driver.findElement(By.cssSelector("button[type='submit']:nth-of-type(1)"));
      signUp.click();
        System.out.println(signUp.isEnabled());


    }
    @Test(description = "verify Sign Up button by LinTEXT", timeOut = 3000, enabled = false)
    public void test4(){
        WebElement SINGUP=driver.findElements(By.linkText("Sign Up")).get(0);
        SINGUP.click();
       System.out.println(SINGUP.isEnabled());

    }
    @AfterMethod
    public void teardown(){
        System.out.println("close browser");
        library.sleep(2);
        driver.quit();
    }

}

package com.cybertek.test.day10;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AbsoluteXpathDemo {

    //We did private because of that we use only inside of this class
   private WebDriver driver;
   String fullNameLocator="html/body/div/div[2]/div/div/form/div/div/input[@name='full_name']";
   String emailLocator="html/body/div/div[2]/div/div/form/div/div/input[@name='email']";
   String signUpLocator="html/body/div/div[2]/div/div/form/button[@name='wooden_spoon']";



    @BeforeMethod//--> it runs before every @Test
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");


    }
    @Test
    public void test1(){
        //find input box to enter nam
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("Parviz05");
        //find input box enter email
        driver.findElement(By.xpath(emailLocator)).sendKeys("Parviz05@gmail.com", Keys.ENTER);
        //find singup button and click on
       // driver.findElement(By.xpath(signUpLocator)).click();
        SeleniumUtils.waitPlease(2);
        // find actual message and store to the string variable
       String mesage= driver.findElement(By.xpath("/html/body/div/div[2]/div/div/h3[@name='signup_message']")).getText();
       // Make sure the message is equal to expecting message

        Assert.assertEquals(mesage,"Thank you for signing up. Click the button below to return to the home page.");
    }

    @Test
    public void negativeEmaliTest(){
        String expectedLink=driver.getCurrentUrl();
        driver.findElement(By.xpath(fullNameLocator)).sendKeys("To simith");
        driver.findElement(By.xpath(emailLocator)).sendKeys("email");
        driver.findElement(By.xpath(signUpLocator)).click();
        SeleniumUtils.waitPlease(2);
        String actualLink=driver.getCurrentUrl();

        Assert.assertEquals(actualLink,expectedLink);
    }
    @AfterMethod// it will run after every @Test
    public void teardown(){
        driver.quit();

    }
}

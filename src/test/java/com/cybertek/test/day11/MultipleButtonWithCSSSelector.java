package com.cybertek.test.day11;

import com.cybertek.test.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultipleButtonWithCSSSelector {


    String button1Locator="[onclick='button1()']";
    String button2Locator=".btn.btn-primary:nth-of-type(2)";//with class name . means class
    String button3Locator="[id^='button_']";// with starts-with ^ means starts-with()
    String button4Locator="[id$='_button'][onclick='button4()']";// with end-with $ means end with
    String button5Locator="[onclick*='5']";//with contains * means contains
    String button6Locator="#disappearing_button";
    String result="#result";



      WebDriver driver;
@BeforeClass
public void beforeClass(){
    WebDriverManager.chromedriver().setup();

}
@BeforeMethod
public void setUp(){
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://practice.cybertekschool.com/multiple_buttons");


}
@Test (priority = 1,description = "verifying button 1",enabled = false)// to disable the test like @ignore
public void button1Test(){
    driver.findElement(By.cssSelector(button1Locator)).click();
    String ActualMessage=driver.findElement(By.cssSelector(result)).getText();
    Assert.assertEquals(ActualMessage,"Clicked on button one!");
    SeleniumUtils.waitPlease(2);

    }

@Test(priority = 2,description = "verifying button 2")
public void button2Test(){
        driver.findElement(By.cssSelector(button2Locator)).click();
        String ActualMessage=driver.findElement(By.cssSelector(result)).getText();
        Assert.assertEquals(ActualMessage,"Clicked on button two!");
        SeleniumUtils.waitPlease(2);
       // throw new SkipException("Don not want to run this task");

    }
@Test(priority = 0, description = "verifying button 3",dependsOnMethods = {"button2Test"})
public void button3Test(){
    driver.findElement(By.cssSelector(button3Locator)).click();
    SeleniumUtils.waitPlease(2);
    String ActualMessage=driver.findElement(By.cssSelector(result)).getText();
    Assert.assertEquals(ActualMessage,"Clicked on button three!");
    SeleniumUtils.waitPlease(2);
}
@AfterMethod
public void teardown(){
    driver.quit();

}
}

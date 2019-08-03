package com.cybertek.test.day13_WebDriver_API;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTest {

    WebDriver driver;
    String startButtonLocator="#start >button";
    String userNameLocator="#username";
    String passwordLocator="#pwd";
    String submitButtonLocator="button[type='submit']";
    String loadingLocator="#loading";
    String enableButtonLocator ="#input-example>button";
    String removeButtonLocator="//button[text()='Remove']";
    String addButtonLocator="//button[text()='Add']";
    String rotorLocator="div[class='fa fa-cog fa-spin']";



    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void waitForVisibilityTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.cssSelector(startButtonLocator)).click();

        System.out.println(driver.findElement(By.cssSelector(loadingLocator)).getText());

        WebDriverWait wait=new WebDriverWait(driver,10);
        //wait until input box user name is visible
        //it works only one elements that u provided
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(userNameLocator))));


        driver.findElement(By.cssSelector(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.cssSelector(passwordLocator)).sendKeys("SuperSecretPassword");



        driver.findElement(By.cssSelector(submitButtonLocator)).click();
    }
   @Test
    public void waitForElementToBeClickableTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
       SeleniumUtils.waitPlease(2);
       WebDriverWait wait= new WebDriverWait(driver,10);

      // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(removeButtonLocator))));
        //driver.findElement(By.cssSelector(enableButtonLocator)).click();
        driver.findElement(By.xpath(removeButtonLocator)).click();
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(addButtonLocator))));
        driver.findElement(By.xpath(addButtonLocator)).click();
   }
    @Test
    public void waitForElementToBeClickableTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait= new WebDriverWait(driver,10);

        //we used this condition to wait the screen will disappear
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(rotorLocator))));
        //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(submitButtonLocator))));
        driver.findElement(By.cssSelector(submitButtonLocator)).click();


    }

}

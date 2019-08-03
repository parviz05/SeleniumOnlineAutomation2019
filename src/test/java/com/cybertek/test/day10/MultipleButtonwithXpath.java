package com.cybertek.test.day10;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MultipleButtonwithXpath {

    private WebDriver driver;
    //only buttons from 1-5
    String allBuuttons="//*[starts-with(@onclick,'button')]";
    String button1Locator="//button[.='Button 1']";// //button[1]
    String button2Locator="//*[contains(@name,'button2')]";
    String button3Locator="//button[starts-with(@id,'button_')]";
    String button4Locator="//button[contains(text(),'Button 4')]";
    String button5Locator="//button[5]";
    String button6Locator="//button[@id='disappearing_button']";
    String result="//p[@id='result']";



    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        SeleniumUtils.waitPlease(2);

    }
    @Test
    public void vertifyButton1(){
        driver.findElement(By.xpath(button1Locator)).click();
        SeleniumUtils.waitPlease(2);


        Assert.assertEquals(  driver.findElement(By.xpath(result)).getText(),"Clicked on button one!");

    }
    @Test
    public void vertifyButton2(){
        driver.findElement(By.xpath(button2Locator)).click();
        SeleniumUtils.waitPlease(2);


        Assert.assertEquals(  driver.findElement(By.xpath(result)).getText(),"Clicked on button two!");

    }

    
    @Test
    public void verifyButton3(){
        driver.findElement(By.xpath(button3Locator)).click();
        SeleniumUtils.waitPlease(2);


        Assert.assertEquals(  driver.findElement(By.xpath(result)).getText(),"Clicked on button three!");



    }
    @Test
    public void vertifyButton4(){
        driver.findElement(By.xpath(button4Locator)).click();
        SeleniumUtils.waitPlease(2);

        Assert.assertEquals(  driver.findElement(By.xpath(result)).getText(),"Clicked on button four!");


    }
    @Test
    public void verifyButton5(){
        driver.findElement(By.xpath(button5Locator)).click();
        SeleniumUtils.waitPlease(2);

        Assert.assertEquals(  driver.findElement(By.xpath(result)).getText(),"Clicked on button five!");


    }
    @Test
    public void verifyButton6(){

     driver.findElement(By.xpath(button6Locator)).click();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(  driver.findElement(By.xpath(result)).getText(),"Now it's gone!");
        //Assert.assertTrue(driver.findElement(By.xpath(button6Locator)).isDisplayed());//failed
        Assert.assertTrue(driver.findElements(By.xpath(button6Locator)).size()==0);

    }
    @Test
    public void clickAllButtons(){
        List<WebElement>list=driver.findElements(By.xpath(allBuuttons));
        for (WebElement eachButton:list) {

            eachButton.click();



        }
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}

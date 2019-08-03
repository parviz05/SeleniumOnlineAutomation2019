package com.cybertek.test.day12_VyTrack_Review;

import com.cybertek.test.Utilities.SeleniumUtils;
import com.cybertek.test.Utilities.VyTrackUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class Create_Calendar_EventsTest {

    WebDriver driver;
    String createCalentarButton="a[title='Create Calendar event']";
    String cancelButtonLocator="a[title='Cancel']";
    String saveAndCloseButtonLocator="//div/button[contains(text(),'Save and Close')]";
    String saveAndCloseDropdownLocator="a[data-toggle=dropdown][class^=btn]";
    String saveAndCloseOptionLocator="//li/button[contains(text(),'Save and Close')]";
    String saveAndNewOptionLocator="//li/button[contains(text(),'Save and New')]";
    String saveOptionLocator="(//li/button[contains(text(),'Save')])[3]";

    //
    String currentUserLocator="//li[@id='user-menu']";
    String selectedOwnerLocator=".select2-chosen";
    String defaultTitleLocator="//*[@id='oro_calendar_event_form_title-uid-5d32b984d8cb2']";
    String startingmonthLocator="[id^=date_selector_oro_calendar_event_form_start-uid]";
    String startingTime="[id^=time_selector_oro_calendar_event_form_start-uid";


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
    }
    @AfterMethod
    public void teardown(){
        SeleniumUtils.waitPlease(2);
        driver.quit();
    }
    @Test(description = "Verify Calendar Event Creation")
    public void salesManagerTest(){
        VyTrackUtilities.login(driver,"salesmanager273","UserUser123");
        SeleniumUtils.waitPlease(2);
        VyTrackUtilities.navigateToModule(driver,"Activities","Calendar Events");

        SeleniumUtils.clickWithWait(driver, By.cssSelector(createCalentarButton),3);
        SeleniumUtils.waitPlease(2);
        Assert.assertTrue(driver.findElement(By.cssSelector(cancelButtonLocator)).isDisplayed());

        //verify save and close button is displayed (visible)
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseButtonLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);


        Assert.assertTrue(driver.findElement(By.cssSelector(saveAndCloseDropdownLocator)).isDisplayed());
        SeleniumUtils.clickWithWait(driver,By.cssSelector(saveAndCloseDropdownLocator),3);
        Assert.assertTrue(driver.findElement(By.xpath(saveAndCloseOptionLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);
        Assert.assertTrue(driver.findElement(By.xpath(saveAndNewOptionLocator)).isDisplayed());
        SeleniumUtils.waitPlease(1);
        Assert.assertTrue(driver.findElement(By.xpath(saveOptionLocator)).isDisplayed());


    }
    @Test
    public void defaultOptionsTest(){
        VyTrackUtilities.login(driver,"SalesManager110","UserUser123");
       // SeleniumUtils.waitPlease(2);

        VyTrackUtilities.navigateToModule(driver,"Activities","Calendar Events");
       // SeleniumUtils.waitPlease(2);
        SeleniumUtils.clickWithWait(driver,By.cssSelector(createCalentarButton),3);
       // driver.findElement(By.xpath(createCalentarButton)).click();
        String currentOwner=driver.findElement(By.xpath(currentUserLocator)).getText().trim();
        String selectedOwner=driver.findElement(By.cssSelector(selectedOwnerLocator)).getText().trim();
        System.out.println(currentOwner);
        System.out.println(selectedOwner);
       Assert.assertEquals(currentOwner,selectedOwner);
       Assert.assertTrue(driver.findElements(By.xpath(defaultTitleLocator)).isEmpty());

       SeleniumUtils.waitPlease(1);

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyy"));
        String actualDate = driver.findElement(By.cssSelector(startingmonthLocator)).getAttribute("value");

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:mm a"));
        String actualTime = driver.findElement(By.cssSelector(startingTime)).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);
        Assert.assertEquals(actualTime, expectedTime);
    }
}

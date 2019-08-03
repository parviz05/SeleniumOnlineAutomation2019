package com.cybertek.test.day16;

import com.cybertek.page.vytrack.CalendarEventPage;
import com.cybertek.page.vytrack.LoginPage;
import com.cybertek.test.Utilities.ConfigurationReader;
import com.cybertek.test.Utilities.SeleniumUtils;
import com.cybertek.test.Utilities.VyTrackUtilities;
import com.cybertek.test.day15_properities_singleton_drive_test_base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventsTests extends TestBase {
    LoginPage loginpage=new LoginPage();
    CalendarEventPage calendareventspage=new CalendarEventPage();

    //@BeforeMethod is coming from TestBase

    @Test
    public void verifyRepeatOption(){
        //used loginPage for login
        String username= ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        loginpage.Login(username,password);

        //go calendar event
        VyTrackUtilities.navigateToModule(driver,"Activities","Calendar Events");

        //crete calendar event
        driver.findElement(By.cssSelector(calendareventspage.createCalendarEventBtnLocator)).click();
        //VyTrackUtilities.waitUntilLoaderScreenDisappear(driver);
        SeleniumUtils.waitPlease(2);

        //click checkbox
        driver.findElement(By.cssSelector(calendareventspage.repeatCkeckBoxLocator)).click();
        WebDriverWait wait= new WebDriverWait(driver,Long.valueOf(ConfigurationReader.getProperty("excplicitwait")));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(calendareventspage.repeatCkeckBoxLocator))));
        List<String>expectedOptions= Arrays.asList("Daily","Weekly","Monthly","Yearly");
        List<String>actualOptions=calendareventspage.getRepeatOptions();
        Assert.assertEquals(actualOptions,expectedOptions);

    }
//AfterMethod is coming from TestBase
    @Test
    public void DailyRepeatOptionRepeatEveryTest(){


    }
}

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

import java.util.concurrent.TimeUnit;

public class CreatButtonTest {
WebDriver driver;
String cearteButtonLocator="a[title='Log call']";// locator for log call button
String cearteClendarButtonLocator="a[title='Create Calendar event']";

@BeforeMethod
    public void SetUp(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://qa2.vytrack.com/user/login");
}

@Test
public void storeManagerTest(){
    //login
    VyTrackUtilities.login(driver,"storemanager85","UserUser123");

    //navigate to Call
    VyTrackUtilities.navigateToModule(driver,"Activities","Calls");

    //assert true button "log call" is displayed
    Assert.assertTrue(driver.findElement(By.cssSelector(cearteButtonLocator)).isDisplayed());

    SeleniumUtils.waitPlease(2);

    //navigate to the Clendar Event
    VyTrackUtilities.navigateToModule(driver,"Activities","Calendar Events");

    //verify to create button is displayed
    Assert.assertTrue(driver.findElement(By.cssSelector(cearteClendarButtonLocator)).isDisplayed());
}

@Test

public void salesManagerTest(){
    //login
    VyTrackUtilities.login(driver,"salesmanager273","UserUser123");

    //navigate to Call
    VyTrackUtilities.navigateToModule(driver,"Activities","Calls");

    //assert true button "log call" is displayed
    Assert.assertTrue(driver.findElement(By.cssSelector(cearteButtonLocator)).isDisplayed());

    SeleniumUtils.waitPlease(2);

    //navigate to the Clendar Event
    VyTrackUtilities.navigateToModule(driver,"Activities","Calendar Events");

    //verify to create button is displayed
    Assert.assertTrue(driver.findElement(By.cssSelector(cearteClendarButtonLocator)).isDisplayed());

}
@AfterMethod
    public void teardown(){
    SeleniumUtils.waitPlease(2);
    driver.quit();
}
}

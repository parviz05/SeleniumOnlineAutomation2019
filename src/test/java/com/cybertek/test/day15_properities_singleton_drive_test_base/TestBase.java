package com.cybertek.test.day15_properities_singleton_drive_test_base;

import com.cybertek.test.Utilities.ConfigurationReader;
        import com.cybertek.test.Utilities.Driver;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.interactions.Actions;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;

        import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver driver;
    public Actions actions;
    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        actions=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.valueOf(ConfigurationReader.getProperty("implicitmait")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.getProperty("url"));
    }
    @AfterMethod
    public void teardown(){

        Driver.closeDriver();
    }

}

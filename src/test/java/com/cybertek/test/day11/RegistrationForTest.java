package com.cybertek.test.day11;

import com.cybertek.test.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationForTest {

    WebDriver driver;
    String departmentLocator="[name='department']";






    @BeforeClass
  public void beforeClass(){
        WebDriverManager.chromedriver().setup();


  }
  @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/registration_form");
        SeleniumUtils.waitPlease(2);
    }
    @Test
    public void departmentTest(){

        Select selected=new Select(driver.findElement(By.cssSelector(departmentLocator)));

        List<WebElement>lists=selected.getOptions();
        for (WebElement list:lists) {
            System.out.println(list.getText());
        }

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

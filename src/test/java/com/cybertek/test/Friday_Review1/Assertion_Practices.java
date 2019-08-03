package com.cybertek.test.Friday_Review1;

import com.cybertek.test.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Assertion_Practices {


    WebDriver driver;


   @BeforeClass
    public void beforeClass(){
       WebDriverManager.chromedriver().setup();

   }
   @BeforeMethod
    public void setUp(){
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://www.facebook.com");
       SeleniumUtils.waitPlease(2);

   }
   @Test(description = "Verify URL & Title positive ",timeOut = 3000)
   public void test1(){


       //URL
       Assert.assertTrue(driver.getCurrentUrl().equals("https://www.facebook.com/"));
       Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

       //title
       Assert.assertTrue(driver.getTitle().toLowerCase().contains("facebook"));
       Assert.assertEquals(driver.getTitle(),"Facebook - Log In or Sign Up");
   }

   @Test(description = "Verify URL & Title Neqative")
    public void test2(){
       //URL
       Assert.assertFalse(driver.getCurrentUrl().equals("https://www.facebook.com"));
       Assert.assertFalse(driver.getTitle().contains("Google"));

    }

    @Test(description = "verify Birthday options")
    public void test3(){
       String month="Jul";
       int day=16;
       int year=1994;
        Select selectedMoth=new Select(driver.findElement(By.xpath("//select[@aria-label='Month']")));



    }
    @Test(description = "Verify dropdown Buttons working properly")
    public void test4(){

       driver.findElements(By.xpath("//select[@class='_5dba']"));
        List<WebElement>Lists=driver.findElements(By.xpath("//select[@class='_5dba']"));
        for (WebElement each:Lists) {
            each.click();
        }

        /*
          Verify that month, day and year is selected
         */

        //Select class is used tor handling drop down boxes with tagnameof select
        Select selectedMoth=new Select(driver.findElements(By.xpath("//select[@class='_5dba']")).get(0));
        //Verify July is selected as default
            List<WebElement> Months= selectedMoth.getOptions();
            WebElement July=null;
        for (WebElement eachMonth:Months) {
            if(eachMonth.getText().equals("Jul")){
                July=eachMonth;
                break;

            }

        }

        //Verify day16 is selected as default
        Select selectedDay=new Select(driver.findElements(By.xpath("//select[@class='_5dba']")).get(1));
        List<WebElement>Days=selectedDay.getOptions();
        WebElement Day16=null;
        for (WebElement eachDay:Days) {
            if(eachDay.getText().equals("16")){
                Day16=eachDay;
                break;
            }

        }
        //Verify year1994 is selected as default
        Select selectedyear=new Select(driver.findElements(By.xpath("//select[@class='_5dba']")).get(2));
        List<WebElement>Years=selectedyear.getOptions();
        WebElement year=null;
        for (WebElement eachYear:Years) {
            if (eachYear.getText().equals("1994")){
                year=eachYear;
                break;
            }

        }

        //Assert.assertTrue(July.isDisplayed());
        //Assert.assertTrue(Day16.isDisplayed());
       //Assert.assertTrue(year.isSelected());

        //Select by visible text
        selectedMoth.selectByVisibleText("Oct");//selected by visibleText
        selectedMoth.selectByValue("Jul");// selected by Value as String
        selectedMoth.selectByIndex(7);    // Selected by index

        selectedDay.selectByVisibleText("20");
        selectedyear.selectByVisibleText("2014");


    }
   @AfterMethod
    public void teardown(){
       SeleniumUtils.waitPlease(2);
       driver.quit();
   }
}

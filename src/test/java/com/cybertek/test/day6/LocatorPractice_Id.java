package com.cybertek.test.day6;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorPractice_Id {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
       // test1();
        test2();
        test3();
        test4();
    }
    //negative test, we will use wrong id to locate element
    public static void test1(){

        driver.manage().window().maximize();
        //selenium will wait 10 second for element, if within 10 second will not show up u will get
        //NoSuchElementException: no such element:
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.id("woodenspoon")).click();
        library.sleep(3);// threat.sleep suspend java execution on certain time
        driver.quit();

    }
    public static void test2(){
        driver.manage().window().maximize();
        //this must be use, otherwise u will get many trouble
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        library.sleep(2.5);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        library.sleep(2.5);
        driver.findElement(By.id("wooden_spoon")).click();
        library.sleep(2.5);
       // driver.quit();


    }
    public static void test3(){
        String expected;
     //String expectedMessage="Welcome to the Secure Area. When you are done click logout below.";
    // String actualMessage=driver.findElement(By.className("subheader")).getText();
    // SeleniumUtils.verifyEquals(expectedMessage,actualMessage);
   //  SeleniumUtils.verifyEquals(expectedMessage,driver.findElement(By.className("subheader")).getText());
       SeleniumUtils.verifyEquals(expected="Welcome to the Secure Area. When you are done click logout below.",driver.findElement(By.className("subheader")).getText());
    }

    public static void test4(){
      //  driver.findElement(By.className("icon-2x icon-signout")).click();
        driver.findElement(By.linkText("Logout")).click();
        library.sleep(4);
        driver.quit();
    }
}

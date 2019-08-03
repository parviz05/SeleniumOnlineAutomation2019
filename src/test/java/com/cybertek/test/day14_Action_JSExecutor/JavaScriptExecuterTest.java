package com.cybertek.test.day14_Action_JSExecutor;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecuterTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void jsExecutorTest1(){
        driver.get("http://practice.cybertekschool.com/");

        /*We want to run some javaScript code
        for this , we have to use JavaScriptExecutor interface
        since it's an interface, we cannot create an object
        we just have to cast WebDriver
         */
        JavascriptExecutor js=(JavascriptExecutor) driver;
        /*
        And then we execute script itself
        we call ExecuteScript() method
        executeScript return an object
         */

        String title=(String) js.executeScript("return document.title");
        /*
        or u can execute some script without any return
         */
        js.executeScript("alert('HELLO SPARTAN!!!')");
        SeleniumUtils.waitPlease(3);

        /*
        Alert interface handles alerts
        what is alert?
        It looks like pop up window
         */

        Alert alert=driver.switchTo().alert();
        /*
        We can use accept() METHOD to select Ok in the pop up
         */
        alert.accept();
        SeleniumUtils.waitPlease(3);
        System.out.println(title);

    }
    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        for (int i=0;i<10;i++) {
            js.executeScript("window.scrollBy(0,500)");
            SeleniumUtils.waitPlease(1);
        }
    }
    @Test
    public void scrollTest2(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement footerLink=driver.findElement(By.cssSelector("a[target='_blank']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        SeleniumUtils.waitPlease(2);
        /*
        scroll untill footerLink is not visible
        Once u see footerLink, Script will stop scrolling
         */
        js.executeScript("arguments[0].scrollIntoView(true)" ,footerLink);
        SeleniumUtils.waitPlease(2);

        // to click with jsexecuter
        js.executeScript("arguments[0].click()", footerLink);
        SeleniumUtils.waitPlease(1);

    }
}

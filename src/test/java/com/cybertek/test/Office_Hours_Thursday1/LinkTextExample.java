package com.cybertek.test.Office_Hours_Thursday1;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkTextExample {
    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

     // test1();
      test2();
    }
    public static void test1(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.linkText("A/B Testing")).click();
        SeleniumUtils.waitPlease(3);
        driver.navigate().back();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.linkText("Dropdown")).click();
        SeleniumUtils.waitPlease(3);
        driver.close();

    }
    public static void test2(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
      //  SeleniumUtils.waitPlease(3);
        List<WebElement>links=driver.findElements(By.tagName("a"));
        for ( int i=1;i<=links.size();i++) {
            //if it;s 5th link, skip it
            if (i== 4) {
                continue;
            }
              //  SeleniumUtils.waitPlease(3);
                links.get(i).click();
               // SeleniumUtils.waitPlease(3);
                driver.navigate().back();
               // SeleniumUtils.waitPlease(3);
            /*
            We have to find all elements again , otherwise  we will get StaleExceptionReeferenceException
             */
                links = driver.findElements(By.tagName("a"));
                System.out.println(links.get(i).getText());
            }
        SeleniumUtils.waitPlease(3);
        driver.close();
    }
}

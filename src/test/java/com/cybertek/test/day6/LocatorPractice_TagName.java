package com.cybertek.test.day6;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorPractice_TagName {

   static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        //we will execute our tests
        //We will create separate method for every test

        //TASK: FIND ALL BUTTONS,  put the in the list , and click on them one by one.

test1();

    }
    public static void test1(){
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get("http://practice.cybertekschool.com/multiple_buttons");

       //How to find all button?



         //We  use findElements to find multiple elements
        // Then, we have to store them in the list
        List<WebElement>buttons=driver.findElements(By.tagName("button"));
        System.out.println("size: "+buttons.size());
        for(WebElement button:buttons){
            System.out.println( button.getText());
            library.sleep(3);
            button.click();
            library.sleep(3);
        }
        driver.close();

    }
}

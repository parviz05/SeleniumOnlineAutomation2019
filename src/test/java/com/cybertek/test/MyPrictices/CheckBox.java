package com.cybertek.test.MyPrictices;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {


    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        methodChek();
    }

    public static void methodChek(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        List<WebElement>chekboxes=driver.findElements(By.xpath("//*[@id='checkboxes']/input[1]"));


        for (WebElement checkBox:chekboxes) {
            library.sleep(2.5);
            checkBox.click();
            library.sleep(2.5);
            checkBox.click();
            library.sleep(2.5);

        }
driver.close();

    }
}

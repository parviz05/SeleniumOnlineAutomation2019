package com.cybertek.test.day6;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LocatorPractice_Xpath {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        Method1();
    }
    public static void Method1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/sign_up");
        library.sleep(2.5);
        driver.findElement(By.xpath("//*[@id='login']/div[1]/div/input")).sendKeys("parviz");
        library.sleep(2.5);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("aa.apal@gmail.com");
        library.sleep(2.5);
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        library.sleep(2.5);
        driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]/i")).click();
        library.sleep(2.5);
        driver.quit();

    }

}


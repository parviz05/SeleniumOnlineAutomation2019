package com.cybertek.test.Group_Procejt;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Login_Functionalityt {

    static WebDriver driver= BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
//PracticeLogin();
VyTrackLogin();

    }
    public static void PracticeLogin(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/login");
        SeleniumUtils.waitPlease(2);//*[@id='flash-messages']
        driver.findElement(By.name("username")).sendKeys("tom smith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        SeleniumUtils.waitPlease(2);
        String message=driver.findElement(By.xpath("//*[@id='flash-messages']")).getText();
        String expected="Your username is invalid!";
        System.out.println(message.length());
        if(message.substring(0,message.length()-2).equals(expected)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();

    }
    public static void VyTrackLogin(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user177");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        SeleniumUtils.waitPlease(2);
        String expectedTitle="Dashboard";
        SeleniumUtils.verifyEquals(expectedTitle,driver.getTitle());
        driver.findElement(By.linkText("Logout")).click();
        SeleniumUtils.waitPlease(2);
        driver.close();
    }
}

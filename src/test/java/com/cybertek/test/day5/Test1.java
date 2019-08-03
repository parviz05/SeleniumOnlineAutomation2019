package com.cybertek.test.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();//setup web driver
        //driver will give us access to the browser
        WebDriver driver=new ChromeDriver();// create Object of chrome driver
        driver.manage().window().maximize();//to maximize the browser
        driver.get("http://practice.cybertekschool.com/forgot_password");//open url

        WebElement emailInputBox=driver.findElement(By.name("email"));// found input box

        WebElement SubmitButon=driver.findElement(By.id("form_submit"));// found submit button
        emailInputBox.sendKeys("ali.asc@gmail.com");// to enter text
        Thread.sleep(2000);
        SubmitButon.click();// we are click submit button
        Thread.sleep(2000);

        WebElement confirmationMessage= driver.findElement(By.name("confirmation_message"));
        String expectedMessage="Your e-mail's been sent!";

        //we verfy that actual message is same with expected message
        String actualMessage=confirmationMessage.getText();
        if(actualMessage.equals(expectedMessage)){
            System.out.println("Test Passed");

        }else{
            System.out.println("Test failed");
            System.out.println("expectingMessage: "+expectedMessage);
            System.out.println("Actual Message: "+actualMessage);
        }


        driver.close();

    }
}

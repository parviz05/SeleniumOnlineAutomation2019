package com.cybertek.test.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();//setup web driver
        //driver will give us access to the browser
        WebDriver driver=new ChromeDriver();// create Object of chrome driver
        driver.manage().window().maximize();//to maximize the browser
        driver.get("http://practice.cybertekschool.com/forgot_password");//open url

        WebElement emailInputBox=driver.findElement(By.name("email"));// found input box

        WebElement SubmitButon=driver.findElement(By.id("form_submit"));// found submit button

       emailInputBox.sendKeys("sdetpro3000@gmail.com");//to enter text into input box

        System.out.println(emailInputBox.getAttribute("pattern"));//to read the patern of attributes
        System.out.println(emailInputBox.getAttribute("value"));//value it's a text u enter into box

        Thread.sleep(2000);
        SubmitButon.submit();//it works only with button. Click method is more FLEXIBLE



        Thread.sleep(2000);

        driver.close();
    }
}

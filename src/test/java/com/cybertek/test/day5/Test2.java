package com.cybertek.test.day5;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();//setup web driver
        //driver will give us access to the browser
        WebDriver driver=new ChromeDriver();// create Object of chrome driver
        driver.manage().window().maximize();//to maximize the browser
        driver.get("http://practice.cybertekschool.com/forgot_password");//open url

        WebElement emailInputBox=driver.findElement(By.name("email"));// found input box

        WebElement SubmitButon=driver.findElement(By.id("form_submit"));// found submit button

        Faker faker=new Faker();
        String name=faker.pokemon().name().replace(" ","").toLowerCase();

        Thread.sleep(2000);
        emailInputBox.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
        emailInputBox.clear();//clear text from input box
        Thread.sleep(2000);

        emailInputBox.sendKeys(name+"@gmail.com", Keys.ENTER);// to enter text and hit enter button
        Thread.sleep(2000);

        driver.close();
    }
}

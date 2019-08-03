package com.cybertek.test.MyPrictices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class VYTruck_test_Login {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://qa2.vytrack.com/user/login");

        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);

        WebElement user=driver.findElement(By.id("prependedInput"));
        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);

        user.sendKeys("user177");

        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);

        WebElement passwor=driver.findElement(By.id("prependedInput2"));

        passwor.sendKeys("UserUser123");

        WebElement submit=driver.findElement(By.id("_submit"));

        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);
        submit.click();


        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);

       List<WebElement> classes=driver.findElements(By.className("divider"));
        System.out.println(classes.size());

        WebElement fleet=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/a/span"));
        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);
        fleet.click();

        WebElement odometer=driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span"));

        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);
        odometer.click();

        com.cybertek.test.Office_Hours_Thursday1.library.sleep(4);
        driver.close();


    }
}

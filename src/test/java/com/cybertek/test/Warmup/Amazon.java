package com.cybertek.test.Warmup;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Amazon {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        searchTerm();
    }
    public static void searchTerm(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("book");

        library.sleep(2);
        driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();

        String title=driver.getTitle();


        if(title.contains("Book") ){
            System.out.println("pass");
        }else{
            System.out.println("failed");
        }
        driver.quit();
    }
}

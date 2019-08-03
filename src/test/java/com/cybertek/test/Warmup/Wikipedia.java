package com.cybertek.test.Warmup;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Wikipedia {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        searchTerm();
    }
    public static void searchTerm(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://www.wikipedia.org/");

        library.sleep(2);
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        library.sleep(2);
        driver.findElement(By.linkText("Selenium (software)")).click();
        library.sleep(2);
        String url=driver.getCurrentUrl();

        if(url.endsWith("x")){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        System.out.println(url);
        driver.quit();
    }

}

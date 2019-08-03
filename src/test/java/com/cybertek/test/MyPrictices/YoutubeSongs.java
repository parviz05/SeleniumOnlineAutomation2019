package com.cybertek.test.MyPrictices;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class YoutubeSongs {


    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
playList();
    }
    public static void playList(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        List<String>lists= Arrays.asList("sensizem","dediler","ama yene qurur o meni vurur");
        for (String each:lists){
            driver.findElement(By.id("search")).sendKeys(each, Keys.ENTER);


            driver.findElement(By.xpath("//*[@class='text-wrapper style-scope ytd-video-renderer'][1]")).click();
            SeleniumUtils.waitPlease(10);
            driver.navigate().back();
            SeleniumUtils.waitPlease(10);
            driver.navigate().back();



        }
driver.quit();
    }
}

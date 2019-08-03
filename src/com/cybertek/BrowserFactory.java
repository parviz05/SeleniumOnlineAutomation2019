package com.cybertek;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    public static WebDriver getDriver(String browser){


        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if(browser.equals("firefox")){
            return new FirefoxDriver();

        }else{
            return null;
        }
    }

}

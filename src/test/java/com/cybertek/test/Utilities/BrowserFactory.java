package com.cybertek.test.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browsers){
        /*
        @param browser name
        @return browser object, otherwise throw exception  to prevent test run
         */
        if(browsers.equals("chrome")){

            WebDriverManager.chromedriver().setup();

            return new ChromeDriver();
        }else if(browsers.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else if(browsers.equals("safari")){

            return new SafariDriver();

        }else {
            throw new IllegalArgumentException("Wrong browser name!");
        }
    }
}

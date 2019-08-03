package com.cybertek.test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory2 {

    public static WebDriver driver;

    //to privent object creation
    private BrowserFactory2(){

    }
//synchronized needs to yeld threads. So we will make that during parallel execution our test will not break
    public synchronized static WebDriver getDriver(String browser){

        if(driver!=null){
            if(browser.equals("chrome")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }else if(browser.equals("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }else{
                throw new IllegalArgumentException("Wrong driver name");
            }
        }
        return driver;
    }
}

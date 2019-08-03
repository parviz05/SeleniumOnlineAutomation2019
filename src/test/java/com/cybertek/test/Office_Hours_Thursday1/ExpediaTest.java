package com.cybertek.test.Office_Hours_Thursday1;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExpediaTest {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        test1();
        flightsTest();
    }

    public static void test1(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://expedia.com");
        String expected="Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations";
        String actual=driver.getTitle();
        SeleniumUtils.verifyEquals(expected,actual);

    }
    public  static void flightsTest(){
        driver.findElement(By.id("tab-flight-tab-hp")).click();
        driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Houston, TX (IAH-George Bush Intercontinental)");
        library.sleep(2.5);
        driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("New York, NY (JFK-John F. Kennedy Intl.)");
        library.sleep(2.5);
        driver.findElement(By.id("flight-departing-hp-flight")).sendKeys("07/10/2019");
        library.sleep(2.5);
        driver.findElement(By.id("flight-returning-hp-flight")).sendKeys("07/16/2019");
      //driver.findElement(By.xpath("//*[@id='traveler-selector-hp-flight']/div/ul/li/div/div/div/div[1]/div[4]/button/span[1]/svg"));
        library.sleep(2.5);
        driver.findElement(By.xpath("(//button[@class='btn-primary btn-action gcw-submit'])[1]")).click();
       // myMethod();
        library.sleep(10);
        driver.quit();
    }
    public static void myMethod(){

        List<WebElement>buttons=driver.findElements(By.xpath("//button[@ class='btn-primary btn-action gcw-submit']"));
        for (WebElement search:buttons) {
            search.click();

        }
    }
}

package com.cybertek.test.Home_Work;

import com.cybertek.test.Office_Hours_Thursday1.library;
import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocatorsHomeWork {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        googlrTitle();
        etsySearchTest();
        VYTrucktitleTest();
        shortcutFunctionality();

    }
    public static void googlrTitle(){
        driver.manage().window().maximize();
        driver.get("https://google.com");
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
        for (String each:searchStrs) {
            driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(each, Keys.ENTER);

            String url1 = driver.findElement(By.xpath("//cite[@class='iUh30'][1]")).getText();
            driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
            String url2 = driver.getCurrentUrl();
            SeleniumUtils.verifyEquals(url1, url2);
            driver.navigate().back();
        }
        driver.close();

    }
    public static void etsySearchTest(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ebay.com");
        library.sleep(2);
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon", Keys.ENTER);
        library.sleep(2);
        String resutl= driver.findElement(By.xpath("//*[@id=\"w4\"]/div[2]/div[1]/div[1]/h1")).getText();
        System.out.println(resutl);
        driver.findElement(By.partialLinkText("All")).click();
        String allresult=driver.findElement(By.xpath("//*[@id=\"w4\"]/div[2]/div[1]/div[1]/h1")).getText();
        System.out.println(allresult);
        Integer num1=Integer.valueOf(resutl.substring(0,resutl.length()-8).replace(",",""));
        Integer num2=Integer.valueOf(allresult.substring(0,allresult.length()-8).replace(",",""));

        if(num1<num2){
            System.out.println("passed");
        }else{
            System.out.println("failed");

        }
        driver.navigate().back();
        library.sleep(2);
        String actual=driver.findElement(By.id("gh-ac")).getAttribute("value");
        String expected="wooden spoon";
        library.sleep(2);
        SeleniumUtils.verifyEquals(expected,actual);
        library.sleep(2);
        driver.quit();

    }
    public static void VYTrucktitleTest(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user177");
        library.sleep(2.5);
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        library.sleep(2.5);
        driver.findElement(By.id("_submit")).click();
        library.sleep(2.5);
        driver.findElement(By.xpath("//*[@id='user-menu']/a")).click();
        library.sleep(2.5);
        driver.findElement(By.xpath("//*[@id='user-menu']/ul/li[2]/a")).click();
        library.sleep(2.5);
        String expectedTitle="Alex Jones - Configure - Users - User Management - System";
        String actualTitle=driver.getTitle();
        library.sleep(2.5);
        SeleniumUtils.verifyEquals(expectedTitle,actualTitle);
        library.sleep(2.5);
        driver.close();
    }

    public static void shortcutFunctionality(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager210");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
       library.sleep(3);
       String title1="Dashboard";
        SeleniumUtils.verifyEquals(title1, driver.getTitle());
        driver.findElement(By.className("fa-share-square")).click();
        driver.findElement(By.linkText("See full list")).click();
        driver.findElement(By.linkText("Opportunities")).click();
        library.sleep(3);
        String expectedtitle="Open Opportunities - Opportunities - Sales";
        SeleniumUtils.verifyEquals(expectedtitle,driver.getTitle());
        library.sleep(3);
        driver.findElement(By.className("fa-share-square")).click();
        library.sleep(3);
        driver.findElement(By.xpath("//input[@placeholder='Enter shortcut action']")).sendKeys("Vehicle Services Logs");
        driver.findElement(By.xpath("//li[@data-value='Vehicle Services Logs']")).click();
        library.sleep(3);
        String message = driver.findElement(By.xpath("//div[@class='message']")).getText();
        //System.out.println(message);
        SeleniumUtils.verifyEquals("You do not have permission to perform this action.", message);
        library.sleep(3);

        SeleniumUtils.verifyEquals("Open Opportunities - Opportunities - Sales",driver.getTitle());
        library.sleep(3);
        driver.quit();




    }


}

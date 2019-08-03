package com.cybertek.test.Group_Procejt;

import com.cybertek.test.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Brite_ERP {
    WebDriver driver;
    String usernameLocator = "login";
    String passwordLocator = "password";
    String CRMLocator = "CRM";
    String listLocator = "button[aria-label='list']";
    String checkBoxLocator = "(//td/div[@class='o_checkbox']/input)[1]";
    String actionbuttonLocator = "(//button[@aria-expanded='false'])[2]";
    String okButtonLocator = "//div/button/span[contains(text(),'Ok')]";
    String listCountLocator = "div span[class='o_pager_limit']";

    ///
    String privotLocator="button[data-view-type='pivot']";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");

    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test()
    public void CRM_OpportunityTest() {
        //enter user name
        driver.findElement(By.id(usernameLocator)).sendKeys("eventscrmmanager61@info.com");

        //enter password
        driver.findElement(By.id(passwordLocator)).sendKeys("eventscrmmanager", Keys.ENTER);
        SeleniumUtils.waitPlease(1);

        //click on CRM button
        driver.findElement(By.linkText(CRMLocator)).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.cssSelector(listLocator)).click();
        SeleniumUtils.waitPlease(3);
        //verify that the list is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector("div span[class='o_pager_limit']")).isDisplayed());
        //to get current list count
        String listCountBeforeDelete = driver.findElement(By.cssSelector("div span[class='o_pager_limit']")).getText();
        System.out.println(listCountBeforeDelete);
        SeleniumUtils.waitPlease(2);

        //click on checkbox button
        List<WebElement> lists=driver.findElements(By.xpath("//td/div[@class='o_checkbox']/input"));
        Random rendom=new Random();
        int any = rendom.nextInt(2);
        String anyElement="td div input[type=checkbox]:nth-of-type("+any+1+")";
        driver.findElement(By.cssSelector(anyElement)).click();

//
//        WebElement checkboxButton = driver.findElement(By.xpath(checkBoxLocator));
//        checkboxButton.click();
        SeleniumUtils.waitPlease(2);
        //click on action button
        driver.findElement(By.xpath(actionbuttonLocator)).click();
        //used the expliced way to make visible the delete buton
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("li a[data-index='3']"))));
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector("li a[data-index='3']")).click();
        SeleniumUtils.waitPlease(2);
        //click on Ok button
        driver.findElement(By.xpath(okButtonLocator)).click();
        SeleniumUtils.waitPlease(2);
        String listCountAfterDelet = driver.findElement(By.cssSelector("div span[class='o_pager_limit']")).getText();
        System.out.println(listCountAfterDelet);
        int num1 = Integer.parseInt(listCountBeforeDelete);
        int num2 = Integer.parseInt(listCountAfterDelet);
        Assert.assertFalse(num1 == num2);

    }
    /*
    ● Describe your project
    ● Which programming language is used?
    ● Which core java concept is being used?
    ● Which testing tools did you use?
    ● Which IDE is used?
    ● Which browser did you use?
    ● What is your software methodology?
    ● Why selenium is used as a testing tool?
     */

    @Test
    public void pivotBoardTest(){
        //enter user name
        driver.findElement(By.id(usernameLocator)).sendKeys("eventscrmmanager61@info.com");
        //enter password
        driver.findElement(By.id(passwordLocator)).sendKeys("eventscrmmanager", Keys.ENTER);
        SeleniumUtils.waitPlease(1);
        //click on CRM button
        driver.findElement(By.linkText(CRMLocator)).click();
        SeleniumUtils.waitPlease(3);


    }
}

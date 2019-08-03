package com.cybertek.test.day14_Action_JSExecutor;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionClassTest {


    WebDriver driver;

    //hover
    String user1TextLocator="//a[@href='/users/1']/preceding-sibling::h5";
    String firstImageLocator="(//img)[1]";
    String enabledOptionLocator="ui-id-3";
    String downloadLocator="ui-id-4";
    String pdfLocator="ui-id-5";

    //drag and dropt
    String moonLocator="draggable";
    String EarthLoactor="droptarget";


    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void hoverTest(){
        driver.get("http://practice.cybertekschool.com/hovers");

        //we are creationg object of action class
        //we have provide object of WebDriver
        Actions action=new Actions(driver);

        //hover on element
        action.moveToElement(driver.findElement(By.xpath(firstImageLocator))).perform();
        String expectedText="name: user1";
        String actualText=driver.findElement(By.xpath(user1TextLocator)).getText();

        //verify that after hover event text is visible
        Assert.assertTrue(driver.findElement(By.xpath(user1TextLocator)).isDisplayed());
        Assert.assertEquals(actualText,expectedText);
    }
    @Test
    public void hoverTest2(){
        driver.get("http://practice.cybertekschool.com/hovers");

        //we are creationg object of action class
        //we have provide object of WebDriver
        Actions action=new Actions(driver);
        List<WebElement>ListsOfImmage=driver.findElements(By.tagName("img"));
        for (WebElement img:ListsOfImmage) {
            SeleniumUtils.waitPlease(2);
            action.moveToElement(img).perform();
        }



    }
    @Test
    public void hoverTest3(){

        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Actions action=new Actions(driver);
        WebElement enabledElement= driver.findElement(By.id(enabledOptionLocator));
        WebElement downloadElement=driver.findElement(By.id(downloadLocator));
        WebElement pdfElement=driver.findElement(By.id(pdfLocator));
        action.moveToElement(enabledElement).
                pause(1000).moveToElement(downloadElement).
                pause(1000).moveToElement(pdfElement).
                click().
                build().perform();
        SeleniumUtils.waitPlease(2);



    }
    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions action =new Actions(driver);
        WebElement moon=driver.findElement(By.id(moonLocator));
        WebElement Earth=driver.findElement(By.id(EarthLoactor));
        action.dragAndDrop(moon,Earth).perform();

        //once we completed drag and drop operation, we expect to see this message
        String expectedText="You did great!";
        String actualText=Earth.getText();
        System.out.println(actualText);
        Assert.assertTrue(Earth.isDisplayed());
        Assert.assertEquals(actualText,expectedText);



        SeleniumUtils.waitPlease(1);

    }

}

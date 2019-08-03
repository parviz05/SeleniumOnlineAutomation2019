package com.cybertek.test.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {

    public static void verifyEquals(String expectedResult, String actualResult){
        /**
        @expectedResult
        @actualResult
        To verify that these two strings are equal
         */

        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");


        }else{
            System.out.println("Failed");
            System.out.println("Expected Result is: "+expectedResult);
            System.out.println("Actual Result is: "+actualResult);
        }



    }
    /**
    This Metod wil put on pause execution of java code
    @param second
     */
    public static void waitPlease(int second){
       try {
           Thread.sleep(second*1000);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

    }

    /**
     * This method will open base on link name
     * @param page
     * @param driver
     */
    public static void openPage(String page, WebDriver driver){
        // we will find all examples on the home page
        List<WebElement>listOfExamples=driver.findElements(By.tagName("a"));
        for (WebElement example:listOfExamples) {
            if(example.getText().contains(page)){
                example.click();
                break;
            }

        }
    }


    /**
     *
     * @param element
     */
    public static void verifyIsDisplay(WebElement element){
        if(element.isDisplayed()){
            System.out.println("passed");
            System.out.println(element.getText()+": is visible");
        }else{
            System.out.println("failed");
            System.out.println(element.getText()+": is not visible");
        }
    }

    /**
     * this method will recover in case of exception after unsuccessful the click, and will try to click on element again
     * @param driver
     * @param by
     * @param attempts
     */
    public static void clickWithWait(WebDriver driver,By by,int attempts){
        int counter=0;
        //click on element as many as you specified in attemps parameter
        while (counter<attempts) {
            try {
                //selenium must look element agian
                driver.findElement(by).click();
                break;// if click successful- then break

            } catch (WebDriverException e) {
                //if click failed
                //print exception
                System.out.println(e);
                System.out.println("Attent::" + ++counter);
                //wait 1 second and then try again
                 waitPlease(2);

            }
        }
    }
}

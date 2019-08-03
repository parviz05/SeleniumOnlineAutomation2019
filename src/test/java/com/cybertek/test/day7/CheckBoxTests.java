package com.cybertek.test.day7;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class CheckBoxTests {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

       // test1();
        test2();

    }
    public static void openCheckBoxesPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //we will able to make sure that check box is visible, not only in the code
        WebElement checkboxesLogo=driver.findElement(By.tagName("h3"));
        if(checkboxesLogo.isDisplayed()){
            System.out.println("Checkboxes logo is visible ");
        }else {
            System.out.println("Checkboxes logo not found ");
        }


    }
    // check if checkbox 1 is not selected and checkbox 2 is selected
    public static void test1(){
        openCheckBoxesPage();
        WebElement checkbox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if((!checkbox1.isSelected()&&checkbox2.isSelected())){
            System.out.println("Checkbox 1 Is not selected ");

        }else{
            System.out.println("Checkbox 2 Is not selected ");

        }
        SeleniumUtils.waitPlease(3);
        driver.close();
    }
    public static void test2(){
        openCheckBoxesPage();
        WebElement checkbox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        checkbox1.click();
        checkbox2.click();
        if(checkbox1.isSelected()&&(!checkbox2.isSelected())){
            System.out.println("Checkbox 1 Is  selected");
        }else{
            System.out.println("Checkbox 2 Is not selected");


        }
        SeleniumUtils.waitPlease(3);
        driver.close();

    }

}

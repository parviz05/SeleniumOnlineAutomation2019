package com.cybertek.test.day7;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RadioButtonTest {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
        openRadioPage();
        //test1();
        //test2();
        //test3();
        test4();
        driver.close();

    }
    public static void openRadioPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/radio_buttons");

    }
    public static void test1(){
        driver.findElement(By.id("blue"));
        if(driver.findElement(By.id("blue")).isSelected()){
            System.out.println("Pased");
        }else {
            System.out.println("failed");
        }
        SeleniumUtils.waitPlease(2);
    }
    public static void test2(){
        WebElement blackBtn=driver.findElement(By.id("black"));
        WebElement greenBtn=driver.findElement(By.id("green"));

        if(blackBtn.isEnabled() && (!greenBtn.isEnabled())){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
        }
    }
    public static void test3(){
        WebElement blueBtn=driver.findElement(By.id("blue"));
        WebElement blackBtn=driver.findElement(By.id("black"));
        SeleniumUtils.waitPlease(2);
        blackBtn.click();
        if((!blueBtn.isSelected())&& blackBtn.isSelected()){
            System.out.println("passed");
            System.out.println("back button selected ");
        }else{
            System.out.println("failed");
            System.out.println("blue button selected ");
        }
        SeleniumUtils.waitPlease(2);
    }
    public static void test4(){
        List<WebElement>listOfRadioButtons=driver.findElements(By.xpath("//input[@type='radio']"));
        int counter=0;//count how many button selected
        for (WebElement radioButton:listOfRadioButtons) {
            SeleniumUtils.waitPlease(2);
            //radioButton.click();

            if(radioButton.isSelected()){
                counter++;
                System.out.println(radioButton.getAttribute("id"));// need to find which button has selected that is why we used id
            }
        }
        System.out.println(counter);
    }
}

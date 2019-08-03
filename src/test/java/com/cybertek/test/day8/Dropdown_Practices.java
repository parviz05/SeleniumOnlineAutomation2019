package com.cybertek.test.day8;

import com.cybertek.test.Utilities.BrowserFactory;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dropdown_Practices {

    static WebDriver driver= BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {

        openDropDownPage();
        SeleniumUtils.waitPlease(3);
        //test1();
        //test2();
       // test3()
      // test4();
      //  test5();
       // test6();
        test7();

        driver.close();
    }
    public static void openDropDownPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element=driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.verifyIsDisplay(element);

    }
    public static void test1(){
        WebElement dropdown1=driver.findElement(By.id("dropdown"));
        /*
        To work with select element we need to use Select class
        don not forget to pass web element of that dropdown that u found in to constructor
         */
        Select dropdownSelect= new Select(dropdown1);
        /*
        since dropdown consist of options
        we can check which one selected
        this method dropdownSelect.getFirstSelectedOption() return web element,
        use getText() method if u want to get a text of this option, Usually text is a visible
        part of dropdown. Value or other attributes of drop down , not visible
         */
        String actual=dropdownSelect.getFirstSelectedOption().getText();
        String expected="Please select an option";
        SeleniumUtils.verifyEquals(expected,actual);
        System.out.println(actual);
        /*

         */
        List<WebElement>options=dropdownSelect.getOptions();
        int count=0;
        for (WebElement option:options) {
            count++;

        }
        System.out.println(count);
    }
    public static void test2(){
        WebElement state=driver.findElement(By.id("state"));
        Select selectedStates=new Select(state);

        String actual=selectedStates.getFirstSelectedOption().getText();
        System.out.println(actual);
        SeleniumUtils.verifyEquals("Select a State",actual);

        List<WebElement>states=selectedStates.getOptions();
        for (WebElement eachState:states) {
            System.out.println( eachState.getText());
        }
            selectedStates.selectByVisibleText("Virginia");
            SeleniumUtils.waitPlease(2);
            selectedStates.selectByVisibleText("Texas");
            SeleniumUtils.waitPlease(2);

    }
    public static void test3() {
        WebElement state = driver.findElement(By.id("state"));
        //Object of select class
        //it has methods that helps to work with drop downs
        Select selectedStates = new Select(state);
        /*
        We fount all options that are available to select
         */
        List<WebElement> states = selectedStates.getOptions();
        /*
        we loop through all options
         */
        for (WebElement each : states) {
            SeleniumUtils.waitPlease(1);
            /*
            And select ever options by text
            <options value>="PA">Pennsylvania and select it
            means find toption that has text Pennsylvania and select it
             */
            selectedStates.selectByVisibleText(each.getText());
        }
    }
    public static void test4(){
        WebElement state = driver.findElement(By.id("state"));
        Select selectedStates = new Select(state);
        List<WebElement>states=selectedStates.getOptions();
            selectedStates.selectByValue("PA");
            SeleniumUtils.waitPlease(2);

            String expected="Pennsylvania";
            //read options is selected
            String actual=selectedStates.getFirstSelectedOption().getText();
            SeleniumUtils.verifyEquals(expected,actual);



    }
    public static void test5(){
        WebElement state = driver.findElement(By.id("state"));
        Select selectedStates = new Select(state);
        List<WebElement>states=selectedStates.getOptions();
        SeleniumUtils.waitPlease(1);
        selectedStates.selectByIndex(4);
        SeleniumUtils.waitPlease(1);


    }
    public static void test6(){
        WebElement state = driver.findElement(By.id("state"));
        Select selectedStates = new Select(state);
        List<WebElement>states=selectedStates.getOptions();
        for (int i=1;i<states.size();i++){

            selectedStates.selectByIndex(i);
        }

    }

    public static void test7(){
        WebElement languages=driver.findElement(By.xpath("//select[@name='Languages']"));
        Select yourLanguages=new Select(languages);
        yourLanguages.selectByValue("js");
        String actual1=yourLanguages.getFirstSelectedOption().getText();
        yourLanguages.selectByValue("java");
        String actual2=yourLanguages.getFirstSelectedOption().getText();
        String expected="JavaScript";
        if(!actual1.equals(actual2)){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
            System.out.println(actual1);
            System.out.println(actual2);
        }


    }
     public static void test8(){
       WebElement state = driver.findElement(By.id("state"));
       Select selectedStates = new Select(state);
     }

}

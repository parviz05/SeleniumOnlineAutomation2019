package com.cybertek.page.vytrack;

import com.cybertek.test.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CalendarEventPage {
    private WebDriver driver= Driver.getDriver();
    public String createCalendarEventBtnLocator="a[title^='Create Calendar']";
    public  String repeatCkeckBoxLocator="input[id^='recurrence-repeat-view']";
    public String repeatDropdownLocator="select[id^='recurrence-repeats-view']";

//let's write a method that would return collection of repeat option
    public List<String> getRepeatOptions(){

        //we created select object to work with dropdown
        Select select=new Select(driver.findElement(By.cssSelector(repeatDropdownLocator)));

        //.getOptions(); return all available options in the dropdown.
        //every option is a WebElement
        List<WebElement>options=select.getOptions();

        //this a collection that will store text of  every option
        List<String>optionsTextList=new ArrayList<>();
        for (WebElement option:options){

            // go through every option and retrieve text
            //add that text into collection of text options
            optionsTextList.add(option.getText());

        }
        return optionsTextList;
    }
}

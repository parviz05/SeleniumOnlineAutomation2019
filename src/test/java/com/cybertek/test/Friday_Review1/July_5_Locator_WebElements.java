package com.cybertek.test.Friday_Review1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class July_5_Locator_WebElements {

    public void test(){



    /*
    Today's topic:
                 1. Locators
                 2. WebElements
                 3.Method of WebElement



     */

    /*
       Locators: created by using By abstract class: all methods bellow is abstract methods which are belong to By abstract class
               needs to create WebElements
               1.id(str)
               2.xpath
               3.CSSSelector (faster than xpath)
               4.name
               5.classname
               6.tagNmae
               7.linkText
               8.partialLinkText
               All of these methods are static return method==>By

               xpath formula:
                      1.    basic: .//tagName[@Attribute='value of the attribute']  for unique element
                            basic: //tagName[@Attribute='value of the attribute']  remove dot . front of double slash //
                       2.            if it's not unique:
                                              //tagName[@Attribute='value of attribute' and @SecondAttribute='value' and .. ]

                                                <button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_0_w">Sign Up</button>
                                                //button[@type='submit' and @name='websubmit']


                      3.     WebElement with visible text:        condition, visible text
                                                       //tagName[contains(text(),'partial visible text')]
                                                        //button[contains(text(),'Sign up')]


      */

    // id locator:
             By idLocator= By.id("id goes here ");
   //name locator:
             By nameLocator=By.name("name gores here");
  // CSSSelector:
             By Csslocator=By.cssSelector("Css goes here");
 //Xpath locator:
             By xpath=By.xpath("xpath goes here");



    /*
    WebElements:
               findElement(); we use it when the locator is unique,  returns a single element
               findElements(); we use it when the locator is not unique, returns list of elements

     */

    WebDriver driver=new ChromeDriver();

    //WebElement with name locator: name needs to be unique
      WebElement name= driver.findElement(nameLocator);// if elements is unique we need to use findElement

        //if element is not unique:
          List<WebElement>lists=driver.findElements(nameLocator); // We need to use findElements if element is not unique

    /*
      Methods of WebElement:
                 click();-> click webElement
                 sendKeys();-> using for entering input
                 getText();-> return to lintext of the WebElement as String
                 isDisplayed();-> return boolean "Verify is the webElemnet "
                 isSelected();-> return boolean, used to verify  check box or Radio buttons are selected or not
                 getTagname();-> returns the tagname of the WeElemet.
                 submit();->Keys.Enter
                 isEnabled();->return boolean expression, used to verify buttons
                 getAttribute();-> returns the value of the given attribute
                 clear();-> to clear input box or search box

    */

    name.click();
    name.sendKeys("inputs goes here");
    String str=name.getText();
    name.isDisplayed();
    name.getTagName();
    /*
      <button type="submit" class="_6j mvm _6wk _6wl _58mi _3ma _6o _6v" name="websubmit" id="u_0_w">Sign Up</button>
     */
    name.getAttribute("type");//==> return to submit value
    }
}



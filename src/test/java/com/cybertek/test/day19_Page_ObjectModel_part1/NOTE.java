package com.cybertek.test.day19_Page_ObjectModel_part1;

public class NOTE {
    /*
    Today is 7/27/2019

Topic: POM or Page Object Model


PageFactory.initElements(driver, this);

This step is required if you want to use @FindBy annotation. Thus, page factory will find elements based on locator. Whenever you are calling web element, page factory will try to find it again.



@FindBy(id = "_submit")
public WebElement loginBtn;

::: Same :::

WebElement loginBtn = driver.findElement(By.id("_submit"));


initElements - maps page class with driver.
This step is required in every singe Page Class. Otherwise, PageFactory will not find driver.

Page Object Model (POM) - design pattern, that we use in test automation. For every page of application, we are creating corresponded Page Class. All web elements, or methods that stands for interacting with that particular page, should go into   corresponded page class.

For example: We have package with page, and under this package HomePage class. This class will be used as object repository for home page of the application.


Our framework is based on Page Object Model.


public LoginPage(){
        PageFactory.initElements(driver, this);
}

We are initializing PageFactory only inside a constructor.

Enable auto-import!
Click on the gear and then DESELCT COMPACT MIDDLE PACKAGES!!!!!!!!!
Make sure you have all dependencies downloaded!


Naming of page classes should correspond to page names.

BREAK TILL 2:10.

Guest speaker: Me, myself and I.

The benefit of Page Factory is to make using Page Objects simpler and easier.

@FindBy(id = "prependedInput")
public WebElement userNameElement; <- means find element, by id "prependedInput".

private WebDriver driver = Driver.getDriver(); < - new reference variable, not a new object. Just to make driver call shorter in terms of typing. Otherwise, any time we need driver, we have type Driver.getDriver(). With driver reference variable, we can just type driver and call driver object.

custom-checkbox__icon

Icon is on top of input box. You cannot click on it directly, because of this icon. You have to click on icon instead.





     */
}

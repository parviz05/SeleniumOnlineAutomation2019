package com.cybertek.page.vytrack;

import com.cybertek.test.Utilities.Driver;
import org.openqa.selenium.By;

public class LoginPage {

    String userNameLocator="prependedInput";
    String passworLocator="prependedInput2";
    String loginButtonLocator="_submit";


    public void Login(String useName, String password){
        Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(useName);
        Driver.getDriver().findElement(By.id(passworLocator)).sendKeys(password);
        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();
    }
}


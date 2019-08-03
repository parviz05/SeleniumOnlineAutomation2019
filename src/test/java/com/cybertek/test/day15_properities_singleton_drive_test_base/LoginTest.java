package com.cybertek.test.day15_properities_singleton_drive_test_base;

import com.cybertek.test.Utilities.ConfigurationReader;
import com.cybertek.page.vytrack.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    LoginPage loginPage=new LoginPage();

    @Test
    public void LoginTest1(){
        String username= ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");
        loginPage.Login(username,password);


    }


}

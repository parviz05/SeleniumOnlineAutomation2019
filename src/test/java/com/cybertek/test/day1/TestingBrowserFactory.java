package com.cybertek.test.day1;


import org.openqa.selenium.WebDriver;

public class TestingBrowserFactory {

    public static void main(String[] args)throws Exception {
/*
 WebDriver driver = new ChromeDriver();
 getDriver is a static method
 so we don't need to create an object
 to use that method
 in order to call static members
 we use classname not object nam
  */
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com");
        try {
            //sleep method throws checked exception
            // that means we have to handle it
            // unchecked exceptions occurs during runtime
            Thread.sleep(5000);
            // this command will stop execution for 3 seconds
            // it will wait for 5 seconds
            // before closing next step
            }catch (Exception e){
            System.out.println(e.getMessage());
            //this is out test
            // we are checking if expected title is the same as actual
            // String actualTitle = driver.getTitle();
            // String expectedTitle = "Practice$";
            // if(actualTitle.equals(expectedTitle)){
            // System.out.println("Passed");
            // }else{
            // System.out.println("Failed");
            // System.out.println("Expected title: "+expectedTitle);
            // System.out.println("Actual title: "+actualTitle);
             }
        String actualTitle=driver.getTitle();
        String expectingTitle="Practice";
        if(actualTitle.equals(expectingTitle)){
            System.out.println("pass");
        }else{
            System.out.println("failed");
            System.out.println("ActualTitle: "+actualTitle);
            System.out.println("ExpectingTitle: "+expectingTitle);
        }
            // close browser at the end of test
            // driver.close();


    }

}

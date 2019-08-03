package com.cybertek.test.Office_Hours_Thursday1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.cybertek.test.Office_Hours_Thursday1.library.sleep;

public class June_27 {

    public static void main(){
        main(new String[]{"A"});
    }

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();// set system property

        WebDriver driver=new ChromeDriver();// it gonna open browser
                  //webdriver is an interface implemented by Chromedriver class


        driver.get("http://google.com");// to run browser u have to have use protocol "http:"
                 //http: (hypertext transfer protocol)
                 //https: (hypertext transfer protocol secure)

        //Verify the page title to make sure that we are corract page
        String pageTitle=driver.getTitle();// every time if u see data type in method that is means it return that type

                //expected condition: title should contain "Google"

        if(pageTitle.contains("Google")){
            // if(pageTitle.contains("Amazon")){
            System.out.println("Page title is verified ");
        }else{
            System.out.println("Page title is no verified");

            System.exit(0);// to exit whole test case

        }

            library.sleep(2.5); //instead of using Thread.sleep(); method every time and using try&catch block i prefer to use my own method

//
//        try {
//
//            Thread.sleep(3000);//to wait 3 second u can use this method or// Checked exception needs to be handled immidietly because
//                                     // they occure during compile time
//            //  new Actions(driver).pause(3000).perform();// this method
//            //both are using for same purpose
//
//        }catch (Exception e){
//            System.out.println();
//        }

        // manage window :

        //maximize window

        driver.manage().window().maximize();


        //library.sleep(2.4);
        sleep(2.4);   // its a static method u can reach this method by static way or import the class where it comes from
        //fullScreen
        driver.manage().window().fullscreen();

        sleep(2.4);

        // u can resize the window by yourself by using Dimension method
        Dimension ss=new Dimension(6,7);
        driver.manage().window().setSize(ss);
        sleep(2.4);
        driver.manage().window().maximize();


        //Navigate: refresh, do back , go forward, open URL

                   //refresh();

        driver.navigate().refresh();
        sleep(2);

        //goback
        driver.navigate().back();
        sleep(2);

        //forward
        driver.navigate().forward();

        sleep(2);
        driver.navigate().to("http://amazon.com");
        sleep(2);


       String PageCurrentURL= driver.getCurrentUrl();
       String ExpectingURL="http://amazon.com";

       //Verify URL
       if(PageCurrentURL.contains("www.amazon.com")){
           System.out.println("URL is verified");

       }else{
           System.err.println("URL is not verified ");
           System.exit(0);
       }
        /*

        Differences between navigate().to() and get();
                          get(); wait webpage fully uploaded
                          navigate.to(); does not have to wait (faster)




         */

        driver.navigate().back();
        sleep(2);







        System.out.println("Test completed");

        driver.close();
        //driver.quit();
        /*
        Differences between close(); and quit(); methods
                            close() close the one single tab.
                            quit() close the entire tab and browser

         */

         method1();//try catch
      // method2();// throws

    }

    public static void method1(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public static void method2()throws Exception{

        sleep(2000);


        /*

       1) We can use either get() or navigate().to() method to go URL
        Differences between navigate().to() and get();
                          get(); wait webpage fully uploaded
                          navigate.to(); does not have to wait (faster)

      2) Navigation: with navigate we can
                   refresh: navigate().refresh();
                   go back: navigate().back();
                   forward: navigate().forward();

     3) Manage window:
                  full screen: driver.manage().window().fullscreen();
                  maximize: driver.manage().window().maximize();
                  SetSize:  driver.manage().window().setSize(new Dimension(8,7));

    4) verify Title:
                 getTitle();
       verify URL:
                 getCurrentURL();

         */



    }


}

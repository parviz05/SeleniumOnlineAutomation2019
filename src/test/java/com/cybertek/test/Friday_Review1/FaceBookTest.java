package com.cybertek.test.Friday_Review1;

import com.cybertek.test.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FaceBookTest {

    static WebDriver driver;
    /*
    Test Cases:
             1.Verify to URL and Title
             2.verify radio buttons can be selected(By clicking radio button or visible text)
             3.verify that the singUp button is enabled
             4.verify that warning message is diplayed
     */

    public static void main(String[] args) {
        //test2();
        //test3();
        test4();
    }
    public static void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        boolean title=driver.getTitle().contains("Facebook");
        boolean url=driver.getCurrentUrl().contains("https://www.facebook.com");
        System.out.println(title);
        System.out.println(url);
driver.quit();

    }
    public static void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        List<WebElement>allRadioButton=driver.findElements(By.xpath(" //input[@type='radio']"));
        WebElement female=allRadioButton.get(0);
        WebElement male=allRadioButton.get(1);
        WebElement custom=allRadioButton.get(2);

        female.click();
        boolean f= female.isSelected();

        SeleniumUtils.waitPlease(2);
        male.click();
        boolean m=male.isSelected();
        System.out.println(m);
        SeleniumUtils.waitPlease(2);
        custom.click();
        boolean c=custom.isSelected();

        SeleniumUtils.waitPlease(2);

        System.out.println(f);
        System.out.println(m);
        System.out.println(c);



        //visible text of veb element: Female,Male,Custom
        // female visible text: // *[contains(text(),'Female')]   if the webElement has lintext or visible text, we can give * for tagname to write
        //xpath without looking at HTML
        //Male visible text:    // *[contains(text(),'Male')]
        //Custom visible text: // *[contains(text(),'Custom')] 3 matching

        WebElement customText=driver.findElements(By.xpath("// *[contains(text(),'Custom')]")).get(0);
        WebElement femaleTex=driver.findElement(By.xpath("// *[contains(text(),'Female')]"));
        WebElement maleTex=driver.findElement(By.xpath("// *[contains(text(),'Male')]"));

        femaleTex.click();
        boolean fm=femaleTex.isSelected();
        SeleniumUtils.waitPlease(2);
        maleTex.click();
        boolean ml=maleTex.isSelected();

        SeleniumUtils.waitPlease(2);
        customText.click();
        boolean cm=customText.isSelected();


        System.out.println(fm);
        System.out.println(ml);
        System.out.println(cm);


        SeleniumUtils.waitPlease(2);



        driver.quit();


    }
    public static void test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");

        WebElement signUp=driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUp.click();
        boolean b=signUp.isEnabled();
        System.out.println(b);

        WebElement message=driver.findElement(By.xpath("(//*[contains(text(),'What')])"));
       boolean d= message.isDisplayed();
        System.out.println(d);


driver.quit();


    }
    @Test
    public static void test4(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        SeleniumUtils.waitPlease(2);
        List<WebElement>allradioButtons=driver.findElements(By.xpath("/input[@type='radio']"));
        boolean b;
        for (WebElement each:allradioButtons) {
            SeleniumUtils.waitPlease(2);
            each.click();
//
//            b=each.isSelected();
//            System.out.println(b);

        }
driver.quit();
    }

}

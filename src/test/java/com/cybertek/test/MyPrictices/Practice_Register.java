package com.cybertek.test.MyPrictices;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Practice_Register {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);
        WebElement fulName=driver.findElement(By.name("full_name"));

        fulName.sendKeys("parviz");

        WebElement email=driver.findElement(By.name("email"));

        email.sendKeys("alas.parvizz@gmail.com");

        WebElement submit=driver.findElement(By.name("wooden_spoon"));
        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);
        submit.click();

        WebElement confMesage=driver.findElement(By.name("signup_message"));
        String expect="Thank you for signing up. Click the button below to return to the home page.";
        String actua=confMesage.getText();

        if(actua.equals(expect)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            System.out.println("actual: "+actua);
            System.out.println("expecting: "+expect);
        }


        com.cybertek.test.Office_Hours_Thursday1.library.sleep(2.5);

        driver.close();


    }
}

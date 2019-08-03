package com.cybertek.test.day17_WebTable_part1;

import com.cybertek.test.day15_properities_singleton_drive_test_base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class WebTableTests extends TestBase {


    @Test
    public void printTableTest(){
        WebElement table1=driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println(table1.getText());

    }
    @Test
    public void printHeaderRow(){
        WebElement header=driver.findElement(By.id("table1")).findElement(By.tagName("thead"));
        System.out.println( header.getText());
    }
    @Test//without header, number of rows in the first table
    public void countRows(){
        //means find table with id table1 then go to tbody and any tr
        //it represents number of rows in the first table
        String locator="table[id='table1'] > tbody tr";
        List<WebElement>rows=driver.findElements(By.cssSelector(locator));
        System.out.println(rows.size());

    }
    @Test
    public void countCell(){
//        String cellLocator="table[id='table1']  th";
//        List<WebElement>cells=driver.findElements(By.cssSelector(cellLocator));
//        System.out.println(cells.size());

        //rows' count
        String row2="table[id='table1'] tr";
        List<WebElement>rows2=driver.findElements(By.cssSelector(row2));
        System.out.println(rows2.size());

        //print all rows' data
        for (WebElement row:rows2) {
            System.out.println(row.getText());

        }
        Assert.assertTrue(rows2.size()==5);
        Assert.assertEquals(rows2.size(),5);
        System.out.println( );
        //cells' count
        String cellSlocator="table[id='table1'] tr th";
        List<WebElement>cells=driver.findElements(By.cssSelector(cellSlocator));
        System.out.println(cells.size());
        Assert.assertTrue(cells.size()==6);
        Assert.assertEquals(cells.size(),6);

    }
    @Test
    public void printTable1Header(){
        //print just names in cells in table
        String nameList="table[id='table1'] tr td:nth-of-type(2)";
        List<WebElement>names=driver.findElements(By.cssSelector(nameList));
        for (WebElement name:names) {
            System.out.println(name.getText());

        }
        //print All headers in table
        String heaterLocator="table[id='table1'] th ";
        List<WebElement>ListOfnames=driver.findElements(By.cssSelector(heaterLocator));
        for (WebElement list:ListOfnames) {
            System.out.println(list.getText());

        }
    }
    //print certain row
    @Test
    public void printDataRowNum3(){
        String rowNumber3Locator="table[id='table1']  tr:nth-of-type(3)";
        WebElement data=driver.findElement(By.cssSelector(rowNumber3Locator));
        System.out.println(data.getText());
//        List<WebElement>datas=driver.findElements(By.cssSelector(rowNumber3Locator));
//        for (WebElement data:datas) {
//            System.out.println(data.getText());
//
//        }
//
    }

    //print certain row
    @Test
    public void printSpecificRow(){
        int row=3;
        String rowlocator="table[id='table1']  tr:nth-of-type("+row+")";

        //find same elements with xpath
        String locator="//table[1]//tbody//tr["+row+"]";
        WebElement rowElement=driver.findElement(By.cssSelector(rowlocator));
        System.out.println(rowElement.getText());


    }

    //let's write method that will return column based on column

    @Test
    public void printSpecificColumn(){
        System.out.println(getColumn("Email"));
    }

    @Test
    public void verifyNmaeDisplay(){
        String firstName="Jason";
        String lastName="Doe";
        //as a xath we can use like that : "//table[1]//tbody//tr[3]//td[2]";
        String firstNameLocator="table:nth-of-type(1) tr:nth-of-type(3) td:nth-of-type(2)";

       ////as a xath we can use like that : "//table[1]//tbody//tr[3]//td[1]";
        String lastNameLocator="table:nth-of-type(1) tr:nth-of-type(3) td:nth-of-type(1)";

        String actualName=driver.findElement(By.cssSelector(firstNameLocator)).getText();
        String actualLastName=driver.findElement(By.cssSelector(lastNameLocator)).getText();

        Assert.assertEquals(actualName,firstName);
        Assert.assertEquals(actualLastName,lastName);

    }

    
    //To delete data in cell in table 1

    @Test(description = "verifyNmaeDisplay")
    public void verifyThatRecordedHasbeenDeleted(){
        String firstName="Jason";
        String lastName="Doe";
        //as a xath we can use like that : "//table[1]//tbody//tr[3]//td[2]";
        String firstNameLocator="table:nth-of-type(1) tr:nth-of-type(3) td:nth-of-type(2)";

        ////as a xath we can use like that : "//table[1]//tbody//tr[3]//td[1]";
        String lastNameLocator="table:nth-of-type(1) tr:nth-of-type(3) td:nth-of-type(1)";
        String targetLocator="//table[1]//td[text()='"+lastName+"']";

        String deleteLocator="//table[1]//td[text()='"+lastName+"']//following-sibling::td//a[text()='delete']";
        driver.findElement(By.xpath(deleteLocator)).click();
        Assert.assertTrue(driver.findElements(By.xpath(targetLocator)).isEmpty());

    }
    public List<String> getColumn(String columnName){


        List<String>valuse=new ArrayList<>();
        //all headings
        List<WebElement>headings=driver.findElements(By.cssSelector("table[id='table1'] th "));
        int columnNumber=0;

        //we are looping through collections of heading
        for (int i=0;i<headings.size();i++){
            //we are looking for position of heading
            if(headings.get(i).getText().equals((columnName))){

                columnNumber+=i+1;
                break;

            }
        }
        //base on position that we found from previous loop, we allocating column with
       List<WebElement>columnList=driver.findElements(By.cssSelector("table[id='table1']  td:nth-of-type("+columnNumber+")"));

        for (WebElement column:columnList) {
            valuse.add(column.getText());

        }
        return valuse;

    }

}

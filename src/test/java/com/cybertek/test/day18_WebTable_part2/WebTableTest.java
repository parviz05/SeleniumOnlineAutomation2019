package com.cybertek.test.day18_WebTable_part2;

import com.cybertek.test.Utilities.SeleniumUtils;
import com.cybertek.test.day15_properities_singleton_drive_test_base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class WebTableTest extends TestBase {


    /*
    Write method that will return count of rows
     */


    public int getCountOfRows(){
        return driver.findElements(By.cssSelector("#table1 tr")).size();
    }

    /*
    Write method that will return count of rows
    In this case, object of by allows us to specify table locator og any type
     */


    public int getCountOfRows(By by){
        return driver.findElements(by).size();
    }

    @Test
    public void countOfRowsTable1(){

        Assert.assertEquals(getCountOfRows(),5,"Number of rows doesn't match");
    }
    @Test
    public void countOfRowsTable2(){

        Assert.assertEquals(getCountOfRows(By.xpath("//table[1]//tr")),5,"Number of rows doesn't match");
    }

    @Test
    public void countOfCellsTable1(){
        Assert.assertEquals( getNumbersOfColumn(By.cssSelector("#table1 th")),6,"The count of Cells doesn't match");
    }
    @Test
    public void countOfCellsTable2(){
        Assert.assertEquals( getNumbersOfColumn(),6,"The count of Cells doesn't match");
    }

    //########################################

    /*
    Write method that returns numbers of Columns
     */


    public int getNumbersOfColumn(By by){

         return driver.findElements(by).size();

  }
    /*
     Write method that returns numbers of Columns
      */
    public int getNumbersOfColumn(){

        return driver.findElements(By.cssSelector("#table1 th")).size();

    }


    //########################################
    /*
    Write a method that will return table size
    First value -number of rows
    Second value-number of column
    by- represented locator for table

     */

    public int[] getTableSize(By rowsLocator, By columnLocator){
        int [] size ={getCountOfRows(rowsLocator),getNumbersOfColumn(columnLocator)};

        return size;

    }

    /*
    Write a method that will return table size
    First value -number of rows
    Second value-number of column
    by- represented locator for table

     */


    public int[] getTableSize(){
      int [] size={getCountOfRows(),getNumbersOfColumn()};

       return size;
    }
    @Test
    public void tableSizeData(){
        int[] expectedSize={5,6};
        int[] actualSize=getTableSize();
        Assert.assertEquals(actualSize,expectedSize,"Table size doesn't match");
    }
    @Test
    public void tableSizeData2(){
        int[] expectedSize={5,6};
        int[] actualSize=getTableSize(By.xpath("//table[1]//tr"),By.cssSelector("#table1 th"));
        Assert.assertEquals(actualSize,expectedSize,"Table size doesn't match");
    }


    //###############################################
    /*
    Write method that will return table headers as a list
     */


    public List<WebElement> getHeaders(){
        return driver.findElements(By.cssSelector("#table1 th"));
    }

    /*
    THis method return table headers text as a List of Strings
     */

    public List<String> getHeadersText(){
        List<String> headers=new ArrayList<>();
        for (WebElement tableHeader:getHeaders() ) {
            headers.add(tableHeader.getText());

        }
        return headers;
    }

    @Test
    public void tableHeaders(){
        List<String>expectedList= Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<String>actualList=getHeadersText();
        System.out.println(getHeadersText());
        Assert.assertEquals(actualList,expectedList,"Headers don't match");
    }

    //########################################

    /*
    To verify if first name column is sorted in alphabetic order
     */

    @Test
    public void sortColumnTest(){
        //Assert name
        //specified name as a string
        String columnName="First Name";
        int index=2;
        // used the string instead of index in the locator
        driver.findElement(By.xpath("//table[1]//th//span[text()='"+columnName+"']")).click();

        //according to index we look for data in cell
 // driver.findElement(By.cssSelector("#table1 th:nth-of-type("+index+")")).click();
        //driver.findElement(By.cssSelector("#table1 th:nth-of-type(2)")).click();

        SeleniumUtils.waitPlease(2);
        System.out.println(getColumnData("Due"));

        //verify is sorted ?

        // creat list to compare
        List<String> sorted=new ArrayList<>();
        //addeverithing to the list
        sorted.addAll(getColumnData(columnName));
        //sorted with collection.sort () method
        Collections.sort(sorted);
        //Compare is sorted list is the same before storing
        Assert.assertEquals(getColumnData(columnName),sorted);

    }
    public List<String> getColumnData(String columnName){

        int columnNumber=0;

        for (int i = 0; i <getNumbersOfColumn() ; i++) {
            if(columnName.equals(getHeadersText().get(i))){
                columnNumber=i+1;

                  }

            }
        String locatorForColumn="#table1 tr td:nth-of-type("+columnNumber+")";

        //this is collection of WeElement that values from specific Column
        List<WebElement>collectionsOfWebElements=driver.findElements(By.cssSelector(locatorForColumn));
        List<String>columnCollectionsOfText= new ArrayList<>();
        for (WebElement element:collectionsOfWebElements) {
            columnCollectionsOfText.add(element.getText());


        }

        return  columnCollectionsOfText;
    }

}

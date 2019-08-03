package com.cybertek.test.day9_TestNG;

import org.testng.annotations.*;

public class MixedAnnotationTest {
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");

    }
    @Test
    public void test1(){
        System.out.println("I am test1");
    }
    @Test
    public void test2(){
        System.out.println("I am test2");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

}

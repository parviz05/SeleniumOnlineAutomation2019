package com.cybertek.test.day9_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaTestNGDemo {

    @Test
    public static void test1(){

        String a="A";
        String b="A";

        Assert.assertEquals(a,b);
    }
    @Test(invocationCount = 3,skipFailedInvocations = false)
    public  void test2(){

        String str1="apple";
        String str2="Orrange";
       // Assert.assertEquals(str1,str2);
    }
    @Test
    public  void test3(){
        String st="ABCD";
        String st2="AB";


        Assert.assertTrue(st.equals(st2));

    }
    @Test
    public  void test4(){

        Assert.assertFalse(false);
    }
}

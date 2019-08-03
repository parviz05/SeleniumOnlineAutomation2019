package com.cybertek.test.Friday_Review1;

import org.testng.annotations.Test;

import static org.testng.Assert.*;// this step is imports all static feature from the assert class

public class July_12_Assertions {

    /*
    Topic: Assertions:
            used to verify the condition of test case
            assertTrue(boolean); argument must be true boolean expression, or else the remaining test steps won't be executed
            assertFalse(boolean); argument must be false boolean expression
            assertEquals(variable1,variable2); two variable must be equals
            assertNotEquals(); arguments  can be equals

            they are static methods. They can be called by static way which means through classname

            NOTE:
                Assert.class and methods are valid only for TestNG





     */
    @Test
    public void test1(){
        assertTrue(1==1);
        System.out.println("test case 1 completed");

    }
    @Test
    public void test2(){
        assertFalse(1>0);
        System.out.println("test case 2 completed");

    }
    @Test
    public void test3(){
assertEquals(1,2);
        System.out.println("test case 3 completed");


    }
    @Test
    public void test4(){
        assertNotEquals("Batch11","Batch11");
        System.out.println("test case 4 completed");

    }
}

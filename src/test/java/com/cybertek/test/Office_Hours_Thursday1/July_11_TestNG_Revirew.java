package com.cybertek.test.Office_Hours_Thursday1;

import org.testng.annotations.Test;

public class July_11_TestNG_Revirew {

    /*
      Topic: TestNG
      Benefits of TestG: if we have TestNG we don't need to write main method to run our application

                 @Test: a test cases
                        priority: -> decide which @Test method run first. (in Accending order)
                        enable:   -> if true(deafult): @Test will executed, if false: @Test will be ignored
                        description:   -> is used to write test case description (it's explain test cases)
                        invocationCount: -> decides how many time @Test cases should be executed
                        timeout:         -> time limit to test cases (specifying that in certain time the test case have to be completed  )
                        expectedException: -> Defines that the test cases might throw an unchecked
                        dependency:       -> can create depencency between @Test methods

                       NOTE:
                       Ignore and Enable differences are Ignot annitation will be able to run individually
                       But enabled do not allow either to run the @test individually



               TestNG Annotation:
                      controls how the @Test(testNG) should be executed

                      @BeforeMethod: runs before each @Test Methods
                      @AfterMethod:  run after the completion of each @Test Methods
                      @BeforeClass:  runs before the first @Test method of the class
                      @AfterClass:   runs after the completion of last @Test Method
       */
    //where for to put sone conditions we need to put in paranteses ()
    @Test(priority = 1, enabled = false)// as seen as it shows the test not enable to run
    public void testCase1(){
        System.out.println("Test case 1 completed");
    }
    @Test(priority = 2, description = "This is testing TestNG")
    public void testCase2(){
        System.out.println("Test case 2 completed");
    }
    @Test(invocationCount = 3)// according to requirement to check performance of Ap we should be able to need to executed same @Test cases multiple time
    public void testCase3(){             // Like load testing that is why we should need how many time to execute same test cases instead of to repit writing same test case
        System.out.println("Test case 3 completed");
    }
    @Test(timeOut = 3000) //According to requirement DC it should be required that automation should not be go further 10 second:
    public void testCase4(){      //We need to specify in how many minute or second the test case run
        System.out.println("Test case 4 completed");
    }
    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void testCase5(){
        System.out.println("Test case 5 completed");
        System.out.println(new int[]{1,2,3,4,5,6,7} [100]);// after exception right a way it just make return type which is here exit and not goes further

        System.out.println("Extra test steps");

    }
    @Test(dependsOnMethods = {"testCase4"})
    public void testCase6(){
        System.out.println("Test case 5 completed");

    }

}

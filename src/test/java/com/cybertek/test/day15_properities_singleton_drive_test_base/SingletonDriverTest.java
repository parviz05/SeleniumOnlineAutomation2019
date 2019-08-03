package com.cybertek.test.day15_properities_singleton_drive_test_base;

import com.cybertek.test.Utilities.Driver;
import com.cybertek.test.Utilities.SeleniumUtils;
import org.testng.annotations.Test;

public class SingletonDriverTest {

    @Test
    public void test1(){
        Driver.getDriver().get("http://google.com");
        SeleniumUtils.waitPlease(2);
        Driver.closeDriver();// to completely shutdown driver
    }
}

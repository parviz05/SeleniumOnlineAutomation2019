package com.cybertek.test.day15_properities_singleton_drive_test_base;

import com.cybertek.test.Utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {

    @Test
    public void test1(){
        String expected="chrome";
        String actual= ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void test2() {
        String expectingUserName="storemanager85";
        String actualUserName=ConfigurationReader.getProperty("username");
        Assert.assertEquals(actualUserName,expectingUserName);
    }

    }

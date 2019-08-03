package com.cybertek.test.day15_properities_singleton_drive_test_base;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.Properties;

public class System_Properties_Test {

    @Test
    public void systemPropertiesTest1(){
        //how to get system name
        String os=System.getProperty("os.name");
        System.out.println(os);
        //how to get username
        String username=System.getProperty("user.name");
        System.out.println(username);
        //how to get java version
        String javaVersion=System.getProperty("java.specification.version");
        System.out.println(javaVersion);
        //how to get directory
        String homeDirectory=System.getProperty("user.home");
        System.out.println(homeDirectory);

        //How to read all properties
        Properties properties=System.getProperties();
        //this an entry set of all properties
        //since it's key -value pair, we use Map to store this information
        for(Map.Entry<Object, Object>property: properties.entrySet()){
            //get key of every item(os.name) value of every property (Mac OS X)
            System.out.println("Key:"+property.getKey()+", Value: "+property.getValue());
        }


    }

}

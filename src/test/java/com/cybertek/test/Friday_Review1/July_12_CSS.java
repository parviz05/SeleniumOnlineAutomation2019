package com.cybertek.test.Friday_Review1;

import org.testng.annotations.Test;

public class July_12_CSS {
    /*
    css:
            Mainly uses: HTML,tag,id,Attributes,Class
            Benefits of CSS:
                          faster than xpath, easier to read.
                          it's also used more often like xpath

           write xpath with attributes:
                                     //tagname[@Attribute='value']
                    not always unique in that case need to use second attribute
                              if not unique: //tagname[@Attribute='value' and @Attribute='value']


Values can not start with numbers  in css
          write css with attribute:
                                 tagname[Attribute='value']
                    not always unique in that case need to use second attribute
                                 if not unique: tagname[Attribute='value'][Attribute='value']

         write css with parent and child tagname
                     parentTagname childename[Attribute='value']

         write css with Id: if the id contains multiple digits, it's mostlikly to be dynamic
                in css # represent your id
                formula: tagname#Value
         write css with id and attribute: we use it if the id is not unique
                  formula: tagname#Value[Attribute='value']

         write css with class:
                   .sign is for class
                 formula: tagname.classValue

         write css with class and attribute: if the class is not unique
                 formula: tagname.classValue[Attribute='value']

         wite css with start with condition:
                  ^sign is for "starting with"
                  formula: tagname[Attributes^=startValue]

        write css with end with condition:
                $ sign is for endWith:
                formula: tagname[Attributes$=endingValue]

        write css with contain condition:
                * sign is for contain condition
                formula:tagname[Attribute*=someValue]


     */


    /*
    <span>
    <select aria-label="Month" name="birthday_month" id="month" title="Month" class="_5dba">

         css:  select[aria-label=Month]
         css:  select[aria-label=Month][#month]
         css:  span select[aria-label=Month]
         css:  select#month
         css:  select#month[aria-label=Month]
         css:  select._5dba    //not unique
         css:  select._5dba[title=Month]
         css:  select[name^=birt]   // not unique
         css:  select[name^=birt][aria-label^=Mon]
         css:  select[name$=month]
         css:  select[name$=nth][name^=birt]
         css:  select[name*=day]
         css:  select[name*=day][aria-label$=th][title^=M]

         css:   span select._5dba[aria-label$=th][title^=M]
     */

    @Test
    public void test(){

    }
}

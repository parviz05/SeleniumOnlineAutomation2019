package com.cybertek.test.day13_WebDriver_API;

public class NOTE {

    /*
IMPLICIT WAIT:
           The implicit wait will tell to the web driver to wait
           for certain amount of time before it throws a "No Such Element Exception"

EXPLICIT WAIT:
             The explicit wait is used to tell the Web Driver to wait for certain expected conditions
             >Wait until element is visible
             >Wait until element is available
             >Wait until element is clickable
             >Wait until element is not available

Difference between implicit wait: is a custom wait ; u specify for which element u need to wait in certain time

Explicit wait Syntax:
                   WebDriverWait wait= new WebDriverWait(driver,10);
                   wait.until(ExpectedConditions.elementToBeClickable(By.xpath(")));

                   Will wait 10 second using the locator provided
                   Does not depend on the value of implicit wait
                   Only applies once when that line called
                   Will continue waiting if the element is loaded but not clickable
     */

    /*
    Today is 7/16/2019

And topic is Synchronization.

Before we were using a lot Thread.sleep();

With this method, we put on pause program execution. (in out case - automation script.)

We can avoid usage of Thread.sleep() by using Implicit and Explicit wait.
Usually, we specify Implicit wait before get(); . We use it once in the setup and will work everywhere.

  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

In this case, driver will wait up to 10 seconds to find element. Otherwise, driver will wait and NoSuchElmentException will occur.

Implicit wait apply to all elements.
Declare i once and user forever
Don't put between actions



#####################
NoSuchElmentException
StaleElementReferenceException
WebDriverException
ElementNotInteractableException

//Explicit wait
 WebDriverWait wait = new WebDriverWait(driver, 10);

//wait until element is clickable
//it works only for element that you provided
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(usernameLocator))));
element.click();

#########################
Means that driver will wait from 0 to 10 seconds for element to be clickable. It will disregard other conditions. The only is import for wait object is to wait until element is clickable.


when we call the findElement method, if findElement cannot find element based on the locator provided, it throws NoSuchElementException.



if we have implicit wait set and if findElement cannot find element, it will keep trying to find the element. if findELement method locates the element before time runs out, it will return the element. if not, it throws NoSuchElementException.

Implicit wait does not wait for duration given. it it finds the element early, it will stop waiting and simply return the element



Implicit wait applies for that webdriver object, we use create/use a different webdriver object, we need to set the implicit wait separately



Implicit Wait:

•During Implicit wait if the Web Driver cannot find it immediately because of its availability, it will keep polling the DOM to get the element.

•If the element is not available within the specified Time an NoSuchElementException will be raised.

•The default setting is zero.

•Once we set a time, the Web Driver waits for the period of the WebDriver object instance.



implicit wait only applies to findElement method, not the findElements

############

seems like thread.sleep, explicit wait and implicit-wait are for different purposes, why they always ask which one you prefer on interview?



I use them based on what problem I am solving, is I have to wait for findelement, then I use implicit wait.

when I need to wait for certain conditions, thats when I use the explicit wait.

Explicit Wait:

•There can be instance when a particular element takes more than a minute to load.

•In that case you definitely not like to set a huge time to Implicit wait, as if you do this your browser will going to wait for the same time for every element.

•To avoid that situation you can simply put a separate time on the required element only.

•By following this your browser implicit wait time would be short for every element and it would be large for specific element.





     */

}

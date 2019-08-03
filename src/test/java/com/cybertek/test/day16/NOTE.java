package com.cybertek.test.day16;

public class NOTE {
    /*
    Today is 7/21/2019

Agenda:
	Mostly review

Verify repeat options
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify repeat options:
Daily
Weekly
Monthly

How explicit wait works?

Let's say we have overlay screen in between every loading.

This overlay sreen might appear for 1 second, sometimes 3 seconds, sometimes 5...

In case of Thread.sleep(5000) it will always wait for 5 seconds.
Regardless, how long overlay screen present, your script will be on pause strictly 5 seconds.  If we have too many redundant waits, it will significantly increase test execution time. That's why, we have use Thread.sleep() only in critical cases.
WebDrvierWait - it's a explicit wait.
 Based on the error, we choose expected condition to wait.

 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(loaderMaskLocator))));

 invisibilityOf - means - wait until something is visible. In this case - loader screen. Once loader screen disappear, continue.

What's the benefit of explicit wait?

The benefit is that you specify time frame. Not exact time for wait.

By default, explicit wait checks every 200 milliseconds, if condition is met withing time frame.

Example: You need to wait until loader screen disappear.
 Beginning:

 Screen present?
 If yes, ok  I will wait.
 after 200 milliseconds..

 Screen present?
 If yes, ok  I will wait.
  after 200 milliseconds..

 Screen still present?
 If no, ok perfect I don't need to wait any more. You told me to wait up to 20 seconds, but loader disappeared withing 1 second. Go ahead and use that element.


Thread.sleep() it's like a Sloth.
Explicit wait - it's like rabbit.

If you have ::

org.openqa.selenium.ElementNotInteractableException: element not interactable

Then
put before waitUntilLoaderScreenDisappear(driver)

Test case::

Daily repeat option, Repeat every
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify that Daily is selected by default
Verify day(s) checkbox is selected and default value is 1
Verify summary says Daily every 1 day
  Check the weekday checkbox
Verify that days input now disabled
Verify summary says Daily every weekday


    //since vytrack displays overlay loading screen during loading of the page
        //we have wait, until that overlay screen disappear
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);


If you have ClickInterceptedException - try  to use clickWithWait




Daily repeat option, Repeat every
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify that Daily is selected by default
Verify day(s) checkbox is selected and default value is 1
Verify summary says Daily every 1 day
  Check the weekday checkbox
Verify that days input now disabled
Verify summary says Daily every weekday


Daily repeat option, Repeat every, default values
Log in as Valid user
Go to Activities -> Calendar Events
Click on create new calendar event
Click on Repeat checkbox
Verify that Daily is selected by default
Verify day(s) checkbox is selected and default value is 1
Verify summary says Daily every 1 day






     */
}

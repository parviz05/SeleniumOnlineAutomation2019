package com.cybertek.test.day14_Action_JSExecutor;

public class NOTE {
    /*
    Today is 7/17/2019

Agenda:
	 Actions class
	 JavascriptExecutor

I had a small problem with saving a form.
doubleClick() worked, but application was generating 2 exact same forms. Since I couldn't reproduce this bug manually, that bug wasn't accepted by team.

The Selenium WebDriver's Advanced User Interactions API allows us to perform operations from keyboard events and simple mouse events to complex events such as dragging and dropping, holding a key and then performing mouse operations using the Actions class, and building a complex chain of events exactly like a user doing these manually.

The Actions class implements the builder pattern to create a composite action containing a
group of other actions.

build() -  Generates a composite action containing all actions so far, ready to be performed (and resets the internal builder state, so subsequent calls to {@link #build()} will contain fresh sequences).

We use build() before perform() when we have more than one action event.

moveToElement(element1).click(element2).build().perform();


Selenium will not have any problems to find element, unless element is not in the DOM. Even though element is not visible, webdriver will find it. If element is not in the DOM, you will get NoSuchElmentException.

//VERIFY THAT COLOR WILL CHANGE

#############

By casting the WebDriver instance to a JavascriptExecutor interface, we can execute the
JavaScript code in Selenium WebDriver:

JavascriptExecutor js = (JavascriptExecutor) driver;

In the following example, a single line of JavaScript code is executed to return the title of the page displayed in the driver.

The JavascriptExecutor interface provides the
executeScript() method to which we need to pass the JavaScript code:

String title = (String) js.executeScript("return document.title");


Sometimes, we cannot click on element with default selenium method. In this case, we can use JavascriptExecutor interface and perform click.

/**
 * Indicates that a driver can execute JavaScript, providing access to the mechanism to do so.
 *
 * <p>
 * Because of cross domain policies browsers enforce your script execution may fail unexpectedly
 * and without adequate error messaging. This is particularly pertinent when creating your own
 * XHR request or when trying to access another frame. Most times when troubleshooting failure it's
 * best to view the browser's console after executing the WebDriver request.
 */
   /*
    public interface JavascriptExecutor {


        QUESTION: When should I use JavascriptExecutor?

        When default selenium webdriver methods don't work.

                - You cannot click
- You want to scroll
- You want to change some attribute values
- Highlight element

        Example from work:

        I had to read value from disabled input box. I used jsexecutor to make it enabled and then I was able to read that value.


        String title = (String) js.executeScript("return document.title"); same as driver.getTitle();

        One small problem that I had during automation:

        I couldn't enter text completely into input box. The text was entered partially. So to overcome this issue, I used jsexecutor to set value of input box (entered text).


                js.executeScript("arguments[0].scrollIntoView(true)", footerLink);

.scrollIntoView(true) - scroll until footerLink element will be visible.
                arguments[0] - means first parameter. We can specify more then one parameter.

        @param script The JavaScript to execute
   * @param args The arguments to the script. May be empty
   * @return One of Boolean, Long, Double, String, List, Map or WebElement. Or null.
                */
   /*

        Object executeScript(String script, Object... args);

############### To scroll and click with JSExcecutor
        @Test
        public void scrollTest2(){
            driver.get("http://practice.cybertekschool.com");
            WebElement footerLink = driver.findElement(By.linkText("Cybertek School"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            SeleniumUtils.waitPlease(2);
            //scroll until footerLink is not visible
            //ones you see footerLink, script will stop scrolling
            js.executeScript("arguments[0].scrollIntoView(true)", footerLink);
            SeleniumUtils.waitPlease(2);
            //to click with jsexecutor
            js.executeScript("arguments[0].click()", footerLink);
            SeleniumUtils.waitPlease(2);

        }



######## To enter text with JSExecutor
"@Test
        public void jsSendKeys() throws InterruptedException {
            driver.get(""http://practice.cybertekschool.com/dynamic_controls"");
            Actions actions = new Actions(driver);
            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement element = driver.findElement(By.cssSelector(""#input-example>input""));
            Thread.sleep(1000);
            String text = ""asdfasfsadfasdf"";
            js.executeScript(""arguments[0].setAttribute('value', '"" + text +""')"", element);

        }"

                */
}

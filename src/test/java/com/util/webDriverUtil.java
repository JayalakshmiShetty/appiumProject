package com.kanzi.qa.util;
/*************************************** PURPOSE **********************************
 * - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 
 
 */

//
//
//
//	import org.openqa.selenium.JavascriptExecutor;
//	import org.openqa.selenium.Keys;
//
//	import org.openqa.selenium.interactions.Actions;
//	import org.openqa.selenium.support.ui.Select;
//
//	import static org.openqa.selenium.Keys.TAB;
//
//	public class webDriverUtil extends TestBase {
//
//	    public static int WEBELEMENT_DEFAULT_TIMEOUT = 20;
//
//	    public static boolean isElementDisplayed(WebElement element) {
//	        try {
//	            return element.isDisplayed();
//	        } catch (Exception e) {
//	            return false;
//	        }
//	    }
//	    public static boolean isEnabled(WebElement webElement) {
//	      if (webElement != null) {
//	          String disabled = webElement.getAttribute("disabled");
//	          if (disabled == null) {
//	              disabled = webElement.getAttribute("aria-disabled");
//	              if (disabled == null) {
//	                  return true;
//	              } else {
//	                  return !disabled.equalsIgnoreCase("true");
//	              }
//	          } else {
//	              return !(disabled.equalsIgnoreCase("disabled") || disabled.equalsIgnoreCase("true"));
//	          }
//	      }
//	      return false;
//	  }
//
//	  public static boolean isHidden(WebElement webElement) {
//	      if (webElement != null) {
//	          String hidden = webElement.getAttribute("hidden");
//	          if (hidden == null) {
//	              hidden = webElement.getAttribute("aria-hidden");
//	              if (hidden == null) {
//	                  return false;
//	              } else {
//	                  return hidden.equalsIgnoreCase("true");
//	              }
//	          } else {
//	              return (hidden.equalsIgnoreCase("hidden") || hidden.equalsIgnoreCase("true"));
//	          }
//	      }
//	      return false;
//	  }
//	    public static void enterText(WebElement element, String value) throws Exception {
//	        clickElement(element);
//	       element.clear();
//	        element.sendKeys(value);
//	        element.sendKeys(TAB);
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	    }
//	    public static void switchToDefaultFrame() throws Exception {
//	        PageFactory.getDriver().switchTo().defaultContent();
//	    }
//	    public static void switchToParentFrame() throws Exception {
//	        PageFactory.getDriver().switchTo().parentFrame();
//	    }
//	    public static void enterTextWithoutClick(WebElement element, String value) throws Exception {
//	        element.sendKeys(value);
//	        element.sendKeys(TAB);
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	    }
//
//	    public static void enterTextInSequenceWithoutClick(WebElement element, String value) throws Exception {
//	        for (int i = 0; i < value.length(); i++) {
//	            element.sendKeys(value.substring(i, i + 1));
//	            WaitUtil.waitFor(100);
//	        }
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	    }
//
//	    public static void enterTextAfterCtrlA(WebElement element, String value) throws Exception {
//	        element.sendKeys(Keys.chord(Keys.CONTROL, "a"),value);
//	        WaitUtil.waitFor(100);
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	    }
//
//	    public static void enterTextInSequence(WebElement element, String value, boolean tab) throws Exception {
//	        clickElement(element);
//	        element.clear();
//	        for (int i = 0; i < value.length(); i++) {
//	            element.sendKeys(value.substring(i, i + 1));
//	            //WaitUtil.waitFor(400);
//	        }
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	        if (tab) {
//	            element.sendKeys(TAB);
//	        }
//	        String id =  element.getAttribute("id");
//	        if (id.equalsIgnoreCase("Landing_Search_PAX")) {
//	            element.sendKeys(Keys.ENTER);
//	            WaitUtil.waitFor(400);
//	        }
//	    }
//	    public static void enterTextInSequenceSearch(WebElement element, String value, boolean tab) throws Exception {
//	      clickElement(element);
//	      element.clear();
//	      for (int i = 0; i < value.length(); i++) {
//	          element.sendKeys(value.substring(i, i + 1));
//	          WaitUtil.waitFor(300);
//	      }
//	      PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	      if (tab) {
//	          element.sendKeys(TAB);
//	      }
//	  }
//	    
//	   
//	    public static void enterTextInSequenceIterative(WebElement element, String value, boolean tab) throws Exception {
//
//	        clickElement(element);
//
//	        for (int i = 0; i < value.length(); i++) {
//	            element.sendKeys(value.substring(i, i + 1));
//	            WaitUtil.waitFor(100);
//	        }
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//
//	        if (tab) {
//	            element.sendKeys(TAB);
//	        }
//	    }
//
//	    public static void enterTextWithOutTab(WebElement element, String value) throws Exception {
//
//	        // element.click();
//	        WaitUtil.waitForJStoLoad();
//	        clickElement(element);
//	        element.clear();
//	        element.sendKeys(value);
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	    }
//
//	    public static void switchToFrame(WebElement frameLocator){
//	        PageFactory.getDriver().switchTo().frame(frameLocator);
//	    }
//
//
//	    public static void clickElement(WebElement element) throws Exception {
//	        WaitUtil.waitForJStoLoad();
//	        int seconds = WEBELEMENT_DEFAULT_TIMEOUT;
//	        long time = 1000 * seconds;
//	        boolean timeout = false;
//	        while (!timeout && time > 0) {
//	            try {
//	            	 
//	                element.click();
//	                timeout = true;
//	                Thread.sleep(100);
//	            } catch (Exception e) {
//	                timeout = false;
//	                Thread.sleep(100);
//	                time = time - 100;
//	            }
//	        }
//	        PageFactory.getHomePageInstance().waitForSpinningLoaderToDisapper();
//	        if (!timeout) {
//	            throw new Exception("Element not clickable at the moment");
//	        }
//	        // WaitUtil.waitForJStoLoad();
//	    }
//
//	    public static String getElementValue(WebElement element) throws Exception {
//	        WaitUtil.waitForJStoLoad();
//	        WaitUtil.waitUntilVisible(element);
//	        return getText(element);
//	    }
//
//	    public static String getElementValue2(WebElement element) throws Exception {
//	        WaitUtil.waitForJStoLoad();
//	        WaitUtil.waitUntilVisible(element);
//	        return element.getAttribute("value");
//	    }
//
//	    public static String getElementValueWithoutWait(WebElement element) throws Exception {
//	        WaitUtil.waitForJStoLoad();
//	        return element.getText();
//	    }
//
//	    public static String getAttributeValue(WebElement element, String attribute) throws Exception {
////	        WaitUtil.waitUntilVisible(element);
//	        WaitUtil.waitForJStoLoad();
//	        return element.getAttribute(attribute);
//	    }
//
//	    public static void selectByValue(WebElement element, String value) throws Exception {
//	        WaitUtil.waitUntilVisible(element);
//	        Select dropDown = (Select) element;
//	        WaitUtil.waitForJStoLoad();
//	        dropDown.selectByValue(value);
//	        WaitUtil.waitForJStoLoad();
//	    }
//	    public static void selectByVisibleText(WebElement element, String text) throws Exception {
//	        WaitUtil.waitUntilVisible(element);
//	        Select dropDown = new Select(element);
//	        dropDown.selectByVisibleText(text);
//	        WaitUtil.waitForJStoLoad();
//	    }
//
//	    public static void selectByIndex(WebElement element, int index) throws Exception {
//	        WaitUtil.waitUntilVisible(element);
//	        WaitUtil.waitForJStoLoad();
//	        Select dropDown = (Select) element;
//	        dropDown.selectByIndex(index);
//	        WaitUtil.waitForJStoLoad();
//	    }
//
//	    public static void clickWithJquery(String cssPath) {
//	        JavascriptExecutor jse = (JavascriptExecutor) PageFactory.getDriver();
//	        jse.executeScript("document.querySelector('" + cssPath + "').click();");
//	    }
//
//	    public static boolean isElementEnabled(WebElement element) {
//	        try {
//	            return element.isEnabled();
//	        } catch (Exception e) {
//	            return false;
//	        }
//	    }
//
//	    public static String getText(WebElement element) throws Exception {
//	        WaitUtil.waitForJStoLoad();
//	        int seconds = WEBELEMENT_DEFAULT_TIMEOUT;
//	        long time = 1000 * seconds;
//	        boolean timeout = false;
//	        String text = null;
//	        while (!timeout && time > 0) {
//	            try {
//	                text = element.getText();
//	                if (!StringUtils.isEmpty(text)) {
//	                    Thread.sleep(100);
//	                    timeout = true;
//	                }
//	            } catch (Exception e) {
//	                timeout = false;
//	                Thread.sleep(100);
//	                time = time - 100;
//	            }
//	        }
//	        if (!timeout) {
//	            throw new Exception("Failed to retrieve text from the element");
//	        }
//	        return text;
//	    }
//
//	    public static void executeJavaScriptQuery(String query){
//	        JavascriptExecutor js = (JavascriptExecutor) PageFactory.getDriver();
//	        js.executeScript(query);
//	    }
//
//	    public static void scrollDown() throws InterruptedException {
//	        JavascriptExecutor js = (JavascriptExecutor) PageFactory.getDriver();
//	        js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
//	}
//
//	  public static void refreshPage() {
//	    WebDriver driver = PageFactory.getDriver();
//	    driver.navigate().refresh();
//	  }
//	  public static void mouseHover(WebElement element) throws Exception{
//		  Actions action = new Actions(PageFactory.getDriver());
//		 try{
//		  action.moveToElement(element).build().perform();
//		 }
//		 catch(Exception e){
//			 throw new Exception("Unable to move mouse to element");
//		 }
//	  }
//	  
//	  public static boolean checkImmediateElementAvailable(By locator) throws Exception{
//		  try{
//		      WaitUtil.waitForJStoLoad();
//		  WEBELEMENT_DEFAULT_TIMEOUT  = 2;
//		  WaitUtil.waitFor(300);
//		  boolean temp =  PageFactory.getDriver().findElement(locator).isDisplayed();		  
//		  WEBELEMENT_DEFAULT_TIMEOUT  = 20;
//		  return temp;
//		  }catch(Exception e){
//			  WEBELEMENT_DEFAULT_TIMEOUT  = 20;
//			  return false;
//		  }
//		  
//		  
//	  }
//	  public void switchToDefaultContent() throws Exception{
//		  PageFactory.getDriver().switchTo().defaultContent();
//	  }
//
//

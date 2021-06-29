package com.base;

import com.util.TestUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
	public static AndroidDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;


public TestBase()
{		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/android.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public static void initialization() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "11");
		desiredCapabilities.setCapability("deviceName", "Samsung");
		desiredCapabilities.setCapability("app", System.getProperty("user.dir")+"/src/test/resources/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
		desiredCapabilities.setCapability("appPackage","com.swaglabsmobileapp");
 		desiredCapabilities.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
		desiredCapabilities.setCapability("unicodeKeyboard", "true");
		desiredCapabilities.setCapability("resetKeyboard", "true");
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);


		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, TestUtil.IMPLICIT_WAIT);

	}

}

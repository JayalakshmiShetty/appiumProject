package com.util;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static org.openqa.selenium.Keys.TAB;

import java.security.SecureRandom;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.base.TestBase;

public class TestUtil extends TestBase {
	
	public static int PAGE_LOAD_TIMEOUT  = 50;
	public static long IMPLICIT_WAIT = 50;


	static SecureRandom rnd = new SecureRandom();

	public static void clickAction(WebElement element, AndroidDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click();
		builder.perform();
	}


public static void tapOnElement(MobileElement element){
	TouchActions action = new TouchActions(driver);
	action.singleTap(element);
	//action.perform();
}

	public static void swipeElement(WebElement firstElement, WebElement second) throws InterruptedException {
		TouchAction t=new TouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement((ElementOption) firstElement).withDuration(Duration.ofSeconds(2))).moveTo((ElementOption) second).release().perform();
	}
	//Horizontal Swipe by percentages
	public static void horizontalSwipeByPercentage (AndroidDriver driver, double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * endPercentage);

		new TouchAction(driver)
				.press(PointOption.point(startPoint, anchor))
				.waitAction(new WaitOptions().withDuration(Duration.ofMillis(800)))
				.moveTo(PointOption.point(endPoint, anchor))
				.release().perform();
	}

	public static void scrollAndTapOnText(AndroidDriver driver, String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").click();
	}

	public static void scrollTillFullTextAndTap( AndroidDriver driver, String text){

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+text+"\").instance(0))").click();
	}

	public static void typeText( AndroidDriver driver, String elementText, String text){

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""+elementText+"\").instance(0))").sendKeys(text);
	}
	public static String scrollAndGetText( AndroidDriver driver, String text){

		String result=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))").getText();
	return result;
	}

	public static void scrollTillWebView( AndroidDriver driver, String text){

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))");
	}
	public static void selectFromList(List<WebElement> options, String value) throws InterruptedException {
		for(int i=0;i<options.size();i++)
		{
			String str=options.get(i).getText();
			if (str.equalsIgnoreCase(value)) {
				options.get(i).click();
				break;
			}}
	}


		
	//Method to capture the Screen shots at the end only when testcase is failed
	public static void takeScreenshotAtEndOfTest() throws Exception {
		try {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.Dir");
				//"MyfilePATH");
		FileUtils.copyFile(scrFile, new File("/screenshots/" +currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}catch (Exception ex) {
		System.out.println(ex.getMessage());
	}}	
	//Method to capture the Screen shots
		public static void takeScreenshot(String fileName) throws IOException {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\Pradap\\Desktop\\testAutomationAssignment"+fileName+".jpg"));
		}
		




	public static void clickElement(WebElement element) throws InterruptedException {

        int seconds = PAGE_LOAD_TIMEOUT;
        long time = 1000 * seconds;
        boolean timeout = false;
        while (!timeout && time > 0) {
            try {
            	element.click();
                timeout = true;
                Thread.sleep(100);
            } catch (Exception e) {
                timeout = false;
                Thread.sleep(100);
                time = time - 100;
            }
        }
	}

	public static int GetRowNumberForSpecificTest(String SheetName, String stringToCompare)throws Exception{
		FileInputStream fileInputStream = null;
		int rowNum=0;
		try{
			fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(SheetName);
			Iterator<Row> rowIterator = worksheet.iterator();
			int rowNumber=0;
			while (rowIterator.hasNext()) {
				rowNumber++;
				Row row = rowIterator.next();
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase(stringToCompare)) {
					rowNum=rowNumber;
					break;
				}
			}
		}
		catch (Exception e){
			e.printStackTrace();
			// throw new Exception("Failed to retrieve value from test data xlsx");
		}
		return rowNum;
	}


	public static String[] ReadExcelValues(String SheetName, String TestCaseRef) throws Exception
	{
		int rowNum = GetRowNumberForSpecificTest(SheetName, TestCaseRef);
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Creating a workbook
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(rowNum-1);
		String[] value = new String[row.getLastCellNum()];
		for(int i = 0; i <= row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i);

			if(cell!=null && cell.getCellType() != Cell.CELL_TYPE_BLANK && cell.getCellType() == Cell.CELL_TYPE_STRING) {
				value[i]=cell.getStringCellValue();
			}else if(cell!=null && cell.getCellType() != Cell.CELL_TYPE_BLANK && cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				value[i]=String.valueOf((int) cell.getNumericCellValue());
			}

		}String[]newValue=Arrays.copyOfRange(value, 1, value.length);
		return newValue;
	}


	public static String GetSpecificParameterValueForGivenTestFromExcel(String SheetName, String Parameter, String TestCaseRef) throws Exception{
		String val=null;

		try{
			int rowNum = GetRowNumberForSpecificTest(SheetName, TestCaseRef);
			int colNum = 0;
			FileInputStream    fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/klipClearTestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(SheetName);

			Iterator<Cell> cellIterator = worksheet.getRow(0).cellIterator();
			int colNumber=0;
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				if(cell.getStringCellValue().equalsIgnoreCase(Parameter)) {
					colNum = colNumber;
					break;
				}
				colNumber++;
			}
			// System.out.println(worksheet.getRow(rowNum-1).getCell(colNumber));

			Cell cell =  worksheet.getRow(rowNum-1).getCell(colNumber);
			// System.out.println(cell.CELL_TYPE_STRING);
			// System.out.println( "Type is"+cell.getCellType());
			String cellValue;
			if(cell.getCellType()==0)
			{
				cellValue= String.valueOf(cell.getNumericCellValue());
			}
			else
			{cellValue=cell.getStringCellValue();}

			return cellValue;}

		catch (Exception e){

			throw new Exception("Failed to retrieve value from test data xlsx");
		}

	}
		    }
	
	


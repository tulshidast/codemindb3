package com.codemind.b3project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {

	public static String getProperty(String key) {
		Properties properties = new Properties();
		try {
			File file = new File("src/test/resources/masterData.properties");
			FileInputStream fileInputStream;

			fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	public static void scrollTillEndOfThePage(WebDriver driver) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript(("window.scrollTo(0, document.body.scrollHeight)"));
	}

	public static void takeScreenShot(WebDriver driver) {
		try {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("screenshoot/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void selectValueFromDropDownCommingUnderSelectTag(WebElement dropdownLocator, String dropDownOption) {

		Select select = new Select(dropdownLocator);
		select.selectByVisibleText(dropDownOption);

	}

	public static void waitForPageTitle(WebDriver driver, int duration, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public static void getScreenShot(String name, WebDriver driver) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(file, new File("screenshoot/"+name+System.currentTimeMillis()+".png"));
	}
	
	

}

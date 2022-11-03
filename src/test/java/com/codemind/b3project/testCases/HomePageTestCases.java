package com.codemind.b3project.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.codemind.b3project.UtilityMethods;
import com.codemind.b3project.pages.HomePage;

//@Listeners(TestNgListner.class)
public class HomePageTestCases {

	WebDriver driver;
	HomePage homePage;

	@BeforeMethod
	public void initilizeBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Test(dataProvider = "myDataProvider",description="This test case with data provider")
	public void verifyValidLogin(String username, String password) {
		homePage = new HomePage(driver);
		driver.get(UtilityMethods.getProperty("url"));
		homePage.setUserName();
		homePage.getUserName().sendKeys(username);
		// homePage.setPassword();
		homePage.getPassword().sendKeys(password);
		homePage.setLoginButton();
		homePage.getLoginButton().click();
		UtilityMethods.scrollTillEndOfThePage(driver);
		homePage.setLoginSuccessfullMsg();
		assertEquals(homePage.getLoginSuccessfullMsg().getText(), "Login Successfully");
		// softassert is also known as verify
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(homePage.getLoginSuccessfullMsg().getText(), "Login Successfully");
		//UtilityMethods.takeScreenShot(driver);
	}

	@org.testng.annotations.DataProvider(name = "myDataProvider")
	public String[][] dataProvider() {
		String array[][] = { { "user1", "password1" } };
		return array;
	}

	@Test()
	public void verifyRegistrationFunctionality() {
		homePage = new HomePage(driver);
		driver.get(UtilityMethods.getProperty("url"));
		homePage.setRegisterLink();
		homePage.getRegisterLink().click();
		assertTrue(driver.getTitle().equals("Register: Mercury Tours"), "Title doesn't matched");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				UtilityMethods.getScreenShot(result.getName() + System.currentTimeMillis(), driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}

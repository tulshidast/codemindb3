package com.codemind.b3project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import com.codemind.b3project.TestNgListner;

@Listeners(TestNgListner.class)
public class RegistrationPage {
	WebDriver driver;
	WebElement firstNameTextBox;
	WebElement submitButton;
	WebElement countryDropDown;
	WebElement registrationSuccessfullMsg;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstNameTextBox() {
		return firstNameTextBox;
	}

	public void setFirstNameTextBox() {
		firstNameTextBox = driver.findElement(By.xpath("//input[@name='firstName']"));
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton() {
		submitButton = driver.findElement(By.xpath("//input[@name='submit']"));
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public void setCountryDropDown() {
		countryDropDown = driver.findElement(By.xpath("//select[@name='country']"));
	}

	public WebElement getRegistrationSuccessfullMsg() {
		return registrationSuccessfullMsg;
	}

	public void setRegistrationSuccessfullMsg() {
		registrationSuccessfullMsg = driver.findElement(By.xpath("//*[contains(text(),'Dear')]"));
	}
}

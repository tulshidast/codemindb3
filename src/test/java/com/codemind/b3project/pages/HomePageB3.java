package com.codemind.b3project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageB3 {

	WebDriver driver;

	public HomePageB3(WebDriver driver) {
		this.driver = driver;
	}

	WebElement userName;
	WebElement password;
	WebElement loginButton;
	WebElement loginSuccessfullMsg;
	WebElement registerLink;

	public WebElement getUserName() {
		return userName;
	}

	public void setUserName() {
		userName = driver.findElement(By.xpath("//input[@name='userName']"));
	}

	public WebElement getPassword() {
		password = driver.findElement(By.xpath("//input[@name='password']"));
		return password;
	}

//	public void setPassword() {
//		
//	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton() {
		loginButton = driver.findElement(By.xpath("//input[@name='submit']"));
	}

	public WebElement getLoginSuccessfullMsg() {
		return loginSuccessfullMsg;
	}

	public void setLoginSuccessfullMsg() {
		loginSuccessfullMsg = driver.findElement(By.xpath("//h3[text()='Login Successfully']"));
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public void setRegisterLink() {
		registerLink = driver.findElement(By.linkText("REGISTER"));
	}

}

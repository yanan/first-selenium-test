package com.liferay.forms.action;

import com.liferay.forms.page.FirstPage;
import com.liferay.forms.ui.UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPageAction extends GeneralAction implements UI{
	private static FirstPageAction _firstPageAction;
	public static FirstPageAction getInstance(WebDriver driver) {
		if (_firstPageAction == null) {
			_firstPageAction = new FirstPageAction(driver);
		}

		return _firstPageAction;
	}

	private final FirstPage _firstPage = new FirstPage();

	public FirstPageAction(WebDriver driver) {
		super(driver);
	}

	public void clickDatePickerBtn() {
		clickButton(_firstPage.datePickerBtn);
	}

	public void moveToLanguageBtn() {
		moveToElement(_firstPage.languageBtn);
	}
	
	public void prepareForms(String userName, String dateOfBirth, String reason) {
		setUserName(userName);

		setDate(dateOfBirth);

		setReasonArea(reason);
	}

	public void selectADate() {
		WebElement selectedDate = driver.findElement(_firstPage.selectDate);

		selectedDate.click();
	}

	public void setDate(String dateOfBirth) {
		driver.findElement(_firstPage.dateField).sendKeys(dateOfBirth);
	}

	public void setReasonArea(String reasonArea) {
		driver.findElement(_firstPage.reasonArea).sendKeys(reasonArea);
	}
	
	public void setUserName(String userName) {
		driver.findElement(_firstPage.nameInput).sendKeys(userName);
	}

	public void submit() {
		implicitWait();

	    clickButton(_firstPage.submitBtn);
	}

	public void submitForms(String userName, String dateOfBirth, String reason) {
		prepareForms(userName, dateOfBirth, reason);

		submit();
	}

	public void switchLanguage() {
		clickButton(_firstPage.languageBtn);

		clickButton(_firstPage.portuguesBtn);
	}
	
	public void waitForDatePickerBtnPresent() {	
		waitUntilElementPresent(_firstPage.datePickerBtn);
	}

	public void waitSubmitBtnClickable() {
		waitElementClickable(_firstPage.submitBtn);
	}
}
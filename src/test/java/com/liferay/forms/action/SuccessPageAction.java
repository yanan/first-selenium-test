package com.liferay.forms.action;

import com.liferay.forms.page.SubmitSuccessPage;

import org.openqa.selenium.WebDriver;

public class SuccessPageAction extends GeneralAction{
	private static SuccessPageAction _successPageAction;

	public static SuccessPageAction getInstance(WebDriver driver) {
		if (_successPageAction == null) {
			_successPageAction = new SuccessPageAction(driver);
		}

		return _successPageAction;
	}

	private final SubmitSuccessPage _successPage = new SubmitSuccessPage();

	public SuccessPageAction(WebDriver driver) {
		super(driver);
	}

	public void clickSubmitAgain() {
		clickButton(_successPage.submitAgainBtn);
	}

	public void waitForSubmitAgainBtn() {
		waitUntilElementPresent(_successPage.submitAgainBtn);
	}
}
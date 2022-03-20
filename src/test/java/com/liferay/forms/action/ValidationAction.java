package com.liferay.forms.action;

import com.liferay.forms.page.FirstPage;
import com.liferay.forms.page.SubmitSuccessPage;
import com.liferay.forms.util.LabelsInfo;

import java.io.File;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidationAction extends GeneralAction{

	private static ValidationAction _validationAction;

	public static ValidationAction getInstance(WebDriver driver) {
		if (_validationAction == null) {
			_validationAction = new ValidationAction(driver);
		}

		return _validationAction;
	}

	private final FirstPage _firstPage = new FirstPage();

	private final SubmitSuccessPage _successPage = new SubmitSuccessPage();

	public ValidationAction(WebDriver driver) {
		super(driver);
	}

	public void assertActionsDisplay() {
		WebElement actionsTag = driver.findElement(_firstPage.actionsTag);

		Assert.assertTrue(actionsTag.isDisplayed());
	}

	public void assertFieldRequiredDispaly() {
		WebElement fieldRequired = driver.findElement(_firstPage.fieldRequired);

		Assert.assertTrue(fieldRequired.isDisplayed());
	}

	public void assertInfoReceivedMsg(String expectInfo) {
		WebElement infoReceivedLabel = driver.findElement(_successPage.infoReceivedLabel);

		Assert.assertEquals(expectInfo, infoReceivedLabel.getText());
	}

	public void assertPartyRockMsg(String expectInfo) {
		WebElement partyRockLabel = driver.findElement(_firstPage.partyRock);

		Assert.assertEquals(expectInfo, partyRockLabel.getText());
	}

	public void assertPortuguesHeader(String expectHeader) {
		 WebElement headerMsg = driver.findElement(_successPage.headerLabel);

		 Assert.assertEquals(expectHeader, headerMsg.getText());
	}

	public void assertSubmeterPortugues(String expected) {
		WebElement submeterBtn = driver.findElement(_firstPage.submitBtn);

		Assert.assertEquals(expected, submeterBtn.getText());
	}
	
	public void assertSuccessAlert() {
		WebElement successAlert = driver.findElement(_successPage.successAlert);

		Assert.assertEquals(ALERT_SUCCESS, successAlert.getText());
	}

	public boolean assertTextPresent(String findText) {

		WebElement activeElements = driver.switchTo().activeElement();

		if(activeElements.getText().contains(findText)) {
			return true;
		}else {
			return false;
		}
	}

	public void assertTitleEquals(String expectedTitle) {
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}

	public void assertLabelsInEnglishWithCssLocator(String resourceFile) {

		for (LabelsInfo info : getValidationMsgs(new File(getResourcesFile(resourceFile) ))) {
			Assert.assertEquals(driver.findElement(By.cssSelector(info.get_elementBy())).getText(),info.get_lableInEnglish());
		}
	}
	
	public void assertLabelsInPortuguesWithCssLocator(String resourceFile) {

		for (LabelsInfo info : getValidationMsgs(new File(getResourcesFile(resourceFile) ))) {
			Assert.assertEquals(driver.findElement(By.cssSelector(info.get_elementBy())).getText(),info.get_labelInPortugues());
		}
	}

	public void assertLabelsInEnglishWithXPath(String resourceFile) {
		for (LabelsInfo info : getValidationMsgs(new File(getResourcesFile(resourceFile) ))) {
			Assert.assertEquals(driver.findElement(By.xpath(info.get_elementBy())).getText(),info.get_lableInEnglish());
		}
	}

	public void assertLabelsInPortuguesWithXPath(String resourceFile) {
		for (LabelsInfo info : getValidationMsgs(new File(getResourcesFile(resourceFile) ))) {
			Assert.assertEquals(driver.findElement(By.xpath(info.get_elementBy())).getText(),info.get_labelInPortugues());
		}
	}
}

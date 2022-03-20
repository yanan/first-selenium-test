package com.liferay.forms.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class AcceptanceTest extends LiferayFormsBase{
	Date date=new Date();

	SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/YYYY");

	String currentDate = dateFormat.format(date);

	String empty = "";

	@Test
	public void validationRequiredField() {
		firstPageAction.prepareForms(empty, currentDate, "This is a test");

		validationAction.assertFieldRequiredDispaly();

		validationAction.assertTitleEquals(LIFERAY_FORM_TITLE);

		firstPageAction.prepareForms("test", "letter", "Second test");

		validationAction.assertFieldRequiredDispaly();

		validationAction.assertTitleEquals(LIFERAY_FORM_TITLE);

		firstPageAction.prepareForms("test","10/20/2000", empty);

		validationAction.assertTitleEquals(LIFERAY_FORM_TITLE);

		validationAction.assertFieldRequiredDispaly();
	}

	@Test
	public void validateEnglishLabels() {	
		//check default language
		validationAction.assertLabelsInEnglishWithCssLocator("LabelsInFirstPage.csv");

		firstPageAction.submitForms("test", "10/20/2000", "10202000");

		successPageAction.waitForSubmitAgainBtn();

		validationAction.assertInfoReceivedMsg(RECEIVED_SUCCESSFULLY);

		validationAction.assertLabelsInEnglishWithXPath("LabelsInSuccessPage.csv");;

		successPageAction.clickSubmitAgain();
		
		firstPageAction.waitForDatePickerBtnPresent();
	}

	@Test
	public void validatePortuguesLabels() {
		//switch language and check
		firstPageAction.moveToLanguageBtn();

		validationAction.assertActionsDisplay();

		firstPageAction.switchLanguage();

		firstPageAction.implicitWait();

		firstPageAction.waitSubmitBtnClickable();

		validationAction.assertLabelsInPortuguesWithCssLocator("LabelsInFirstPage.csv");

		firstPageAction.submitForms("test again", "10/20/2000", "Test!!!");

		successPageAction.waitForSubmitAgainBtn();

		validationAction.assertInfoReceivedMsg(RECEIVED_SUCCESSFULLY);

		validationAction.assertLabelsInPortuguesWithXPath("LabelsInSuccessPage.csv");;
	}

	@Test
	public void submitAndSubmitAgainForms() {
		validationAction.assertTitleEquals(LIFERAY_FORM_TITLE);

		firstPageAction.submitForms("test", currentDate, "WORKFLOW TEST");

		validationAction.assertSuccessAlert();
		
		successPageAction.waitForSubmitAgainBtn();

		validationAction.assertTitleEquals(SECOND_PAGE_TITLE);

		//submit a same form using submit again redirect link
		successPageAction.clickSubmitAgain();

		firstPageAction.waitForDatePickerBtnPresent();

		firstPageAction.waitSubmitBtnClickable();

		firstPageAction.implicitWait();

		firstPageAction.submitForms("test", currentDate, "WORKFLOW TEST");

		successPageAction.waitForSubmitAgainBtn();

		validationAction.assertInfoReceivedMsg(RECEIVED_SUCCESSFULLY);
	}

	@Test
	public void submitWithDatePicker() {
		firstPageAction.setUserName("test again");

		firstPageAction.clickDatePickerBtn();

		firstPageAction.selectADate();

		firstPageAction.setReasonArea("Select a date");

		firstPageAction.submit();

		successPageAction.waitForSubmitAgainBtn();

		validationAction.assertSuccessAlert();

		validationAction.assertInfoReceivedMsg(RECEIVED_SUCCESSFULLY);
	}

	@Test
	public void submitWithSwitchingLanguage() {
		//switchLanguage and submit a form
		firstPageAction.moveToLanguageBtn();

		firstPageAction.switchLanguage();

		firstPageAction.implicitWait();

		firstPageAction.waitSubmitBtnClickable();

		firstPageAction.submitForms("test1", currentDate, currentDate);

		successPageAction.waitForSubmitAgainBtn();

		validationAction.assertInfoReceivedMsg(RECEIVED_SUCCESSFULLY);
	}
}

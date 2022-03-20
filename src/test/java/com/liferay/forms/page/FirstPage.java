package com.liferay.forms.page;

import org.openqa.selenium.By;

public class FirstPage {
	public By actionsTag = By.xpath("//*[@id=\"_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_kldx___menu\"]");

	public By ageDescription = By.cssSelector("span.lfr-ddm__default-page-header-description");

	public By dateField = By.cssSelector(".input-group-inset");

	public By dateOfBirthLabel = By.cssSelector("div.col-ddm:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1)");

	public By datePickerBtn = By.cssSelector(".lexicon-icon-calendar");

	public By fieldRequired = By.cssSelector(".form-feedback-item");

	public By firstFormPageHeader2 = By.cssSelector("h2.lfr-ddm-form-page-title");

	public By indicatesRequired = By.cssSelector("p.text-secondary");

	public By languageBtn = By.cssSelector(".btn-section");

	public By moveMonthRight = By.cssSelector(".lexicon-icon-angle-right");

	public By nameInput = By.cssSelector("input.ddm-field-text");

	public By pageHeader1 = By.cssSelector("div.lfr-ddm__default-page-header > h1.lfr-ddm__default-page-header-title");

	public By partyRock = By.cssSelector("h3.lfr-ddm-form-page-description");

	public By portuguesBtn = By.xpath("/html/body/div[1]/div/div/div/ul/li/a/span[2]");

	public By reasonArea = By.cssSelector("textarea.ddm-field-text");

	public By reasonLabel= By.cssSelector("div.ddm-row:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1)");

	public By selectDate = By.cssSelector("button.active");

	public By submitBtn = By.xpath("//*[@id=\"ddm-form-submit\"]");

	public By yourNameLabel = By.cssSelector(".col-md-7 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > label:nth-child(1)");
}
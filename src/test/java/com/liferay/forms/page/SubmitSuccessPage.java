package com.liferay.forms.page;

import org.openqa.selenium.By;

public class SubmitSuccessPage {
	public By headerLabel = By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[1]/h1");

	public By infoReceivedLabel = By.xpath("//*[@id=\"p_p_id_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_\"]/div/div/div[2]/p");

	public By submitAgainBtn = By.xpath("/html/body/div[1]/div[1]/div/div/div/div/div/div[2]/div/button");

	public By successAlert = By.xpath("//*[@id=\"ToastAlertContainer\"]/div/div/div/div[2]/div/div");

	public By thankYouLabel = By.xpath("///html/body/div[1]/div[1]/div/div/div/div/div/div[2]/h2");
}
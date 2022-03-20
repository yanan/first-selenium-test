package com.liferay.forms.tests;

import com.liferay.forms.action.FirstPageAction;
import com.liferay.forms.action.SuccessPageAction;
import com.liferay.forms.action.ValidationAction;
import com.liferay.forms.page.FirstPage;
import com.liferay.forms.ui.UI;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LiferayFormsBase implements UI{	
	public static FirefoxDriver driver;

	public static FirstPageAction firstPageAction;

	public static SuccessPageAction successPageAction;

	public static ValidationAction validationAction;	

	@AfterClass
	public static void clearDown() {	
		driver.quit();
	}

	@BeforeClass
	public static void prepareBrowserDriver() {
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();

		firstPageAction = FirstPageAction.getInstance(driver);

		successPageAction = SuccessPageAction.getInstance(driver);

		validationAction = ValidationAction.getInstance(driver);
	}

	@Before
	public void getURL() {
		driver.get(FORMS_URL);

		FirstPage _firstPage = new FirstPage();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		wait.until(ExpectedConditions.presenceOfElementLocated(_firstPage.datePickerBtn));
	}
	
}
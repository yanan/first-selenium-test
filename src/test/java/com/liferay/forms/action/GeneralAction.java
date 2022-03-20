package com.liferay.forms.action;

import com.liferay.forms.ui.UI;
import com.liferay.forms.util.CSVReader;
import com.liferay.forms.util.LabelsInfo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralAction implements UI{
	private static GeneralAction _generalPageAction;

	public static GeneralAction getInstance(WebDriver driver) {
		if (_generalPageAction == null) {
			_generalPageAction = new GeneralAction(driver);
		}

		return _generalPageAction;
	}

	protected WebDriver driver;

	public GeneralAction(WebDriver driver) {
		this.driver=driver;
	}

	public void clickButton(By button) {
		WebElement clickBtn = driver.findElement(button);

		new Actions(driver).moveToElement(clickBtn).perform();

		clickBtn.click();
	}

	public void implicitWait(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void moveToElement(By moveTo) {
		Actions action = new Actions(driver);  

		WebElement element = driver.findElement(moveTo);

		action.moveToElement(element).perform();  
    }
	
	public void refresh() {
		driver.navigate().refresh();
	}

	public void waitElementClickable(By elementBy) {
		implicitWait();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.elementToBeClickable(elementBy));	  

		WebElement element = driver.findElement(elementBy);

		Assert.assertTrue(element.isEnabled());
	}
	
	public void waitUntilElementPresent(By elementBy) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driverWait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
	}

	public LabelsInfo[] getValidationMsgs(File file) {
		Assert.assertTrue(file.exists());

		String[][] msgs = CSVReader.readCSV(file);

		LabelsInfo[] validationMsgs = new LabelsInfo[msgs.length];

		for (int i = 0; i < msgs.length; i++) {
			validationMsgs[i] = new LabelsInfo();

			String[] columns = msgs[i];

			for (int t = 0; t < columns.length; t++) {
				if (t == 0) {
					validationMsgs[i].set_elementBy(columns[t]);
				}
				else if (t == 1) {
					validationMsgs[i].set_lableInEnglish(columns[t]);
				}
				else if (t == 2) {
					validationMsgs[i].set_labelInPortugues(columns[t]);
				}
			}
		}

		return validationMsgs;
	}
	
	public String getResourcesFile(String fileName) {
		Path path = Paths.get("src","test","resources",fileName);

		return path.toAbsolutePath().toString();
	}
}

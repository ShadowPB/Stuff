package com.messanger.variables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Helper {

	public static final void waitByID(String id) {
		try {
			Constants.WAIT.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		} catch (Throwable e) {
			System.out.println("Unclickable ID");
			System.out.println(id);
			if (!Constants.DRIVER.getPageSource().contains("(phone for mobile accounts)")) {
				Constants.DRIVER.navigate().refresh();
				Constants.DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				waitByID(id);
			}
		}
	}

	public static final void waitByXPATH(String xPath) {
		try {
			Constants.WAIT.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
		} catch (Throwable e) {
			System.out.println("Unclickable xpath");
			if (!Constants.DRIVER.getPageSource().contains("(phone for mobile accounts)")) {
				Constants.DRIVER.navigate().refresh();
				Constants.DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				waitByXPATH(xPath);
			} else {
				Constants.DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
		}
	}

	public static final void navigateToTab(String tabID, String waitID) {
		checkForError();
		System.out.println("No error found - Clicking tab");
		WebElement tab = Constants.DRIVER.findElement(By.id(tabID));
		tab.click();

		if (waitID.contains("@")) {
			waitByXPATH(waitID);
		} else {
			waitByID(waitID);
		}
	}

	private static void checkForError() {
		Constants.DRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		while(Constants.DRIVER.findElement(By.tagName("body")).getText().contains("We are sorry. A processing")) {
			Constants.DRIVER.navigate().refresh();
		}
	}
}
package com.messanger.tasks.miscellaneous;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.main.ui.variables.LoginDetails;
import com.messanger.tasks.Task;
import com.messanger.variables.Constants;
import com.messanger.variables.Helper;
import com.messanger.variables.Variables;

public class SignIn extends Task {

	@Override
	public boolean activate() {
		return Constants.DRIVER.getPageSource().contains("(phone for mobile accounts)");
	}

	@Override
	public void execute() {
		WebElement username = Constants.DRIVER.findElement(By.id("ap_email"));
		WebElement password = Constants.DRIVER.findElement(By.id("ap_password"));
		username.clear();
		username.sendKeys(LoginDetails.EMAIL);

		password.clear();
		password.sendKeys(LoginDetails.PASSWORD);

		WebElement signInButton = Constants.DRIVER.findElement(By.id("signInSubmit"));
		signInButton.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		if(!Constants.DRIVER.getPageSource().contains("(phone for mobile accounts)")) {
			Helper.waitByXPATH(Constants.TOTAL_BUYER_URLS_ELEMENT);
			Variables.TOTAL_BUYERS = Integer.valueOf(Constants.DRIVER.findElement(By.xpath(Constants.TOTAL_BUYER_URLS_ELEMENT)).getText());
		}
	}
}

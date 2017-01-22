package com.messanger.tasks.sending;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.messanger.tasks.Task;
import com.messanger.variables.Constants;
import com.messanger.variables.Variables;

public class SendMessage extends Task {

	@Override
	public boolean activate() {
		return Constants.DRIVER.findElements(By.id("commMgrCompositionSubject")).size() >= 1;
	}

	@Override
	public void execute() {
		//Set subject
		Select subject = new Select(Constants.DRIVER.findElement(By.id("commMgrCompositionSubject")));
		subject.selectByVisibleText(Variables.SUBJECT_TEXT);
	
		//Input message
		WebElement descriptionBox = Constants.DRIVER.findElement(By.id("commMgrCompositionMessage"));
		descriptionBox.sendKeys(Variables.MESSAGE);
		
		//Click send button
		WebElement sendButton = Constants.DRIVER.findElement(By.id("sendemail_label"));
		JavascriptExecutor executor = (JavascriptExecutor) Constants.DRIVER;
		executor.executeScript("arguments[0].click();", sendButton);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Variables.MESSAGES_DONE++;
		System.out.println(Variables.MESSAGES_DONE + " of " + Variables.BUYER_URLS.size() + " Completed");
		
		
	}

}

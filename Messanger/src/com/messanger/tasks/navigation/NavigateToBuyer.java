package com.messanger.tasks.navigation;

import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.messanger.tasks.Task;
import com.messanger.variables.Constants;
import com.messanger.variables.Helper;
import com.messanger.variables.Variables;

public class NavigateToBuyer extends Task {

	@Override
	public boolean activate() {
		return isNextPageGone() && Variables.BUYERS_SCRAPED >= Variables.TOTAL_BUYERS && Variables.TOTAL_BUYERS != 0
				|| Constants.DRIVER.getPageSource().contains("Your mail has been sent")
						&& Variables.MESSAGES_DONE != Variables.BUYER_URLS.size();
	}

	@Override
	public void execute() {
		if (Variables.DUPLICATES_PRESENT) {
			Variables.BUYER_URLS.addAll(Variables.UNDUPLICATE_URLS);
			Variables.DUPLICATES_PRESENT = false;
			System.out.println(Variables.BUYER_URLS.size() + " Buyers to Message");
		}

		if (Variables.BUYER_URLS.size() == Variables.MESSAGES_DONE) {
			Constants.DRIVER.close();
			Constants.DRIVER.quit();
			JOptionPane.showMessageDialog(null, "All Messages Sent");
			System.exit(0);

		} else {
			Constants.DRIVER.get(Variables.BUYER_URLS.get(Variables.MESSAGES_DONE));
			Helper.waitByID("commMgrCompositionSubject");

			Variables.TOTAL_BUYERS = 0;
		}
	}

	private boolean isNextPageGone() {
		if (Constants.DRIVER.findElements(By.className("currentpagination")).size() >= 1) {
			int nextPage = Integer.valueOf(Constants.DRIVER.findElement(By.className("currentpagination")).getText()) + 1;

			if (Constants.DRIVER.findElements(By.partialLinkText(String.valueOf(nextPage))).size() >= 1) {
				List<WebElement> nextPageButton = Constants.DRIVER.findElements(By.partialLinkText(String.valueOf(nextPage)));
				for (WebElement next : nextPageButton) {
					if (!next.getText().contains(" ") && !next.getText().contains("-")) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

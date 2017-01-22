package com.messanger.tasks.navigation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.messanger.tasks.Task;
import com.messanger.variables.Constants;
import com.messanger.variables.Variables;

public class ScrapeBuyers extends Task {

	@Override
	public boolean activate() {
		return Constants.DRIVER.findElements(By.cssSelector("a[id*='_buyerName']")).size() >= 1
				&& Variables.BUYERS_SCRAPED < Variables.TOTAL_BUYERS && isErrorPresent();
	}


	@Override
	public void execute() {
		for (WebElement buyerURL : Constants.DRIVER.findElements(By.cssSelector("a[id*='_buyerName']"))) {
			String url = buyerURL.getAttribute("href");
			
			if (url.contains("/contact/")) {
				Variables.UNDUPLICATE_URLS.add(url);
				Variables.BUYERS_SCRAPED++;
			}
			
		}
		
		if (Constants.DRIVER.findElements(By.className("currentpagination")).size() != 0) {
			// Move to next page
			int nextPage = Integer.valueOf(Constants.DRIVER.findElement(By.className("currentpagination")).getText())
					+ 1;

			if (Constants.DRIVER.findElements(By.partialLinkText(String.valueOf(nextPage))).size() >= 1) {
				List<WebElement> nextPageButton = Constants.DRIVER
						.findElements(By.partialLinkText(String.valueOf(nextPage)));
				for (WebElement next : nextPageButton) {
					if (!next.getText().contains(" ") && !next.getText().contains("-")) {
						next.click();
						break;
					}
				}
			}
		}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	private boolean isErrorPresent() {
		return !Constants.DRIVER.getPageSource().contains("(phone for mobile accounts)")
				&& !Constants.DRIVER.getCurrentUrl().contains("gp/help/contact/contact");
	}
}


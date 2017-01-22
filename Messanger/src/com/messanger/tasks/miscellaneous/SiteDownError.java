package com.messanger.tasks.miscellaneous;

import com.messanger.tasks.Task;
import com.messanger.variables.Constants;

public class SiteDownError extends Task {

	@Override
	public boolean activate() {
		return Constants.DRIVER.getCurrentUrl().contains("is currently unavailable");
	}

	@Override
	public void execute() {
		Constants.DRIVER.navigate().refresh();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

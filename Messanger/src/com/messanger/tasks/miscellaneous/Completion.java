package com.messanger.tasks.miscellaneous;

import javax.swing.JOptionPane;

import com.messanger.tasks.Task;
import com.messanger.variables.Constants;
import com.messanger.variables.Variables;

public class Completion extends Task {

	@Override
	public boolean activate() {
		return Variables.MESSAGES_DONE == Variables.BUYER_URLS.size() 
				&& Variables.MESSAGES_DONE != 0;
	}

	@Override
	public void execute() {
		Constants.DRIVER.close();
		Constants.DRIVER.quit();
		JOptionPane.showMessageDialog(null, "All messages sent");
		System.exit(0);
		
	}

}

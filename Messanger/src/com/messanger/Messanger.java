package com.messanger;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.messanger.tasks.Task;
import com.messanger.tasks.miscellaneous.Completion;
import com.messanger.tasks.miscellaneous.SignIn;
import com.messanger.tasks.miscellaneous.SiteDownError;
import com.messanger.tasks.navigation.NavigateToBuyer;
import com.messanger.tasks.navigation.ScrapeBuyers;
import com.messanger.tasks.sending.SendMessage;
import com.messanger.ui.frame.MessangerUI;

public class Messanger {	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MessangerUI gui = new MessangerUI();
		gui.setVisible(true);
	}
	
	
	
	public void start() {
		ArrayList<Task> taskList = new ArrayList<Task>();
		taskList.addAll(Arrays.asList(new SignIn(), new SiteDownError(), new NavigateToBuyer(), new ScrapeBuyers(), 
				new SendMessage(), new Completion()));
		
		
		while (true) {
			for (Task task : taskList) {
				if (task.activate()) {
					task.execute();
				}
			}
		}
	}
}

package com.messanger.ui.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.messanger.Messanger;
import com.messanger.ui.components.DatePanel;
import com.messanger.ui.components.MessagePanel;
import com.messanger.variables.Constants;
import com.messanger.variables.Variables;

@SuppressWarnings("serial")
public class MessangerUI extends JFrame implements ActionListener {

	//JPanels
	private DatePanel datePanel;
	private MessagePanel messagePanel;
	
	//JButton
	private JButton startButton;
	
	public MessangerUI() {
		super("The Messenger");
		frameDetails();
		componentDetails();
		addComponents();
	}

	private void addComponents() {
		add(datePanel, BorderLayout.NORTH);
		add(messagePanel, BorderLayout.CENTER);
		add(startButton, BorderLayout.SOUTH);
	}

	private void componentDetails() {
		datePanel = new DatePanel();
		messagePanel = new MessagePanel();
		
		startButton = new JButton("Start");
		startButton.addActionListener(this);
	}

	private void frameDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(426, 309);
		setResizable(false);
		setLocationRelativeTo(null);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src.equals(startButton)) {
			setVisible(false);
			dispose();
			
			Variables.ORDERS_URL += datePanel.getStart().getMonth() + 1 + "%2F" + datePanel.getStart().getDay() + "%2F" + datePanel.getStart().getYear() + "&exactDateEnd=" + (datePanel.getEnd().getMonth() + 1) + "%2F" + datePanel.getEnd().getDay() + "%2F" + datePanel.getEnd().getYear();
			Constants.DRIVER.get(Variables.ORDERS_URL);
			Constants.WAIT.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
			
			Messanger messangerMain = new Messanger();
			messangerMain.start();
		}
	}
}

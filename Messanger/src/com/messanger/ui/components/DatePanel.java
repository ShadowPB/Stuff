package com.messanger.ui.components;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JPanel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

@SuppressWarnings("serial")
public class DatePanel extends JPanel {

	private JDatePanelImpl startDate;
	private UtilDateModel startModel;

	private JDatePanelImpl endDate;
	private UtilDateModel endModel;
	
	public DatePanel() {
		panelDetails();
		componentDetails();
		addComponents();
	}

	private void addComponents() {
		add(startDate, BorderLayout.WEST);
		add(endDate, BorderLayout.EAST);
		
	}

	private void componentDetails() {
		startModel = new UtilDateModel();
		endModel = new UtilDateModel();

		Properties properties = new Properties();
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
	
		startDate = new JDatePanelImpl(startModel, properties);
		endDate = new JDatePanelImpl(endModel, properties);
	}

	private void panelDetails() {
		setLayout(new BorderLayout());
	}
	
	public UtilDateModel getStart() {
		return startModel;
	}
	
	public UtilDateModel getEnd() {
		return endModel;
	}
}

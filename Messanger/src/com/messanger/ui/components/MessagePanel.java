package com.messanger.ui.components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.messanger.variables.FileInformation;
import com.messanger.variables.Variables;

@SuppressWarnings("serial")
public class MessagePanel extends JPanel implements ActionListener {

	private JLabel messageLabel;
	private JTextField messageField;
	private JButton browse;
	
	private JLabel subjectLabel;
	private JComboBox<String> subjectBox;
	
	public MessagePanel() {
		panelDetails();
		componentDetails();
		addComponents();
	}

	private void addComponents() {
		add(messageLabel);
		add(messageField);
		add(browse);
		add(subjectLabel);
		add(subjectBox);
		
	}

	private void componentDetails() {
		Font font = new Font("Times New Roman", 20, 20);
		messageLabel = new JLabel("Message");
		messageLabel.setFont(font);
		subjectLabel = new JLabel("Subject");
		subjectLabel.setFont(font);
		
		messageField = new JTextField();
		messageField.setEditable(false);
		messageField.setPreferredSize(new Dimension(210, 20));
		
		browse = new JButton("Browse");
		browse.addActionListener(this);
		
		subjectBox = new JComboBox<String>();
		subjectBox.addItem("Feedback Request");
		subjectBox.addItem("Additional Information");
		subjectBox.addActionListener(this);
		
	}

	private void panelDetails() {
		setLayout(new FlowLayout());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(browse)) {
			FileInformation fileInfo = new FileInformation();
			Variables.MESSAGE = fileInfo.getData();
			
			messageField.setText(fileInfo.getFile().getAbsolutePath());
			
		} else if(src.equals(subjectBox)) {
			Variables.SUBJECT_TEXT = (String) subjectBox.getSelectedItem();
			
			System.out.println(Variables.SUBJECT_TEXT);
		}
	}
}

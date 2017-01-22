package com.messanger.variables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileInformation {

	private File file;

	public FileInformation() {
		file = runFileSelector();
	}

	private File runFileSelector() {
		JFileChooser chooser = new JFileChooser();
		int chosen = chooser.showOpenDialog(null);

		if (chosen == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		}

		return null;
	}

	// Reads each line in a text file
	public String getData() {
		return readFileList();
	}
	

	private String readFileList() {
		String message = "";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String element = null;
			while ((element = reader.readLine()) != null) {
				if(element.equals("")) {
					message += "\n";
				}
				message += element + " ";
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return message;
	}

	public File getFile() {
		return file;
	}
}

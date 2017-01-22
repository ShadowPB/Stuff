package com.messanger.variables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Constants {

	public static final WebDriver DRIVER = new ChromeDriver();
	public static final WebDriverWait WAIT = new WebDriverWait(DRIVER, 20);
	
	public static final String TOTAL_BUYER_URLS_ELEMENT = "//*[@id='myo-table']/table/tbody/tr[1]/td/table/tbody/tr/td[1]/strong[2]";
}

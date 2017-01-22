package com.messanger.variables;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Variables {

	public static String ORDERS_URL = "https://sellercentral.amazon.com/gp/orders-v2/list/ref=ag_myo_apsearch_myosearch?searchType=OrderID&searchKeyword=&shippingServiceFilter=All&byDate=orderDate&preSelectedRange=3&searchDateOption=exactDates&exactDateBegin=";
	
	public static String SUBJECT_TEXT = "Feedback Request";
	public static String MESSAGE = "";
	
	public static int BUYERS_SCRAPED = 0;
	public static int TOTAL_BUYERS = 0;
	public static ArrayList<String> BUYER_URLS = new ArrayList<String>();
	public static Set<String> UNDUPLICATE_URLS = new LinkedHashSet<String>();
	public static int MESSAGES_DONE = 0;
	
	public static boolean DUPLICATES_PRESENT = true;

}

package com.selenium;

import com.thoughtworks.selenium.DefaultSelenium;

public class ExtSelenium extends DefaultSelenium {
	  
	 public ExtSelenium(String serverHost, int serverPort, String browserStartCommand, String browserURL) {
	        super(new  ExtHttpCommandProcessor(serverHost, serverPort, browserStartCommand, browserURL));
	       
	    }
}

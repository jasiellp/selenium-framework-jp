package com.selenium;

 
import com.player.Player;
import com.thoughtworks.selenium.HttpCommandProcessor;

public class ExtHttpCommandProcessor extends HttpCommandProcessor {

	 
	
	 public ExtHttpCommandProcessor(String serverHost, int serverPort, String browserStartCommand, String browserURL) {
		super(serverHost, serverPort, browserStartCommand, browserURL);
		
	}
	 
    public static  String comando = null;
	 
	public String doCommand(String commandName, String[] args) {
		//comando = null;
		StringBuffer sb = new StringBuffer();
		sb.append(" | " + commandName + " | ");

		if (args != null) {
			for (String arg : args) {
				sb.append(arg + " | ");
			}

			if (args.length < 2) {
				sb.append(" | ");
			}
		} else {
			sb.append(" | | ");
		} 
	    
		
		
		System.out.println(commandName+" "+sb.toString());
		comando=commandName+" "+sb.toString();
		
		
		return super.doCommand(commandName, args);

	}

}
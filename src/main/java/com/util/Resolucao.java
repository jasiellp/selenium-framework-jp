package com.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Resolucao {
	  public static void main(String[] args) {
	    
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    System.out.println("Screen width = " + d.width);
	    System.out.println("Screen height = " + d.height);

	  }
	}

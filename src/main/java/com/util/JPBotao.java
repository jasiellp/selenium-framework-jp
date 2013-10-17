package com.util;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JPBotao extends JButton{

	private static final long serialVersionUID = 7082370490844232422L;
	
	public JPBotao(Color cor, String caminho){
		this.setIcon(new ImageIcon(caminho));
		this.setBackground(cor);
	} 
	  
}

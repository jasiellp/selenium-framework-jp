package com.util;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


class croc{
	
	public static void main(String[] args) throws AWTException, IOException {
	
		
		int x = 0;
		int y = 0;
		int Width = 0;
		int Height = 0;
		int corte = 0;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//Definindo a dimensão que quer capturar
		//pode ser definido o tamanho que desejar
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle screenRect = new Rectangle(screenSize);
		// criando o print screen
		Robot robot = new Robot();
		BufferedImage screenCapturedImage = robot.createScreenCapture(screenRect);

		x=screenCapturedImage.getMinX();
		y=screenCapturedImage.getMinY();
		Width=screenCapturedImage.getTileWidth();
		Height=screenCapturedImage.getTileHeight();
		
		System.out.println("Height -->> "+Height);
		corte = Height/18;
		ImageIO.write(screenCapturedImage.getSubimage(x, y,Width , Height-corte ), "png", new File("C:\\a\\jasiel.png"));
		
		 
	}
	
}

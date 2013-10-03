package com.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.thoughtworks.selenium.Selenium;

public class ImagemUtil {

	
	private Toolkit toolkit; 
	private Dimension screenDim; 
	private BufferedImage bImageFromConvert = null;
	private InputStream in;	
	
	
	public Image jPrintSCrean(Selenium s) throws Exception {

		this.toolkit = Toolkit.getDefaultToolkit();
		this.screenDim = toolkit.getScreenSize();
	
		return decodeAndWriteScreenshot(s.captureScreenshotToString()).getSubimage(0, 22,screenDim.width, screenDim.height - 60);
	}

	public  BufferedImage decodeAndWriteScreenshot(String screen) {

		byte[] decodedBytes = org.apache.commons.codec.binary.Base64.decodeBase64(screen);

		try {

			this.in = new ByteArrayInputStream(decodedBytes);
			this.bImageFromConvert = ImageIO.read(in);

		} catch (Exception E) {

			return bImageFromConvert;
		}
		return bImageFromConvert;
	}
}

package com.selenium;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.Selenium;
import com.util.ImagemUtil;
import com.util.SeleniumUtil;

public class JpSelenium  extends TestCase{
	 
	private Selenium selenium;
	@SuppressWarnings("unused")
	private SeleniumUtil sUtil;
	@SuppressWarnings("unused")
	private ImagemUtil img; 
	private String comando;
	
	@Before
 	public void setUp(String link, String timeout) throws Exception 
 	{
		//192.168.0.10
		//"*googlechrome C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe
		//"*googlechrome C:\\Users\\Jasiellp\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"
		//"192.168.1.146"
		//"*googlechrome C:\\Arquivos de programas\\Google\\Chrome\\Application\\chrome.exe"
		
		String navegador = "*googlechrome C:\\Arquivos de programas\\Google\\Chrome\\Application\\chrome.exe";
		this.selenium = new ExtSelenium("192.168.1.146", 4444, navegador , link);
		this.selenium.start();
		this.selenium.windowMaximize();
		this.selenium.open(link);
		//Thread.sleep(Integer.parseInt(timeout));
		this.selenium.waitForPageToLoad(timeout);
		System.out.println("Prompt -->> "+this.selenium.isPromptPresent());
		this.sUtil = new SeleniumUtil(); 
		this.img = new ImagemUtil();
	}

	public Selenium getSelenium()
	{
		return this.selenium;
	} 
	
	
	@Test
	public void testClique(String caminho) throws Exception 
	{
		this.selenium.click(caminho);
	}

	@Test
	public void testDigite(String caminho,String valor) throws Exception 
	{
		this.selenium.type(caminho , valor);
	}
	 
	@Test
	public String testCapture() throws Exception 
	{
		return this.selenium.captureScreenshotToString();
	}
	 
	public void setComando(String comando)
	{
		 this.comando = comando;
	}
	
	public String getComando()
	{ 
		return comando;
	} 
	
	@Test
	public String testElemento(ArrayList<Object> elementos) throws Exception 
	{
		return this.elementoPresente(this.selenium, elementos);
	}
	
	
	@Test
	public String testTexto(ArrayList<Object> elementos) throws Exception 
	{
		return this.textoPresente(this.selenium, elementos);
	}
	
	public String textoPresente(Selenium selenium, ArrayList<Object> elementos) {
		String elemento = "OK";

		for (int i = 1; i < elementos.size(); i++) 
		{
			if (!selenium.isTextPresent(elementos.get(i).toString()))
			{
					elemento = elementos.get(i).toString();
			}
			
		}
		return elemento;
	}
	
	
	public String elementoPresente(Selenium selenium, ArrayList<Object> elementos) {
	
		String elemento = null;

		for (int i = 0; i < elementos.size(); i++) 
		{
			if (selenium.isElementPresent(elementos.get(i).toString())) 
			{
				elemento = elementos.get(i).toString();
				this.setComando("OK");
				break;
			}
			else
			{
				this.setComando("Erro");
				elemento = "Erro";
			}
		} 
		return elemento;
	}
	
	@After
	public void tearDown() 
	{ 
		this.selenium.close();
		this.selenium.stop();
	}
 
}
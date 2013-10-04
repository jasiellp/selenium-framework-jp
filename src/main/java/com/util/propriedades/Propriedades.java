package com.util.propriedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public class Propriedades implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String PATH = "properties\\";
	private final String TYPE = ".properties";
	private Properties prop = null;
	private String arquivo;

	public Propriedades(String arquivo) {
		this.arquivo = arquivo;
	}

	public String leitor(String key) {

		try {

			if (this.prop == null)
				this.prop = new Properties();

			this.prop.load(new FileInputStream(this.PATH + this.arquivo
					+ this.TYPE));

			return this.prop.getProperty(key);

		} catch (FileNotFoundException f) {

			f.printStackTrace();

		} catch (IOException i) {

			i.printStackTrace();

		}

		return null;

	}
}

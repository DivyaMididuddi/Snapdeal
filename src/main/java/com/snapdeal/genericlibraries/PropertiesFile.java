package com.snapdeal.genericlibraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {


		public Properties getData() throws IOException {

			FileInputStream fis = new FileInputStream("src/test/resources/data.properties");

			Properties properties = new Properties();

			try {
				properties.load(fis);
			} catch (Exception e) {
				System.out.println("Exception occured is: " + e);
			}
			return properties;
		}

		

	}



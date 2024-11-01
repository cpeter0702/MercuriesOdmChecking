package com.firsttech.insurance.odm_checking.service;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConfigManager {
	private Properties props;
	private static ConfigManager instance = null;

	private ConfigManager(String filePath) {
		props = new Properties();
		try (InputStream input = new FileInputStream(filePath)) {
			props.load(input);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	public static ConfigManager getInstance(String filePath) {
		if (instance == null) {
			instance = new ConfigManager(filePath);
		}
		return instance;
	}

	public String getProperty(String key) {
		return props.getProperty(key);
	}
}

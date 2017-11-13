package com.dev3l.credit_payment.ws.properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesSingleton {
	private static final Logger logger = LogManager.getLogger();
	private static final String STRIPE_CONFIGURATION_PROPERTIES_FILE = "credit_payment_configuration.properties";

	private static PropertiesConfiguration propertiesConfiguration = null;
	private static PropertiesBean propertiesBean = null;
	private static long fileModified = 0l;

	private PropertiesSingleton() {
	}

	public static final PropertiesBean getPropertiesBeanInstance() {
		if ((propertiesConfiguration == null) ||
				(propertiesConfiguration.getFile() != null && (fileModified != propertiesConfiguration.getFile().lastModified()))) {
			try {
				propertiesConfiguration = new PropertiesConfiguration(STRIPE_CONFIGURATION_PROPERTIES_FILE);
			} catch (final ConfigurationException e) {
				logger.error(e.getMessage(), e);
				return null;
			}

			propertiesConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());
			fileModified = propertiesConfiguration.getFile() != null ? propertiesConfiguration.getFile().lastModified() : 0;
			propertiesBean = PropertiesFactory.createPropertiesBeanFromPropertiesFile(propertiesConfiguration);
		}

		return propertiesBean;
	}
}

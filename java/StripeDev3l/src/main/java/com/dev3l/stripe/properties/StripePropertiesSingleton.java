package com.dev3l.stripe.properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StripePropertiesSingleton {
	private static final Logger logger = LogManager.getLogger();
	private static final String STRIPE_CONFIGURATION_PROPERTIES_FILE = "stripe_configuration.properties";

	private static PropertiesConfiguration propertiesConfiguration = null;
	private static StripePropertiesBean stripePropertiesBean = null;
	private static long fileModified = 0l;

	private StripePropertiesSingleton() {
	}

	public static final StripePropertiesBean getStripePropertiesBeanInstance() {
		if ((propertiesConfiguration == null) || (fileModified != propertiesConfiguration.getFile().lastModified())) {
			try {
				propertiesConfiguration = new PropertiesConfiguration(STRIPE_CONFIGURATION_PROPERTIES_FILE);
			} catch (final ConfigurationException e) {
				logger.error(e.getMessage(), e);
				return null;
			}

			propertiesConfiguration.setReloadingStrategy(new FileChangedReloadingStrategy());
			fileModified = propertiesConfiguration.getFile().lastModified();
			stripePropertiesBean = StripePropertiesFactory.createStripePropertiesBeanFromPropertiesFile(propertiesConfiguration);
		}

		return stripePropertiesBean;
	}
}

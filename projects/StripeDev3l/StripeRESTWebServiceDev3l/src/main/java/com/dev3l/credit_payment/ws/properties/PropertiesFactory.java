package com.dev3l.credit_payment.ws.properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertiesFactory {
	public static PropertiesBean createPropertiesBeanFromPropertiesFile(final PropertiesConfiguration propertiesConfiguration) {
		final PropertiesBean propertiesBean = new PropertiesBean();

		if (propertiesConfiguration == null) {
			return propertiesBean;
		}

		setPropertiesOnPropertiesBean(propertiesConfiguration, propertiesBean);
		setPropertiesMapOnPropertiesBean(propertiesConfiguration, propertiesBean);

		return propertiesBean;
	}

	/**
	 * @param propertiesConfiguration
	 * @param propertiesBean
	 */
	private static final void setPropertiesOnPropertiesBean(final PropertiesConfiguration propertiesConfiguration, final PropertiesBean propertiesBean) {
		propertiesBean.setStripeApiKey(propertiesConfiguration.getString(PropertiesEnum.STRIPE_API_KEY.getLiteral()));
	}

	/**
	 * @param propertiesConfiguration
	 * @param propertiesBean
	 */
	private static final void setPropertiesMapOnPropertiesBean(final PropertiesConfiguration propertiesConfiguration, final PropertiesBean propertiesBean) {
		final Iterator<String> propertiesKeys = propertiesConfiguration.getKeys();
		final Map<String, String> propertiesMap = new HashMap<String, String>();

		while (propertiesKeys.hasNext()) {
			final String key = propertiesKeys.next();
			propertiesMap.put(key, propertiesConfiguration.getString(key));
		}

		propertiesBean.setPropertiesMap(propertiesMap);
	}
}

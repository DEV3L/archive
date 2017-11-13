package com.dev3l.stripe.properties;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;

public class StripePropertiesFactory {
	public static StripePropertiesBean createStripePropertiesBeanFromPropertiesFile(final PropertiesConfiguration propertiesConfiguration) {
		final StripePropertiesBean stripePropertiesBean = new StripePropertiesBean();

		if (propertiesConfiguration == null) {
			return stripePropertiesBean;
		}

		setPropertiesOnPropertiesBean(propertiesConfiguration, stripePropertiesBean);
		setPropertiesMapOnPropertiesBean(propertiesConfiguration, stripePropertiesBean);

		return stripePropertiesBean;
	}

	/**
	 * @param propertiesConfiguration
	 * @param stripePropertiesBean
	 */
	private static final void setPropertiesOnPropertiesBean(final PropertiesConfiguration propertiesConfiguration, final StripePropertiesBean stripePropertiesBean) {
		stripePropertiesBean.setStripeApiKey(propertiesConfiguration.getString(StripePropertiesEnum.STRIPE_API_KEY.getLiteral()));
	}

	/**
	 * @param propertiesConfiguration
	 * @param stripePropertiesBean
	 */
	private static final void setPropertiesMapOnPropertiesBean(final PropertiesConfiguration propertiesConfiguration, final StripePropertiesBean stripePropertiesBean) {
		final Iterator<String> propertiesKeys = propertiesConfiguration.getKeys();
		final Map<String, String> propertiesMap = new HashMap<String, String>();

		while (propertiesKeys.hasNext()) {
			final String key = propertiesKeys.next();
			propertiesMap.put(key, propertiesConfiguration.getString(key));
		}

		stripePropertiesBean.setPropertiesMap(propertiesMap);
	}
}

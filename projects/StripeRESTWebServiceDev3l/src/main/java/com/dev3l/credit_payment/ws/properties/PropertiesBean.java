package com.dev3l.credit_payment.ws.properties;

import java.util.Map;

public class PropertiesBean {
	private String stripeApiKey;
	private Map<String, String> propertiesMap;

	public PropertiesBean() {
	}

	/**
	 * @return the stripeApiKey
	 */
	public final String getStripeApiKey() {
		return stripeApiKey;
	}

	/**
	 * @param stripeApiKey the stripeApiKey to set
	 */
	public final void setStripeApiKey(String stripeApiKey) {
		this.stripeApiKey = stripeApiKey;
	}

	/**
	 * @return the propertiesMap
	 */
	public final Map<String, String> getPropertiesMap() {
		return propertiesMap;
	}

	/**
	 * @param propertiesMap the propertiesMap to set
	 */
	public final void setPropertiesMap(Map<String, String> propertiesMap) {
		this.propertiesMap = propertiesMap;
	}
}
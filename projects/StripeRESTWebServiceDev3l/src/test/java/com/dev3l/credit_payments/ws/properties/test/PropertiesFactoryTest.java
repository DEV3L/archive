package com.dev3l.credit_payments.ws.properties.test;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.Test;

import com.dev3l.credit_payment.ws.properties.PropertiesBean;
import com.dev3l.credit_payment.ws.properties.PropertiesEnum;
import com.dev3l.credit_payment.ws.properties.PropertiesFactory;

public class PropertiesFactoryTest {
	private static final String stripeApiKey = "not_null_1";

	@Test
	public void createCryptoPropertiesBeanFromNullPropertiesFile() {
		final PropertiesBean propertiesBean = PropertiesFactory.createPropertiesBeanFromPropertiesFile(null);
		Assert.assertNotNull(propertiesBean);
		Assert.assertNull(propertiesBean.getStripeApiKey());
		Assert.assertNull(propertiesBean.getPropertiesMap());
	}

	@Test
	public void createCryptoPropertiesBeanFromPropertiesFile() {
		final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		propertiesConfiguration.addProperty("test_property", "test_value");
		PropertiesBean cryptoPropertiesBean = PropertiesFactory.createPropertiesBeanFromPropertiesFile(propertiesConfiguration);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertNull(cryptoPropertiesBean.getStripeApiKey());
		Assert.assertNotNull(cryptoPropertiesBean.getPropertiesMap());

		propertiesConfiguration.addProperty(PropertiesEnum.STRIPE_API_KEY.getLiteral(), stripeApiKey);

		cryptoPropertiesBean = PropertiesFactory.createPropertiesBeanFromPropertiesFile(propertiesConfiguration);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertEquals(cryptoPropertiesBean.getStripeApiKey(), stripeApiKey);
		Assert.assertNotNull(cryptoPropertiesBean.getPropertiesMap());
	}
}

package com.dev3l.stripe.properties.test;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.junit.Assert;
import org.junit.Test;

import com.dev3l.stripe.properties.StripePropertiesBean;
import com.dev3l.stripe.properties.StripePropertiesEnum;
import com.dev3l.stripe.properties.StripePropertiesFactory;

public class StripePropertiesFactoryTest {
	private static final String stripeApiKey = "not_null_1";

	@Test
	public void createCryptoPropertiesBeanFromNullPropertiesFile() {
		final StripePropertiesBean stripePropertiesBean = StripePropertiesFactory.createStripePropertiesBeanFromPropertiesFile(null);
		Assert.assertNotNull(stripePropertiesBean);
		Assert.assertNull(stripePropertiesBean.getStripeApiKey());
		Assert.assertNull(stripePropertiesBean.getPropertiesMap());
	}

	@Test
	public void createCryptoPropertiesBeanFromPropertiesFile() {
		final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
		propertiesConfiguration.addProperty("test_property", "test_value");
		StripePropertiesBean cryptoPropertiesBean = StripePropertiesFactory.createStripePropertiesBeanFromPropertiesFile(propertiesConfiguration);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertNull(cryptoPropertiesBean.getStripeApiKey());
		Assert.assertNotNull(cryptoPropertiesBean.getPropertiesMap());

		propertiesConfiguration.addProperty(StripePropertiesEnum.STRIPE_API_KEY.getLiteral(), stripeApiKey);

		cryptoPropertiesBean = StripePropertiesFactory.createStripePropertiesBeanFromPropertiesFile(propertiesConfiguration);

		Assert.assertNotNull(cryptoPropertiesBean);
		Assert.assertEquals(cryptoPropertiesBean.getStripeApiKey(), stripeApiKey);
		Assert.assertNotNull(cryptoPropertiesBean.getPropertiesMap());
	}
}

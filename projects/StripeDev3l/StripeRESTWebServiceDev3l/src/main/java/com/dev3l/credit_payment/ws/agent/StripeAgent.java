package com.dev3l.credit_payment.ws.agent;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dev3l.credit_payment.ws.bean.StripeBean;
import com.dev3l.credit_payment.ws.properties.PropertiesSingleton;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@Singleton
public class StripeAgent {
	private static final Logger logger = LogManager.getLogger();

	public Charge charge(final StripeBean stripeBean) {
		if (stripeBean == null) {
			logger.warn("Cannot charge a null stripeBean");
			return null;
		}

		Stripe.apiKey = PropertiesSingleton.getPropertiesBeanInstance().getStripeApiKey(); 
				
		final Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.put("number", stripeBean.getNumber());
		cardParams.put("exp_month", stripeBean.getExpMonth());
		cardParams.put("exp_year", stripeBean.getExpYear());
		cardParams.put("cvc", stripeBean.getCvc());
		cardParams.put("name", stripeBean.getName());

		final Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", stripeBean.getAmount());
		chargeParams.put("currency", stripeBean.getCurrency());
		chargeParams.put("card", cardParams);

		Charge charge;

		try {
			charge = Charge.create(chargeParams);
		} catch (final CardException e) {
			// card declined
			logger.error(e.getCode() + "/" + e.getMessage(), e);
			return new Charge();
		} catch (AuthenticationException | InvalidRequestException | APIConnectionException | APIException e) {
			logger.error(e.getMessage(), e);
			return null;
		}

		logger.info(charge);

		return charge;
	}
}

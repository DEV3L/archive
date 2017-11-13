package com.dev3l.credit_payments.ws.test;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.dev3l.credit_payment.ws.agent.StripeAgent;
import com.dev3l.credit_payment.ws.bean.StripeBean;

public class StripeAgentTest {
	@Test
	public void testValidCharge() {
		// could be a better test
		StripeBean stripeBean = new StripeBean();
		stripeBean.setNumber("4242424242424242");
		Calendar calendar = Calendar.getInstance();
		stripeBean.setExpMonth(Integer.toString(calendar.get(Calendar.MONTH) + 1));
		stripeBean.setExpYear(Integer.toString(calendar.get(Calendar.YEAR)));
		stripeBean.setCvc("123");
		stripeBean.setName("Test Dev3l");
		stripeBean.setAmount("100"); // $1.00
		stripeBean.setCurrency("usd");
		
		StripeAgent stripeAgent = new StripeAgent();
		stripeAgent.charge(stripeBean);
		
		Assert.assertNotEquals(stripeAgent.charge(stripeBean), null);
	}
}

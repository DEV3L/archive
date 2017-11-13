package com.dev3l.credit_payment.ws.properties;

public enum PropertiesEnum {
	//@formatter:off
	STRIPE_API_KEY("stripe.dev3l.secret_api_key");
	//@formatter:on

	private final java.lang.String literal;

	private PropertiesEnum(final String literal) {
		this.literal = literal;
	}

	public final String getLiteral() {
		return literal;
	}
}

package com.dev3l.stripe.properties;

public enum StripePropertiesEnum {
	//@formatter:off
	STRIPE_API_KEY("stripe.dev3l.secret_api_key");
	//@formatter:on

	private final java.lang.String literal;

	private StripePropertiesEnum(final String literal) {
		this.literal = literal;
	}

	public final String getLiteral() {
		return literal;
	}
}

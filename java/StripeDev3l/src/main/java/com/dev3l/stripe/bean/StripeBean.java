package com.dev3l.stripe.bean;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@XmlRootElement
public class StripeBean {
	private Long id;
	private String number;
	private String expMonth;
	private String expYear;
	private String cvc;
	private String name;
	private String currency;
	private String amount;

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @return the number
	 */
	public final String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public final void setNumber(final String number) {
		this.number = number;
	}

	/**
	 * @return the expMonth
	 */
	public final String getExpMonth() {
		return expMonth;
	}

	/**
	 * @param expMonth the expMonth to set
	 */
	public final void setExpMonth(final String expMonth) {
		this.expMonth = expMonth;
	}

	/**
	 * @return the expYear
	 */
	public final String getExpYear() {
		return expYear;
	}

	/**
	 * @param expYear the expYear to set
	 */
	public final void setExpYear(final String expYear) {
		this.expYear = expYear;
	}

	/**
	 * @return the cvc
	 */
	public final String getCvc() {
		return cvc;
	}

	/**
	 * @param cvc the cvc to set
	 */
	public final void setCvc(final String cvc) {
		this.cvc = cvc;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the currency
	 */
	public final String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public final void setCurrency(final String currency) {
		this.currency = currency;
	}

	/**
	 * @return the amount
	 */
	public final String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public final void setAmount(final String amount) {
		this.amount = amount;
	}
}
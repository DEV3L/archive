package com.dev3l.helwoho.data.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthenticationTokenEntity {
	private Long authenticationTokenId;
	private Long userId;
	private String token;
	private Date created;
	private Date expired;

	public AuthenticationTokenEntity(final Long authenticationTokenId, final Long userId, final String token, final Date created,
			final Date expired) {
		this.authenticationTokenId = authenticationTokenId;
		this.userId = userId;
		this.token = token;
		this.created = created;
		this.expired = expired;
	}

	/**
	 * @return the authenticationTokenId
	 */
	public final Long getAuthenticationTokenId() {
		return authenticationTokenId;
	}

	/**
	 * @param authenticationTokenId the authenticationTokenId to set
	 */
	public final void setAuthenticationTokenId(final Long authenticationTokenId) {
		this.authenticationTokenId = authenticationTokenId;
	}

	/**
	 * @return the userId
	 */
	public final Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public final void setUserId(final Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the token
	 */
	public final String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public final void setToken(final String token) {
		this.token = token;
	}

	/**
	 * @return the created
	 */
	public final Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public final void setCreated(final Date created) {
		this.created = created;
	}

	/**
	 * @return the expired
	 */
	public final Date getExpired() {
		return expired;
	}

	/**
	 * @param expired the expired to set
	 */
	public final void setExpired(final Date expired) {
		this.expired = expired;
	}

}

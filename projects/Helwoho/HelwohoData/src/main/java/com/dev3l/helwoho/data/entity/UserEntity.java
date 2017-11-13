package com.dev3l.helwoho.data.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserEntity {
	private Long userId;
	private String userName;
	private String email;
	private String status;
	private String password;
	private String salt;
	private Date created;

	public UserEntity(final Long userId, final String userName, final String email, final String status, final String password,
			final String salt, final Date created) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.status = status;
		this.password = password;
		this.salt = salt;
		this.created = created;
	}

	public UserEntity(final String userName, final String email, final String status, final String password) {
		this(null, userName, email, status, password, null, null);
	}

	/**
	 * @return the userId
	 */
	public final Long getUserId() {
		return userId;
	}

	/**
	 * @param id the userId to set
	 */
	public final void setUserId(final Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public final void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * @return the status
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(final String status) {
		this.status = status;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the salt
	 */
	public final String getSalt() {
		return salt;
	}

	/**
	 * @param salt the salt to set
	 */
	public final void setSalt(final String salt) {
		this.salt = salt;
	}

	/**
	 * @return the created
	 */
	public final Date getCreated() {
		return created;
	}

	/**
	 * @param created the createDate to set
	 */
	public final void setCreated(final Date created) {
		this.created = created;
	}
}

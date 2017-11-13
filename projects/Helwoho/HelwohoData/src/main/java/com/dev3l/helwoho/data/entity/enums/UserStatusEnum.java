package com.dev3l.helwoho.data.entity.enums;

public enum UserStatusEnum {
	ACTIVE("ACT"),
	INACTIVE("INA"),
	DELETED("DEL");

	private final String value;

	private UserStatusEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
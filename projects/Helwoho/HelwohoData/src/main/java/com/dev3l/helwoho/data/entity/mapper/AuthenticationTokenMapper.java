package com.dev3l.helwoho.data.entity.mapper;

import static generated.dev3l.jooq.tables.AuthenticationToken.AUTHENTICATION_TOKEN;

import org.jooq.Record;

import com.dev3l.helwoho.data.entity.AuthenticationTokenEntity;

public class AuthenticationTokenMapper {
	private AuthenticationTokenMapper() {
	}

	public static AuthenticationTokenEntity map(final Record record) {
		return new AuthenticationTokenEntity(record.getValue(AUTHENTICATION_TOKEN.AUTHENTICATION_TOKEN_ID),
				record.getValue(AUTHENTICATION_TOKEN.USER_ID), record.getValue(AUTHENTICATION_TOKEN.TOKEN),
				record.getValue(AUTHENTICATION_TOKEN.CREATED), record.getValue(AUTHENTICATION_TOKEN.EXPIRED));
	}
}

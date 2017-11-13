package com.dev3l.helwoho.data.entity.mapper;

import static generated.dev3l.jooq.tables.User.USER;

import org.jooq.Record;

import com.dev3l.helwoho.data.entity.UserEntity;

public class UserMapper {
	private UserMapper() {
	}

	public static UserEntity map(final Record record) {
		return new UserEntity(record.getValue(USER.USER_ID), record.getValue(USER.USER_NAME), record.getValue(USER.EMAIL),
				record.getValue(USER.STATUS), record.getValue(USER.PASSWORD), record.getValue(USER.SALT), record.getValue(USER.CREATED));
	}
}

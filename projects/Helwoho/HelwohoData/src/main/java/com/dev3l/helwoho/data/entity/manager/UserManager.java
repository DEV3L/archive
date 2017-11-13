package com.dev3l.helwoho.data.entity.manager;

import static generated.dev3l.jooq.tables.User.USER;
import generated.dev3l.jooq.tables.records.UserRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang3.EnumUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectJoinStep;

import com.dev3l.helwoho.data.entity.UserEntity;
import com.dev3l.helwoho.data.entity.enums.UserStatusEnum;
import com.dev3l.helwoho.data.entity.mapper.UserMapper;

@Singleton
public class UserManager extends AbstractManager {
	private static final Logger logger = LogManager.getLogger();

	private DSLContext dslContext = null;

	@Deprecated
	public UserManager() {
	}

	@Inject
	public UserManager(final DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	public UserEntity create(final UserEntity userEntity) {
		if (userEntity == null) {
			logger.warn("Cannot insert null user");
			return null;
		} else if (userEntity.getUserId() != null) {
			logger.warn("Cannot insert user with a set userId");
			return null;
		} else if (!isValidStatus(userEntity.getStatus())) {
			logger.warn("Invalid user status: " + userEntity.getStatus());
			return null;
		}

		final UserRecord userRecord = dslContext
				.insertInto(USER, USER.USER_NAME, USER.EMAIL, USER.STATUS, USER.PASSWORD, USER.SALT)
				.values(userEntity.getUserName(), userEntity.getEmail(), userEntity.getStatus(), userEntity.getPassword(),
						userEntity.getSalt()).returning().fetchOne();

		return UserMapper.map(userRecord);
	}

	public List<UserEntity> read(final Collection<Condition> conditions) {
		final SelectJoinStep<Record> selectJoinStep = dslContext.select().from(USER);

		if ((conditions != null) && !conditions.isEmpty()) {
			selectJoinStep.where(conditions);
		}

		final Result<Record> results = selectJoinStep.fetch();
		final List<UserEntity> users = new ArrayList<UserEntity>();

		for (final Record record : results) {
			users.add(UserMapper.map(record));
		}

		return users;
	}

	public List<UserEntity> read() {
		return read(null);
	}

	public UserEntity getByUserName(final String userName) {
		final List<UserEntity> users = read(createCollectionFromSingleCondition(USER.USER_NAME.equal(userName)));

		if (users.size() != 1) {
			logger.debug("User record not found for userName: " + userName);
			return null;
		}

		return users.get(0);
	}

	public UserEntity get(final Long userId) {
		final List<UserEntity> users = read(createCollectionFromSingleCondition(USER.USER_ID.equal(userId)));

		if (users.size() != 1) {
			logger.warn("User record not found for user id: " + userId);
			return null;
		}

		return users.get(0);
	}

	public Integer updateUserEmail(final UserEntity userEntity) {
		if (userEntity == null) {
			logger.warn("Can only update email on a valid user");
			return null;
		}

		return dslContext.update(USER).set(USER.EMAIL, userEntity.getEmail()).where(USER.USER_ID.equal(userEntity.getUserId())).execute();
	}

	public Integer updateUserStatus(final UserEntity userEntity) {
		if (userEntity == null) {
			logger.warn("Can only update status on a valid user");
			return null;
		} else if (!isValidStatus(userEntity.getStatus())) {
			logger.warn("Invalid user status: " + userEntity.getStatus());
			return null;
		}

		return dslContext.update(USER).set(USER.STATUS, userEntity.getStatus()).where(USER.USER_ID.equal(userEntity.getUserId())).execute();
	}

	public Integer updateUserPassword(final UserEntity userEntity) {
		if (userEntity == null) {
			logger.warn("Can only update status on a valid user");
			return null;
		}

		return dslContext.update(USER).set(USER.PASSWORD, userEntity.getPassword()).set(USER.SALT, userEntity.getSalt())
				.where(USER.USER_ID.equal(userEntity.getUserId())).execute();
	}

	public Integer delete(final Long id) {
		return dslContext.delete(USER).where(USER.USER_ID.equal(id)).execute();
	}

	private boolean isValidStatus(final String status) {
		final List<UserStatusEnum> userStatusEnums = EnumUtils.<UserStatusEnum> getEnumList(UserStatusEnum.class);

		for (final UserStatusEnum userStatusEnum : userStatusEnums) {
			if (userStatusEnum.getValue().equals(status)) {
				return true;
			}
		}

		return false;
	}
}

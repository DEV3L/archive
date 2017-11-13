package com.dev3l.helwoho.data.entity.manager;

import static generated.dev3l.jooq.tables.AuthenticationToken.AUTHENTICATION_TOKEN;
import generated.dev3l.jooq.tables.records.AuthenticationTokenRecord;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;

import com.dev3l.helwoho.data.entity.AuthenticationTokenEntity;
import com.dev3l.helwoho.data.entity.mapper.AuthenticationTokenMapper;

@Singleton
public class AuthenticationTokenManager extends AbstractManager {
	private static final Logger logger = LogManager.getLogger();
	public static final int TOKEN_VALID_TIME_IN_MINUTES = 30;
	private DSLContext dslContext = null;

	@Deprecated
	public AuthenticationTokenManager() {
	}

	@Inject
	public AuthenticationTokenManager(final DSLContext dslContext) {
		this.dslContext = dslContext;
	}

	public AuthenticationTokenEntity create(final Long userId) {
		if (userId == null) {
			logger.warn("Cannot insert authentication token without user id");
			return null;
		}

		final UUID token = UUID.randomUUID();
		final Date expired = DateUtils.addMinutes(new Date(), TOKEN_VALID_TIME_IN_MINUTES);

		final AuthenticationTokenRecord authenticationRecord = dslContext
				.insertInto(AUTHENTICATION_TOKEN, AUTHENTICATION_TOKEN.TOKEN, AUTHENTICATION_TOKEN.EXPIRED, AUTHENTICATION_TOKEN.USER_ID)
				.values(token.toString(), new Timestamp(expired.getTime()), userId).returning().fetchOne();

		return AuthenticationTokenMapper.map(authenticationRecord);
	}

	public AuthenticationTokenEntity getByToken(final String token) {
		final List<AuthenticationTokenEntity> authenticationTokens = read(createCollectionFromSingleCondition(AUTHENTICATION_TOKEN.TOKEN
				.equal(token)));

		if (authenticationTokens.size() <= 0) {
			logger.debug("Authentication token record not found for token: " + token);
			return null;
		}

		return authenticationTokens.get(0);
	}

	public AuthenticationTokenEntity get(final Long authenticationTokenId) {
		final List<AuthenticationTokenEntity> authenticationTokens = read(createCollectionFromSingleCondition(AUTHENTICATION_TOKEN.AUTHENTICATION_TOKEN_ID
				.equal(authenticationTokenId)));

		if (authenticationTokens.size() != 1) {
			logger.warn("Authentication token record not found for authentication token id: " + authenticationTokenId);
			return null;
		}

		return authenticationTokens.get(0);
	}

	public Integer touchToken(final Long authenticationTokenId) {
		final Timestamp touchTimestamp = new Timestamp(DateUtils.addMinutes(new Date(), TOKEN_VALID_TIME_IN_MINUTES).getTime());

		return dslContext.update(AUTHENTICATION_TOKEN).set(AUTHENTICATION_TOKEN.EXPIRED, touchTimestamp)
				.where(AUTHENTICATION_TOKEN.AUTHENTICATION_TOKEN_ID.equal(authenticationTokenId)).execute();
	}

	private List<AuthenticationTokenEntity> read(final Collection<Condition> conditions) {
		final Result<Record> results = dslContext.select().from(AUTHENTICATION_TOKEN).where(conditions)
				.orderBy(AUTHENTICATION_TOKEN.CREATED.desc()).fetch();
		final List<AuthenticationTokenEntity> authenticationTokens = new ArrayList<AuthenticationTokenEntity>();

		for (final Record record : results) {
			authenticationTokens.add(AuthenticationTokenMapper.map(record));
		}

		return authenticationTokens;
	}
}

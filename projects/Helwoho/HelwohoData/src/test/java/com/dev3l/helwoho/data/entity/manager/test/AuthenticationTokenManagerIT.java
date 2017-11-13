package com.dev3l.helwoho.data.entity.manager.test;

import java.sql.DriverManager;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dev3l.crypto.Pbkdf2Encrypter;
import com.dev3l.crypto.RandomSaltGenerator;
import com.dev3l.helwoho.data.entity.AuthenticationTokenEntity;
import com.dev3l.helwoho.data.entity.UserEntity;
import com.dev3l.helwoho.data.entity.enums.UserStatusEnum;
import com.dev3l.helwoho.data.entity.manager.AuthenticationTokenManager;
import com.dev3l.helwoho.data.entity.manager.UserManager;
import com.dev3l.helwoho.data.entity.manager.action.UserAction;

public class AuthenticationTokenManagerIT {
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306";

	private static final String TEST_USER_NAME = "it_test_name_test_create";
	private static final String TEST_EMAIL = "it_test_name_test_create@email.com";

	private UserManager userManager = null;
	private UserAction userAction = null;
	private AuthenticationTokenManager authenticationTokenManager = null;

	private UserEntity userEntity = null;

	@Before
	public void setup() throws Exception {
		final DSLContext dslContext = DSL.using(DriverManager.getConnection(URL, USER_NAME, PASSWORD), SQLDialect.MYSQL);
		userManager = new UserManager(dslContext);
		userAction = new UserAction(new Pbkdf2Encrypter(), new RandomSaltGenerator());
		authenticationTokenManager = new AuthenticationTokenManager(dslContext);

		cleanup();

		userEntity = new UserEntity(TEST_USER_NAME, TEST_EMAIL, UserStatusEnum.ACTIVE.getValue(), "super_secret");
		userAction.addSaltAndEncryptPasswordForUser(userEntity);
		userEntity = userManager.create(userEntity);
	}

	@After
	public void cleanup() {
		final UserEntity userEntity = userManager.getByUserName(TEST_USER_NAME);

		if (userEntity != null) {
			userManager.delete(userEntity.getUserId());
		}
	}

	@Test
	public void testCreateAuthenticationToken() throws InterruptedException {
		Assert.assertNull(authenticationTokenManager.create(null));
		AuthenticationTokenEntity authenticationTokenEntity = authenticationTokenManager.create(userEntity.getUserId());

		Assert.assertNotNull(authenticationTokenEntity);
		Assert.assertNotNull(authenticationTokenEntity.getToken());
		Assert.assertNotNull(authenticationTokenEntity.getAuthenticationTokenId());
		Assert.assertNotNull(authenticationTokenEntity.getCreated());
		Assert.assertNotNull(authenticationTokenEntity.getExpired());
		Assert.assertNotNull(authenticationTokenEntity.getUserId());

		Assert.assertTrue(authenticationTokenEntity.getCreated().getTime() < authenticationTokenEntity.getExpired().getTime());

		Assert.assertNull(authenticationTokenManager.getByToken(StringUtils.EMPTY));
		Assert.assertNull(authenticationTokenManager.getByToken(null));
		Assert.assertNotNull(authenticationTokenManager.getByToken(authenticationTokenEntity.getToken()));
		Assert.assertNull(authenticationTokenManager.get(new Long(-1)));
		Assert.assertNull(authenticationTokenManager.get(null));
		Assert.assertNotNull(authenticationTokenManager.get(authenticationTokenEntity.getAuthenticationTokenId()));

		final String initialToken = authenticationTokenEntity.getToken();
		final Date initialExpired = authenticationTokenEntity.getExpired();

		Thread.sleep(1000);

		authenticationTokenManager.touchToken(authenticationTokenEntity.getAuthenticationTokenId());
		authenticationTokenEntity = authenticationTokenManager.get(authenticationTokenEntity.getAuthenticationTokenId());

		Assert.assertTrue(initialExpired.getTime() < authenticationTokenEntity.getExpired().getTime());

		authenticationTokenEntity = authenticationTokenManager.create(userEntity.getUserId());
		Assert.assertNotEquals(initialToken, authenticationTokenEntity.getToken());
	}
}

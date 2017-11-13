package com.dev3l.helwoho.data.entity.manager.test;

import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.jooq.Condition;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dev3l.crypto.Pbkdf2Encrypter;
import com.dev3l.crypto.RandomSaltGenerator;
import com.dev3l.helwoho.data.entity.UserEntity;
import com.dev3l.helwoho.data.entity.enums.UserStatusEnum;
import com.dev3l.helwoho.data.entity.manager.UserManager;
import com.dev3l.helwoho.data.entity.manager.action.UserAction;

public class UserManagerIT {
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "";
	private static final String URL = "jdbc:mysql://localhost:3306";

	private static final String TEST_USER_NAME = "it_test_name_test_create";
	private static final String TEST_EMAIL = "it_test_name_test_create@email.com";

	private UserManager userManager = null;
	private UserAction userAction = null;

	@Before
	public void setup() throws Exception {
		userManager = new UserManager(DSL.using(DriverManager.getConnection(URL, USER_NAME, PASSWORD), SQLDialect.MYSQL));
		userAction = new UserAction(new Pbkdf2Encrypter(), new RandomSaltGenerator());
		cleanup();
	}

	@After
	public void cleanup() {
		final UserEntity userEntity = userManager.getByUserName(TEST_USER_NAME);

		if (userEntity != null) {
			userManager.delete(userEntity.getUserId());
		}
	}

	@Test
	public void testCreateAndDelete() throws FileNotFoundException {
		Assert.assertNull(userManager.create(null));
		UserEntity userEntity = new UserEntity(null, null, null, null);
		Assert.assertNull(userManager.create(userEntity));
		userEntity.setUserId(new Long(0));
		Assert.assertNull(userManager.create(userEntity));
		Assert.assertNull(userManager.get(null));

		userEntity = new UserEntity(TEST_USER_NAME, TEST_EMAIL, UserStatusEnum.ACTIVE.getValue(), "super_secret");
		userAction.addSaltAndEncryptPasswordForUser(userEntity);

		userEntity = userManager.create(userEntity);
		Assert.assertNotNull(userEntity);
		Assert.assertNotNull(userEntity.getUserId());

		Assert.assertTrue(userAction.isValidPasswordForUser(userEntity, "super_secret"));

		userManager.delete(userEntity.getUserId());
	}

	@Test
	public void testRead() throws FileNotFoundException {
		cleanup();

		UserEntity userEntity = new UserEntity(TEST_USER_NAME, TEST_EMAIL, UserStatusEnum.ACTIVE.getValue(), "super_secret");
		userAction.addSaltAndEncryptPasswordForUser(userEntity);
		userEntity = userManager.create(userEntity);

		List<UserEntity> users = userManager.read(null);

		Assert.assertNotNull(users);
		Assert.assertTrue(users.size() > 0);

		users = userManager.read(new ArrayList<Condition>());

		Assert.assertNotNull(users);
		Assert.assertTrue(users.size() > 0);

		userEntity = userManager.get(users.get(0).getUserId());

		Assert.assertNotNull(userEntity);
		Assert.assertNotNull(userEntity.getUserId());
		Assert.assertTrue(userEntity.getUserId() == users.get(0).getUserId());

		Assert.assertNotNull(userManager.read());
		cleanup();
	}

	@Test
	public void testUpdate() throws FileNotFoundException {
		cleanup();

		UserEntity userEntity = new UserEntity(TEST_USER_NAME, TEST_EMAIL, UserStatusEnum.ACTIVE.getValue(), "super_secret");
		userAction.addSaltAndEncryptPasswordForUser(userEntity);

		userEntity = userManager.create(userEntity);

		Assert.assertNotNull(userEntity);
		Assert.assertNotNull(userEntity.getUserId());

		final String initialEmail = userEntity.getEmail();
		final String initialStatus = userEntity.getStatus();
		final String initialPassword = userEntity.getPassword();
		final String initialSalt = userEntity.getSalt();

		userEntity.setEmail("not_" + TEST_EMAIL);
		userEntity.setStatus("NOT A VALID STATUS");
		userAction.addSaltAndEncryptPasswordForUser(userEntity);

		Assert.assertNull(userManager.updateUserEmail(null));
		Assert.assertNotNull(userManager.updateUserEmail(userEntity));

		Assert.assertNull(userManager.updateUserStatus(null));
		Assert.assertNull(userManager.updateUserStatus(userEntity));
		userEntity.setStatus(UserStatusEnum.INACTIVE.getValue());
		Assert.assertNotNull(userManager.updateUserStatus(userEntity));

		Assert.assertNull(userManager.updateUserPassword(null));
		Assert.assertNotNull(userManager.updateUserPassword(userEntity));

		userEntity = userManager.get(userEntity.getUserId());

		Assert.assertNotEquals(userEntity.getEmail(), initialEmail);
		Assert.assertNotEquals(userEntity.getStatus(), initialStatus);
		Assert.assertNotEquals(userEntity.getPassword(), initialPassword);
		Assert.assertNotEquals(userEntity.getSalt(), initialSalt);
	}
}

package com.dev3l.helwoho.data.entity.manager.action;

import java.io.FileNotFoundException;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.dev3l.crypto.Pbkdf2Encrypter;
import com.dev3l.crypto.RandomSaltGenerator;
import com.dev3l.helwoho.data.entity.UserEntity;

public class UserAction {
	private Pbkdf2Encrypter pbkdf2Encrypter;
	private RandomSaltGenerator randomSaltGenerator;

	@Deprecated
	public UserAction() {
	}

	@Inject
	public UserAction(final Pbkdf2Encrypter pbkdf2Encrypter, final RandomSaltGenerator randomSaltGenerator) {
		this.pbkdf2Encrypter = pbkdf2Encrypter;
		this.randomSaltGenerator = randomSaltGenerator;
	}

	public void addSaltAndEncryptPasswordForUser(final UserEntity userEntity) throws FileNotFoundException {
		if (userEntity == null) {
			return;
		}

		final String salt = randomSaltGenerator.createSalt();
		final String encryptedPassword = pbkdf2Encrypter.encrypt(userEntity.getPassword(), salt);

		userEntity.setPassword(encryptedPassword);
		userEntity.setSalt(salt);
	}

	public boolean isValidPasswordForUser(final UserEntity userEntity, final String password) throws FileNotFoundException {
		if (StringUtils.isEmpty(password) || (userEntity == null)) {
			return false;
		}

		return StringUtils.defaultString(userEntity.getPassword()).equals(pbkdf2Encrypter.encrypt(password, userEntity.getSalt()));
	}
}

//
// Copyright 2009 Robin Komiwes, Bruno Verachten, Christophe Cordenier
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package com.wooki.domain.biz;

import java.util.Date;

import org.apache.tapestry5.ioc.internal.util.Defense;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.icu.util.Calendar;
import com.wooki.domain.dao.ActivityDAO;
import com.wooki.domain.dao.UserDAO;
import com.wooki.domain.exception.AuthorizationException;
import com.wooki.domain.exception.UserAlreadyException;
import com.wooki.domain.model.User;
import com.wooki.domain.model.activity.AccountActivity;
import com.wooki.domain.model.activity.AccountEventType;
import com.wooki.services.security.WookiSecurityContext;

@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserManagerImpl implements UserManager {

	private UserDAO authorDao;

	private ActivityDAO activityDao;

	private WookiSecurityContext securityCtx;

	private SaltSource saltSource;

	private PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = false, rollbackFor = UserAlreadyException.class)
	public void addUser(User author) throws UserAlreadyException {

		if (findByUsername(author.getUsername()) != null) {
			throw new UserAlreadyException();
		}

		// Encode password into database
		String pass = author.getPassword();
		author.setCreationDate(new Date());
		author.setPassword(this.passwordEncoder.encodePassword(pass, this.saltSource.getSalt(author)));
		authorDao.create(author);

		AccountActivity aa = new AccountActivity();
		aa.setCreationDate(Calendar.getInstance().getTime());
		aa.setType(AccountEventType.JOIN);
		aa.setUser(author);
		this.activityDao.create(aa);

	}

	public User findByUsername(String username) {
		return authorDao.findByUsername(username);
	}

	public User findById(Long userId) {
		Defense.notNull(userId, "userId");
		return authorDao.findById(userId);
	}

	public String[] listUserNames(String prefix) {
		return authorDao.listUserNames(prefix);
	}

	@Transactional(readOnly = false)
	public User updateDetails(User user) throws AuthorizationException, UserAlreadyException {
		Defense.notNull(user, "user");

		if (!this.securityCtx.isLoggedIn() || this.securityCtx.getAuthor().getId() != user.getId()
				&& user.getPassword() != this.securityCtx.getAuthor().getPassword()) {
			throw new AuthorizationException("Action not authorized");
		}

		User userByUsername = findByUsername(user.getUsername());

		// check if the new username is not already taken by someone else
		if (userByUsername != null && userByUsername.getId() != user.getId()) {
			throw new UserAlreadyException();
		}

		this.securityCtx.log(authorDao.update(user));

		return user;
	}

	@Transactional(readOnly=false)
	public User updatePassword(User user, String oldPassword, String newPassword) throws AuthorizationException {
		Defense.notNull(user, "user");
		Defense.notNull(oldPassword, "oldPassword");
		Defense.notNull(newPassword, "newPassword");

		if (!this.securityCtx.isLoggedIn() || this.securityCtx.getAuthor().getId() != user.getId()) {
			throw new AuthorizationException("Action not authorized");
		}

		String encodedPassword = this.passwordEncoder.encodePassword(oldPassword, this.saltSource.getSalt(user)) ;
		if (!encodedPassword.equals(this.securityCtx.getAuthor().getPassword())) {
			throw new AuthorizationException();
		}
		
		user.setPassword(this.passwordEncoder.encodePassword(newPassword, this.saltSource.getSalt(user)));
		this.securityCtx.log(authorDao.update(user));

		return user;
	}

	public UserDAO getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(UserDAO authorDao) {
		this.authorDao = authorDao;
	}

	public ActivityDAO getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDAO activityDao) {
		this.activityDao = activityDao;
	}

	public WookiSecurityContext getSecurityCtx() {
		return securityCtx;
	}

	public void setSecurityCtx(WookiSecurityContext securityCtx) {
		this.securityCtx = securityCtx;
	}

	public SaltSource getSaltSource() {
		return saltSource;
	}

	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	public PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

}

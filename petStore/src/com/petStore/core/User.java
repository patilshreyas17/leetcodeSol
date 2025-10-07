package com.petStore.core;

import com.petStore.exceptions.AuthenticationException;

public enum User {
	ADMIN("ADMIN", "ADMIN"), C1("C1", "C1");

	private String id;
	private String password;

	User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	};

	public static User login(String id, String password) throws AuthenticationException {
		try {

			User user = User.valueOf(id);

			if (password.contentEquals(ADMIN.getPassword()) | password.contains(C1.getPassword())) {
				return user;
			} else {
				
				throw new AuthenticationException();
			}

		} catch (IllegalArgumentException e) {
			throw new AuthenticationException("Invalid Credentials");
		}

	}

}

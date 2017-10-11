package org.cubalibre.familink.api.entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
	
	private static final Logger LOG = LoggerFactory.getLogger(User.class.getName());

	private int id;
	private String mail;
	private String password;
	private Contact contact;

	/**
	 * Constructor
	 *
	 * @param id
	 * @param mail
	 * @param password
	 * @param contact
	 */
	public User(int id, String mail, String password, Contact contact) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.contact = contact;
	}

	/**
	 * Contructor vide
	 */
	public User() {
		LOG.info("User");
	}

	/**
	 * GETTERS & SETTERS
	 * @return
	 */
	public int getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contact getContact() {
		return contact;
	}
}

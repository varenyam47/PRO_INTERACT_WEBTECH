package com.WebTechPro.service;

import java.util.List;

import com.WebTechPro.entity.Contact;

public interface ContactService {
	public void saveContact(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContactById(long id);

}

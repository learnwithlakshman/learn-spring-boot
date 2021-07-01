package com.careerit.learnspringboot.service;

import java.util.List;

import com.careerit.learnspringboot.domain.Contact;

public interface ContactService {
	
	public int addContact(Contact contact);
	public List<Contact> getContacts();
	public List<Contact> search(String str);
	public boolean removeContact(int cid);
	public int modifyContact(Contact contact);
	public Contact getContacct(int cid);
	
}

package com.careerit.learnspringboot.dao;

import java.util.List;

import com.careerit.learnspringboot.domain.Contact;

public interface ContactDao {

	public int insertContact(Contact contact);
	public List<Contact> selectContacts();
	public List<Contact> search(String str);
	public boolean delecteContact(int cid);
	public int updateContact(Contact contact);
	public Contact selectContacct(int cid);

}

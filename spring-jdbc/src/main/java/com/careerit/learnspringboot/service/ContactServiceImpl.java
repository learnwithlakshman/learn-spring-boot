package com.careerit.learnspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.learnspringboot.dao.ContactDao;
import com.careerit.learnspringboot.domain.Contact;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

	
	private ContactDao contactDao;
	
	@Autowired
	public ContactServiceImpl(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public int addContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> list = contactDao.selectContacts();
		return list;
	}

	@Override
	public List<Contact> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int modifyContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact getContacct(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}

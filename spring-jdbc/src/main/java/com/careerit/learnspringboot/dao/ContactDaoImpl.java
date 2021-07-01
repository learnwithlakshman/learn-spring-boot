package com.careerit.learnspringboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.careerit.learnspringboot.domain.Contact;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ContactDaoImpl implements ContactDao {

	private static final String GET_CONTACTS = "SELECT cid,name,email,phone FROM contact";
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ContactDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Contact> selectContacts() {
		List<Contact> list = jdbcTemplate.query(GET_CONTACTS, new BeanPropertyRowMapper<Contact>(Contact.class));
		log.info("Total contacts {} found", list.size());
		return list;
	}

	@Override
	public List<Contact> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delecteContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Contact selectContacct(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}

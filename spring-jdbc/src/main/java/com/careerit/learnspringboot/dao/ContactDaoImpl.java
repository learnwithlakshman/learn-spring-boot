package com.careerit.learnspringboot.dao;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.careerit.learnspringboot.domain.Contact;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ContactDaoImpl implements ContactDao {

	private static final String GET_CONTACTS = "SELECT cid,name,email,phone FROM contact";
	private static final String GET_CONTACTS_BY_ID = "SELECT cid,name,email,phone FROM contact where cid=?";
	private static final String INSERT_CONTACT = "INSERT INTO contact(name,email,phone) VALUES(?,?,?)";
	private JdbcTemplate jdbcTemplate;

	RowMapper<Contact> mapper = (rs, rn) -> {
		Contact contact = new Contact();
		contact.setCid(rs.getInt("cid"));
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setPhone(rs.getString("phone"));
		return contact;
	};

	@Autowired
	public ContactDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertContact(Contact contact) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (con -> {
			PreparedStatement pst = con.prepareStatement(INSERT_CONTACT, new String[] { "cid" });
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getEmail());
			pst.setString(3, contact.getPhone());
			return pst;
		});
		int res = jdbcTemplate.update(creator, keyHolder);

		log.info("Total {} record(s) are updated/inserted", res);
		int generateKey = (int) keyHolder.getKey();
		log.info("Record is inserted with id :{}", generateKey);
		return generateKey;
	}

	@Override
	public List<Contact> selectContacts() {
		List<Contact> list = jdbcTemplate.query(GET_CONTACTS, mapper);
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
		Contact contact = jdbcTemplate.queryForObject(GET_CONTACTS_BY_ID, new Object[] { cid },
				new int[] { Types.INTEGER }, mapper);
		log.info("Looking for contact with id :{}", cid);
		log.info("Contact with id {} status : {}", cid, contact != null ? "Found" : "Not found");
		return contact;
	}

}

package com.careerit.ipl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.RoleCountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;

@Repository
public class IplStatDaoImpl implements IplStatDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public List<String> findTeamNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findPlayesByTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAmountDTO> findRoleAmountByTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamAmountDTO> findAmountSpentByAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleCountDTO> findRoleCountByTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

}

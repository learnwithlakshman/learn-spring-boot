package com.careerit.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerit.ipl.dao.IplStatDao;
import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.RoleCountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;

@Service
public class IplStatServiceImpl implements IplStatService{

	@Autowired
	private IplStatDao iplStatDao;
	
	@Override
	public List<String> teamNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> playesByTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleAmountDTO> roleAmountByTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamAmountDTO> amountSpentByAllTeams() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleCountDTO> roleCountByTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

}

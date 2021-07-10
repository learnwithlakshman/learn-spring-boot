package com.careerit.ipl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.careerit.ipl.dao.IplStatDao;
import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.PlayerDTO;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.RoleCountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;
import com.careerit.ipl.dto.TeamNamesDTO;

@Service
public class IplStatServiceImpl implements IplStatService {

	@Autowired
	private IplStatDao iplStatDao;

	@Override
	public TeamNamesDTO teamNames() {
		return iplStatDao.findTeamNames();
	}

	@Override
	public List<PlayerDTO> playesByTeam(String teamName) {
		Assert.isTrue(!teamName.isEmpty(), "Team name can't be empty or null");
		List<PlayerDTO> playerList = iplStatDao.findPlayesByTeam(teamName);
		return playerList;
	}

	@Override
	public List<RoleAmountDTO> roleAmountByTeam(String teamName) {
		Assert.isTrue(!teamName.isEmpty(), "Team name can't be empty or null");
		List<RoleAmountDTO> list = iplStatDao.findRoleAmountByTeam(teamName);
		return list;
	}

	@Override
	public List<TeamAmountDTO> amountSpentByEachTeam() {
		return iplStatDao.findAmountSpentByEachTeam();
	}

	@Override
	public List<PlayerDTO> playersByTeamAndRole(String teamName,String role) {
		// TODO Auto-generated method stub
		return null;
	}

}

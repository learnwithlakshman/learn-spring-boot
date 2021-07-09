package com.careerit.ipl.dao;

import java.util.List;

import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.RoleCountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;

public interface IplStatDao {
	public List<String> findTeamNames();

	public List<Player> findPlayesByTeam(String teamName);

	public List<RoleAmountDTO> findRoleAmountByTeam(String teamName);

	public List<TeamAmountDTO> findAmountSpentByAllTeams();

	public List<RoleCountDTO> findRoleCountByTeam(String teamName);
}

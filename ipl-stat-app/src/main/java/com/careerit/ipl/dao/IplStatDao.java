package com.careerit.ipl.dao;

import java.util.List;

import com.careerit.ipl.dto.PlayerDTO;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;
import com.careerit.ipl.dto.TeamNamesDTO;

public interface IplStatDao {
	public TeamNamesDTO findTeamNames();

	public List<PlayerDTO> findPlayesByTeam(String teamName);

	public List<RoleAmountDTO> findRoleAmountByTeam(String teamName);

	public List<TeamAmountDTO> findAmountSpentByEachTeam();

	public List<PlayerDTO> findPlayersByTeamAndRole(String teamName,String role);
}

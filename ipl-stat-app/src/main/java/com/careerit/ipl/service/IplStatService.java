package com.careerit.ipl.service;

import java.util.List;

import com.careerit.ipl.dto.PlayerDTO;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;
import com.careerit.ipl.dto.TeamNamesDTO;

public interface IplStatService {

		public TeamNamesDTO teamNames();
		public List<PlayerDTO> playesByTeam(String teamName);
		public List<RoleAmountDTO> roleAmountByTeam(String teamName);
		public List<TeamAmountDTO> amountSpentByEachTeam();
		public List<PlayerDTO> playersByTeamAndRole(String teamName,String role);
		
}

package com.careerit.ipl.service;

import java.util.List;

import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.RoleCountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;

public interface IplStatService {

		public List<String> teamNames();
		public List<Player> playesByTeam(String teamName);
		public List<RoleAmountDTO> roleAmountByTeam(String teamName);
		public List<TeamAmountDTO> amountSpentByAllTeams();
		public List<RoleCountDTO> roleCountByTeam(String teamName);
}

package com.careerit.ipl.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerit.ipl.auth.web.UsernameUtil;
import com.careerit.ipl.dto.PlayerDTO;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;
import com.careerit.ipl.dto.TeamNamesDTO;
import com.careerit.ipl.service.IplStatService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/ipl/")
@Slf4j
public class IplStatController {

	@Autowired
	private IplStatService iplStatService;

	@GetMapping("/teamnames")
	public TeamNamesDTO getTeamNames() {
		log.info("User {} is requested for team names",
				UsernameUtil.loginUser());
		return iplStatService.teamNames();
	}

	@GetMapping("/{teamName}")
	public List<PlayerDTO> getPlayers(@PathVariable("teamName") String teamName) {
		log.info("User {} is requested for players",
				UsernameUtil.loginUser());
		return iplStatService.playesByTeam(teamName);
	}

	@GetMapping("/{teamName}/{role}")
	public List<PlayerDTO> getPlayersByTeamAndRole(@PathVariable("teamName") String teamName,
			@PathVariable("role") String role) {
		log.info("User {} is requested for team names",
				UsernameUtil.loginUser());
		return iplStatService.playersByTeamAndRole(teamName, role);
	}

	@GetMapping("/roleamountandcount/{teamName}")
	public List<RoleAmountDTO> getAmountAndRoleCount(@PathVariable("teamName") String teamName) {
			
		return iplStatService.roleAmountByTeam(teamName);
	}

	@GetMapping("/teamstat")
	public List<TeamAmountDTO> getTeamAmountDetails() {
	
		return iplStatService.amountSpentByEachTeam();
	}
	
	
}

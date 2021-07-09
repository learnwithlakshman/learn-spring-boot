package com.careerit.ipl.batch;

import org.springframework.batch.item.ItemProcessor;

import com.careerit.ipl.domain.Player;
import com.careerit.ipl.domain.Role;
import com.careerit.ipl.dto.PlayerDTO;

public class PlayerItemProcessor implements ItemProcessor<PlayerDTO,Player> {

	@Override
	public Player process(PlayerDTO item) throws Exception {
		Player player = new Player();
		player.setName(item.getName());
		player.setRole(Role.valueOf(item.getRole()));
		player.setPrice(item.getPrice());
		player.setTeam(item.getTeam());
		player.setCountry(item.getCountry());
		return player;
	}

}

package com.careerit.ipl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.PlayerDTO;
import com.careerit.ipl.dto.RoleAmountDTO;
import com.careerit.ipl.dto.RoleCountDTO;
import com.careerit.ipl.dto.TeamAmountDTO;
import com.careerit.ipl.dto.TeamNamesDTO;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class IplStatDaoImpl implements IplStatDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public TeamNamesDTO findTeamNames() {

		AggregationOperation group = Aggregation.group("null").addToSet("team").as("teamNames");
		AggregationOperation project = Aggregation.project().andExclude("_id");
		Aggregation aggregation = Aggregation.newAggregation(group, project);
		AggregationResults<TeamNamesDTO> res = mongoTemplate.aggregate(aggregation, "player", TeamNamesDTO.class);
		TeamNamesDTO teamNames = res.getUniqueMappedResult();
		log.info("Total team count :{}", teamNames.getTeamNames().size());
		return teamNames;
	}

	@Override
	public List<PlayerDTO> findPlayesByTeam(String teamName) {

		AggregationOperation match = Aggregation.match(Criteria.where("team").is(teamName));
		AggregationOperation project = Aggregation.project().andExclude("_id");
		Aggregation aggregation = Aggregation.newAggregation(match, project);
		AggregationResults<PlayerDTO> result = mongoTemplate.aggregate(aggregation, "player", PlayerDTO.class);
		List<PlayerDTO> list = result.getMappedResults();
		log.info("The team {} has {} players", teamName, list.size());
		return list;
	}

	@Override
	public List<RoleAmountDTO> findRoleAmountByTeam(String teamName) {
		AggregationOperation match = Aggregation.match(Criteria.where("team").is(teamName));
		AggregationOperation group = Aggregation.group("role").sum("price").as("amount").count().as("count");
		AggregationOperation project = Aggregation.project().andExclude("_id").and("_id").as("role")
				.andInclude("amount", "count");
		Aggregation aggregation = Aggregation.newAggregation(match, group, project);
		AggregationResults<RoleAmountDTO> result = mongoTemplate.aggregate(aggregation, "player", RoleAmountDTO.class);
		List<RoleAmountDTO> list = result.getMappedResults();
		log.info("The team {} has {} roles ", teamName, list.size());
		return list;
	}

	@Override
	public List<TeamAmountDTO> findAmountSpentByEachTeam() {
		AggregationOperation group = Aggregation.group("team").sum("price").as("amount").count().as("count");
		AggregationOperation project = Aggregation.project().andExclude("_id").and("_id").as("teamName").andInclude("amount","count");
		Aggregation aggregation = Aggregation.newAggregation(group, project);
		AggregationResults<TeamAmountDTO> result = mongoTemplate.aggregate(aggregation, "player", TeamAmountDTO.class);
		List<TeamAmountDTO> list = result.getMappedResults();
		log.info("Total teams {} is found ", list.size());
		return list;
	}

	@Override
	public List<PlayerDTO> findPlayersByTeamAndRole(String teamName,String role) {
		AggregationOperation match = Aggregation.match(Criteria.where("team").is(teamName).and("role").is(role));
		AggregationOperation project = Aggregation.project().andExclude("_id");
		Aggregation aggregation = Aggregation.newAggregation(match, project);
		AggregationResults<PlayerDTO> result = mongoTemplate.aggregate(aggregation, "player", PlayerDTO.class);
		List<PlayerDTO> list = result.getMappedResults();
		log.info("The team and role {} has {} players", teamName, list.size());
		return list;
	}

}

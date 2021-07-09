package com.careerit.ipl.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TeamAmountDTO {

		private String teamName;
		private double amount;
}

package com.careerit.ipl.dto;

import com.careerit.ipl.domain.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleAmountDTO {

	private Role role;
	private double amount;
}

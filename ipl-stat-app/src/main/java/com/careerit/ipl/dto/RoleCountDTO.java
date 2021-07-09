package com.careerit.ipl.dto;

import com.careerit.ipl.domain.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RoleCountDTO {

		private Role role;
		private int cout;
}

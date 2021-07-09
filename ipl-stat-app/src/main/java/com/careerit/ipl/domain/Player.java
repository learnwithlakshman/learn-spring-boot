package com.careerit.ipl.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
	private String id;
	private String name;
	private Role role;
	private String country;
	private String team;
	private double price;
}

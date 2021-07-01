package com.careerit.learnspringboot.config;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantGroup {

		private String name;
		private List<Tenant> tenants;
}

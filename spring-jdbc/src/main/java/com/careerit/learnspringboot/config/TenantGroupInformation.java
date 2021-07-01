package com.careerit.learnspringboot.config;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "tenantdetails")
public class TenantGroupInformation {
	
		private List<TenantGroup> tenantGroups;
		
		public List<Tenant> getTenantsByGroup(String groupName){
			   Optional<List<Tenant>> opt = tenantGroups.stream().filter(t->t.getName().equals(groupName)).findFirst().map(t->t.getTenants());
			   return opt.orElseThrow(()->new IllegalArgumentException("invalid tenant group name"));
		}

		public List<TenantGroup> getTenantGroups() {
			return tenantGroups;
		}

		public void setTenantGroups(List<TenantGroup> tenantGroups) {
			this.tenantGroups = tenantGroups;
		}
		
		
}

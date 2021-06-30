package com.careerit.learnspringboot.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

		private ReportService reportService;

		@Autowired
		public UserService(ReportService reportService) {
			this.reportService = reportService;
		}
		
		public void downloadReport(String username) {
			this.reportService.downloadReport(username);
		}
		
}

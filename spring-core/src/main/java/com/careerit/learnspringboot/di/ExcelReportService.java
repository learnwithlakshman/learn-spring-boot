package com.careerit.learnspringboot.di;

import org.springframework.stereotype.Component;

@Component
public class ExcelReportService implements ReportService {

	@Override
	public void downloadReport(String userName) {
		    
			System.out.println(userName+" your report is going to download");
	}

}

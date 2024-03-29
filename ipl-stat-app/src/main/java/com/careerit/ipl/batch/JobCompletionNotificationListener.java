package com.careerit.ipl.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.careerit.ipl.repo.PlayerRepo;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

		private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
		@Autowired
		private PlayerRepo playerRepo;
		@Override
		public void afterJob(JobExecution jobExecution) {
			if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			      log.info("!!! JOB FINISHED! Time to verify the results");
			      playerRepo.findAll().forEach(player->{
			    	  System.out.println(player.getName());
			      });
			}
		}
}

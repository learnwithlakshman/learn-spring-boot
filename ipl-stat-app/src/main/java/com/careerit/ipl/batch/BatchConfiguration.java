package com.careerit.ipl.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.careerit.ipl.domain.Player;
import com.careerit.ipl.dto.PlayerDTO;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Bean
	public FlatFileItemReader<PlayerDTO> reader() {
		return new FlatFileItemReaderBuilder<PlayerDTO>()
				.name("playerItemReader")
				.resource(new ClassPathResource("ipl_2020.csv")).delimited()
				.names(new String[] { "name", "role", "country", "team", "price" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<PlayerDTO>() {
					{
						setTargetType(PlayerDTO.class);
					}
				}).build();
	}

	@Bean
	public PlayerItemProcessor processor() {
		return new PlayerItemProcessor();
	}
	
	  @Bean
	  public MongoItemWriter<Player> writer() {
	    MongoItemWriter<Player> writer = new MongoItemWriter<Player>();
	    writer.setTemplate(mongoTemplate);
	    writer.setCollection("player");
	    return writer;
	  }

	
	@Bean
	public Job importPlayerJob(JobCompletionNotificationListener listener, Step step1) {
	  return jobBuilderFactory.get("importPlayerJob")
	    .incrementer(new RunIdIncrementer())
	    .listener(listener)
	    .flow(step1)
	    .end()
	    .build();
	}

	@Bean
	public Step step1(MongoItemWriter<Player> writer) {
	  return stepBuilderFactory.get("step1")
	    .<PlayerDTO, Player> chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .build();
	}
}
package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
	@Value("${app.topic.name}")
	private String topicaName;
	@Bean
public NewTopic createTopic()
{
	return new NewTopic(topicaName,3,(short) 1);
}
}

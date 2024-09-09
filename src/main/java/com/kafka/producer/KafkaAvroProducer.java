package com.kafka.producer;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.kafka.dto.Employee;

@Service
public class KafkaAvroProducer {
	@Value("${app.topic.name}")
	private String topicaName;
	@Autowired
KafkaTemplate<String,Employee> kafkaTemplate;
public void sendAvroEvents(Employee employee) {
	//UUID.randomUUID().toString()-> it is key
	CompletableFuture<SendResult<String,Employee>> future= kafkaTemplate.send(topicaName,UUID.randomUUID().toString(),employee);
	future.whenComplete((result,ex)-> {
		if(ex==null) {
			System.out.println("Sent message ["+employee+"] with offset=["+result.getRecordMetadata().offset()+"]");
		}
		else
		{
			System.out.println("Unable to send message["+employee+"] due to: "+ex.getMessage());	
		}
	});
}
}

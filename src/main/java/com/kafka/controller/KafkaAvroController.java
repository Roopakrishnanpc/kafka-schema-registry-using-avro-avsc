package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.dto.Employee;
import com.kafka.producer.KafkaAvroProducer;

@RestController
public class KafkaAvroController {
	@Autowired
	KafkaAvroProducer kafkaAvroProducer;
	@PostMapping("/avroPublishEvents")
	public ResponseEntity<String> sendMessagetoConsumer(@RequestBody Employee employee)
	// public ResponseEntity<?> sendMessagetoConsumer(@RequestBody Employee employee) 
	{
		kafkaAvroProducer.sendAvroEvents(employee);
		return  ResponseEntity.ok("Message sent successfully");
	}
}

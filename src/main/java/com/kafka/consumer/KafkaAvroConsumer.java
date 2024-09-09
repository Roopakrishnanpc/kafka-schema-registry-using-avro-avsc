package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.dto.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaAvroConsumer {
	@KafkaListener(topics= "${app.topic.name}")
	public void consume(ConsumerRecord<String, Employee> consumeRecord)
	{
		String key=consumeRecord.key();
		Employee valueemp=consumeRecord.value();
		log.info("Avro message receveived for key : "+key+" value :"+valueemp.toString());
	}
}

package org.msgproject.provider.sb_kafka_provider;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SbKafkaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbKafkaProviderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("recetas-topic", "Hello World");
		};
	}
}

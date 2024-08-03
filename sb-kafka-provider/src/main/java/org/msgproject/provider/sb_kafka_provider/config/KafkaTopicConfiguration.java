package org.msgproject.provider.sb_kafka_provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic generateNewTopic() {

        Map<String, String> configsProps = new HashMap<>();
        configsProps.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);
        configsProps.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");
        configsProps.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        configsProps.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "100000");

        return TopicBuilder.name("recetas-topic")
                .partitions(1)
                .replicas(2)
                .configs(configsProps)
                .build();
    }
}

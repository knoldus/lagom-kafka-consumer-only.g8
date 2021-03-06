package com.knoldus.kafka;

import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.broker.Topic;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.topic;

public interface KafkaService extends Service {

    Topic<String> greetingsTopic();

    String GREETINGS_TOPIC = "greetings";

    @Override
    default Descriptor descriptor() {
        return named("kafkaservice").withTopics(
                topic(GREETINGS_TOPIC, this::greetingsTopic)
        ).withAutoAcl(true);
    }
}

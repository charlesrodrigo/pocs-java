package com.demo.infra;

import com.demo.domain.model.Person;
import com.demo.domain.service.EventProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class EventProducerImpl implements EventProducer {

  private final Logger log = LoggerFactory.getLogger(EventProducerImpl.class);
  private final KafkaTemplate<String, Person> kafkaTemplate;
  private final String topic;

  public EventProducerImpl(
      KafkaTemplate<String, Person> kafkaTemplate,
      @Value("${spring.kafka.topic.producer}") String topic) {
    this.kafkaTemplate = kafkaTemplate;
    this.topic = topic;
  }

  @Override
  public void send(final Person person) {
    log.info("Init Send person {} to topic {}", person, topic);
    this.kafkaTemplate
        .send(topic, person)
        .addCallback(
            new ListenableFutureCallback<SendResult<String, Person>>() {

              @Override
              public void onSuccess(final SendResult<String, Person> message) {
                log.info(
                    "Send person {} to topic {} is successes with offset= {}",
                    person,
                    topic,
                    message.getRecordMetadata().offset());
              }

              @Override
              public void onFailure(final Throwable throwable) {
                log.error("Send person {} to topic {} is error", person, topic, throwable);
              }
            });
  }
}

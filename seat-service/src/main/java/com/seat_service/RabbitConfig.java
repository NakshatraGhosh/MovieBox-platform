package com.seat_service;
import java.util.Map;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue seatLockQueue() {
        return QueueBuilder.durable("seat-lock-queue")
            .withArgument("x-delayed-type", "direct")
            .build();
    }

    @Bean
    public CustomExchange seatLockExchange() {
        return new CustomExchange("seat-lock-exchange", "x-delayed-message", true, false,
            Map.of("x-delayed-type", "direct"));
    }

    @Bean
    public Binding seatLockBinding(Queue seatLockQueue, CustomExchange seatLockExchange) {
        return BindingBuilder.bind(seatLockQueue).to(seatLockExchange).with("seat.lock.release").noargs();
    }
}
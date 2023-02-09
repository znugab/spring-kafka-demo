package com.example.demoiicsapi;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

// Class
public class Producer {

    // Autowiring Kafka Template
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "purchases";

    // Publish messages using the GetMapping
    @PostMapping("/api/v1/orderdatamessages")
    public String publishMessage(@RequestBody String message)
    {

        // Sending the message
        kafkaTemplate.send(TOPIC, message);


        return "Message Successfully Published to Confluent Kafka";
    }
}
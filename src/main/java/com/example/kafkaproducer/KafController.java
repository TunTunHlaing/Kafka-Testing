package com.example.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("send")
    public ResponseEntity<HttpStatusCode> produce(@RequestBody OutputData data){
        kafkaTemplate.send("sms",data);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}

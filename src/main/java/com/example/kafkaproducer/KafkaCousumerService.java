package com.example.kafkaproducer;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaCousumerService {

    @KafkaListener(groupId = "group_id",
    topics = {
            "sms"
    })
    public void printEvent(OutputData data) throws JsonProcessingException {
       // var r = new ObjectMapper().readValue(data, OutputData.class);
        //System.out.println("Object is " + r);
        log.warn(data.toString());
    }

}

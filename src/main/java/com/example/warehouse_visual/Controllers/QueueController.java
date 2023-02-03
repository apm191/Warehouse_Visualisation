package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.publisher.RabbitMQProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class QueueController {

    private RabbitMQProducer producer;

    public QueueController(RabbitMQProducer producer) {
        this.producer = producer;
    }


}

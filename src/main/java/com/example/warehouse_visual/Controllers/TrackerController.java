package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.Models.Request;
import com.example.warehouse_visual.Models.Tracker;
import com.example.warehouse_visual.Services.TrackerService;
import com.example.warehouse_visual.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@RestController
public class TrackerController
{
    @Autowired
    private TrackerService trackerService;

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @PostMapping("/update-status")
    public void UpdateStatus(@RequestBody Request request)
    {
        Date date = new Date();
        String currentDate = new SimpleDateFormat("dd/mm/yyyy").format(date);
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(date);

        Tracker tracker = new Tracker(request.stationId,request.containerId,currentDate,currentTime);
        trackerService.UpdateStatus(tracker);
        rabbitMQProducer.sendMessage(tracker);
    }
}

package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.Models.Request;
import com.example.warehouse_visual.Models.Tracker;
import com.example.warehouse_visual.Services.TrackerService;
import com.example.warehouse_visual.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@RestController
public class TrackerController
{
    @Autowired
    private TrackerService trackerService;

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @GetMapping("/get-status")
    public List<Tracker> getStatus()
    {
        return trackerService.getAllstatus();
    }

    @GetMapping("/get-status-id")
    public List<Tracker> getStatus(@RequestParam String Id,@RequestParam String flag)
    {
        return trackerService.getStatusByStationId(Id,flag);
    }

    @PostMapping("/update-status")
    public void UpdateStatus(@RequestBody Request request)
    {
        Date date = new Date();
        String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(date);

        Tracker tracker = new Tracker(request.stationId,request.containerId,currentDate,currentTime);
        trackerService.UpdateStatus(tracker);
        rabbitMQProducer.sendMessage(tracker);
    }
}

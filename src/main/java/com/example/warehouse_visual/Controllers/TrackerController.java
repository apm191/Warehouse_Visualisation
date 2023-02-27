package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.Models.CustomTrackerResponse;
import com.example.warehouse_visual.Models.Request;
import com.example.warehouse_visual.Models.Tracker;
import com.example.warehouse_visual.Services.TrackerService;
import com.example.warehouse_visual.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackerController
{
    @Autowired
    private TrackerService trackerService;

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @GetMapping("/get-status")
    public CustomTrackerResponse getStatus()
    {
        CustomTrackerResponse customTrackerResponse = new CustomTrackerResponse(trackerService.getAllstatus());
        return customTrackerResponse;
    }

    @GetMapping("/get-status-id")
    public CustomTrackerResponse getStatus(@RequestParam String Id,@RequestParam String flag)
    {
        CustomTrackerResponse customTrackerResponse = new CustomTrackerResponse(trackerService.getStatusByStationId(Id,flag));
        return customTrackerResponse;
    }

    @PostMapping("/update-status")
    public void UpdateStatus(@RequestBody Request request) throws InterruptedException
    {
        Tracker tracker = new Tracker(request.fromScanner,request.toScanner, request.containerId)  ;
        trackerService.UpdateStatus(tracker);
        rabbitMQProducer.sendMessage(tracker);
    }
}

package com.example.warehouse_visual.Services;

import com.example.warehouse_visual.Dao.TrackerRepository;
import com.example.warehouse_visual.Models.Request;
import com.example.warehouse_visual.Models.Tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackerService
{
    @Autowired
    private TrackerRepository trackerRepository;

    public void UpdateStatus(Tracker tracker)
    {
        trackerRepository.save(tracker);
    }
}

package com.example.warehouse_visual.Services;

import com.example.warehouse_visual.Dao.TrackerRepository;
import com.example.warehouse_visual.Dao.TrackerRepository_JDBC;
import com.example.warehouse_visual.Models.Request;
import com.example.warehouse_visual.Models.Tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackerService
{
    @Autowired
    private TrackerRepository trackerRepository;

    @Autowired
    private TrackerRepository_JDBC trackerRepositoryJdbc;

    public void UpdateStatus(Tracker tracker)
    {
        trackerRepository.save(tracker);
    }

    public List<Tracker> getAllstatus()
    {
        return trackerRepository.findAll();
    }


    public List<Tracker> getStatusByStationId(String Id,String flag)
    {
        return trackerRepositoryJdbc.findByIdStation(Id,flag);
    }
}

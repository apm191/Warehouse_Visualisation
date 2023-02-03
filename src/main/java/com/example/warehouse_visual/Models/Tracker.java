package com.example.warehouse_visual.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@ToString
@NoArgsConstructor
public class Tracker
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int statusId;
    public String stationId;
    public String containerId;
    public String date;
    public String time;

    public int getStatusId() {
        return statusId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Tracker(String stationId, String containerId, String date, String time) {
        this.stationId = stationId;
        this.containerId = containerId;
        this.date = date;
        this.time = time;
    }

    // public String orderId;
}

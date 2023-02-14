package com.example.warehouse_visual.Models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
public class Tracker
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String stationId;
    public String containerId;
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp createdAt;
    public String color;

    public Tracker(String stationId, String containerId, String color) {
        this.stationId = stationId;
        this.containerId = containerId;
        this.color = color;
    }

    public int getId() {
        return Id;
    }

    public String getStationId() {
        return stationId;
    }

    public String getContainerId() {
        return containerId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public String getColor() {
        return color;
    }

    public void setId(int statusId) {
        this.Id = statusId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "statusId=" + Id +
                ", stationId='" + stationId + '\'' +
                ", containerId='" + containerId + '\'' +
                ", date='" + createdAt + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    // public String orderId;
}

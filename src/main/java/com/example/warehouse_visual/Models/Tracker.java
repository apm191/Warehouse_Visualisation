package com.example.warehouse_visual.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tracker
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int Id;
    public String fromScanner;
    public String toScanner;
    public String containerId;
    @Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    public Timestamp createdAt;

    public Tracker(String fromScanner, String toScanner,String containerId) {
        this.fromScanner = fromScanner;
        this.toScanner = toScanner;
        this.containerId = containerId;
    }

}

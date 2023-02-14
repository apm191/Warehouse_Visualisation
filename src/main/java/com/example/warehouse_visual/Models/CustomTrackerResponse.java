package com.example.warehouse_visual.Models;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CustomTrackerResponse
{
    public List<Tracker> trackerList;
}

package com.example.warehouse_visual.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request
{
    public String fromScanner;
    public String toScanner;
    public String containerId;
    public String color;

}

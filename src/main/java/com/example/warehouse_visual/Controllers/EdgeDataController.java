package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.Models.CustomEdgeResponse;
import com.example.warehouse_visual.Models.EdgeData;
import com.example.warehouse_visual.Models.Edges;
import com.example.warehouse_visual.Services.EdgeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EdgeDataController {

    @Autowired
    private EdgeDataService edgeDataService;

    @PostMapping("/post-edge-data")
    public void sendData(@RequestBody EdgeData edgeData) {
        edgeDataService.setEdge(edgeData);
    }

    @GetMapping("/get-edge-data")
    public CustomEdgeResponse getData() {
        CustomEdgeResponse customEdgeResponse = new CustomEdgeResponse(edgeDataService.getAllEdges());
        return customEdgeResponse;
    }
}

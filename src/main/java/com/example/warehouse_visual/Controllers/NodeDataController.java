package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.Models.CustomNodeResponse;
import com.example.warehouse_visual.Models.NodeData;
import com.example.warehouse_visual.Services.NodeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class NodeDataController
{
    @Autowired
    private NodeDataService nodeDataService;

    @PostMapping("/post-node-data")
    public void sendData(@RequestBody NodeData nodeData) {
         nodeDataService.setNodes(nodeData);
    }

    @GetMapping("/get-node-data")
    public CustomNodeResponse getData()
    {
        CustomNodeResponse customNodeResponse = new CustomNodeResponse(nodeDataService.getAllNodes());
        return customNodeResponse;
    }

    @PutMapping("/update-node-data")
    public void updateData(@RequestBody NodeData nodeData) {
        nodeDataService.updateNodes(nodeData);
    }
}

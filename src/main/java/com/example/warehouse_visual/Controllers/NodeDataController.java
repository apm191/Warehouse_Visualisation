package com.example.warehouse_visual.Controllers;

import com.example.warehouse_visual.Models.NodeData;
import com.example.warehouse_visual.Services.NodeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NodeDataController {

    @Autowired
    private NodeDataService nodeDataService;


    @PostMapping("/post-node-data")
    public void sendData(@RequestBody NodeData nodeData) {
         nodeDataService.setNodes(nodeData);
    }

    @GetMapping("/get-node-data")
    public List<NodeData> getData() {
        return nodeDataService.getAllNodes();
    }
}

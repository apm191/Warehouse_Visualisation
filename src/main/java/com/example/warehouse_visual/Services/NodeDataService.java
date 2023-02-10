package com.example.warehouse_visual.Services;

import com.example.warehouse_visual.Dao.NodeDataRepository;
import com.example.warehouse_visual.Dao.NodeRepository;
import com.example.warehouse_visual.Models.NodeData;
import com.example.warehouse_visual.Models.Nodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeDataService {

    @Autowired
    private NodeDataRepository nodeDataRepository;
    @Autowired
    private NodeRepository nodeRepository;

    public void setNodes(NodeData nodeData)
    {
        Nodes nodes = new Nodes();
        nodes.setNodeid(nodeData.getNode().getNodeid());
        nodeRepository.save(nodes);
        nodeDataRepository.save(nodeData);
    }


    public List<NodeData> getAllNodes() {
        return nodeDataRepository.findAll();
    }
}

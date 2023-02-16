package com.example.warehouse_visual.Services;

import com.example.warehouse_visual.Dao.NodeDataRepository;
import com.example.warehouse_visual.Dao.NodeRepository;
import com.example.warehouse_visual.Dao.PositionRepository;
import com.example.warehouse_visual.Models.NodeData;
import com.example.warehouse_visual.Models.Nodes;
import com.example.warehouse_visual.Models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeDataService {

    @Autowired
    private NodeDataRepository nodeDataRepository;
    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private PositionRepository positionRepository;

    public void setNodes(NodeData nodeData)
    {
        Nodes nodes = new Nodes();
        nodes.setNodeid(nodeData.getNode().getNodeid());
        nodeRepository.save(nodes);

        Position position = new Position();
        position.setId(nodeData.getPosition().getId());
        position.setX(nodeData.getPosition().getX());
        position.setY(nodeData.getPosition().getY());
        positionRepository.save(position);

        nodeDataRepository.save(nodeData);
    }


    public List<NodeData> getAllNodes() {
        return nodeDataRepository.findAll();
    }
}

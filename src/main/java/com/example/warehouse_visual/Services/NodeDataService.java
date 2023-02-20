package com.example.warehouse_visual.Services;

import com.example.warehouse_visual.Dao.NodeDataRepository;
import com.example.warehouse_visual.Dao.NodeRepository;
import com.example.warehouse_visual.Dao.PositionRepository;
import com.example.warehouse_visual.Models.NodeData;
import com.example.warehouse_visual.Models.Nodes;
import com.example.warehouse_visual.Models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

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
        nodes.setId(nodeData.getData().getId());
        nodes.setType(nodeData.getData().getType());
        nodes.setColor(nodeData.getData().getColor());
        nodes.setWidth(nodeData.getData().getWidth());
        nodes.setHeight(nodeData.getData().getHeight());

        Position position = new Position();
        position.setId(nodeData.getPosition().getId());
        position.setX(nodeData.getPosition().getX());
        position.setY(nodeData.getPosition().getY());

        positionRepository.save(position);
        nodeRepository.save(nodes);

        nodeDataRepository.save(nodeData);
    }

    public void updateNodes(NodeData nodeData) {
        Nodes nodes = new Nodes();
        nodes.setId(nodeData.getData().getId());
        nodes.setType(nodeData.getData().getType());
        nodes.setColor(nodeData.getData().getColor());
        nodes.setWidth(nodeData.getData().getWidth());
        nodes.setHeight(nodeData.getData().getHeight());
        nodeRepository.save(nodes);

        Position position = new Position();
        position.setId(nodeData.getPosition().getId());
        position.setX(nodeData.getPosition().getX());
        position.setY(nodeData.getPosition().getY());
        positionRepository.save(position);
    }

    public List<NodeData> getAllNodes() {
        return nodeDataRepository.findAll();
    }
}

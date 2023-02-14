package com.example.warehouse_visual.Services;

import com.example.warehouse_visual.Dao.EdgeDataRepository;
import com.example.warehouse_visual.Dao.EdgeRepository;
import com.example.warehouse_visual.Models.EdgeData;
import com.example.warehouse_visual.Models.Edges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdgeDataService {

    @Autowired
    private EdgeDataRepository edgeDataRepository;
    @Autowired
    private EdgeRepository edgeRepository;

    public void setEdge(EdgeData edgeData)
    {
        Edges edges = new Edges();
        edges.setId(edgeData.getData().getId());
        edges.setSource(edgeData.getData().getSource());
        edges.setTarget(edgeData.getData().getTarget());
        edgeRepository.save(edges);
        edgeDataRepository.save(edgeData);
    }

    public List<EdgeData> getAllEdges() {
        return edgeDataRepository.findAll();
    }
}

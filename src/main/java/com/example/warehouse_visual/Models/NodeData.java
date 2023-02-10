package com.example.warehouse_visual.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class NodeData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int nodeIndex;

    @OneToOne
    @JoinColumn(name = "idx", referencedColumnName = "nodeid")
    public Nodes node;

    @Override
    public String toString() {
        return "NodeData{" +
                "nodeIndex=" + nodeIndex +
                ", node=" + node +
                '}';
    }
}

package com.example.warehouse_visual.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

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
//    @Column(unique = true)
    @JoinColumn(name = "data_id", referencedColumnName = "id")
    public Nodes data;

    @OneToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    public Position position;

    @Override
    public String toString() {
        return "NodeData{" +
                "nodeIndex=" + nodeIndex +
                ", data=" + data +
                ", position=" + position +
                '}';
    }
}


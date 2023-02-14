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
public class EdgeData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int edgeIndex;

    @OneToOne
    @JoinColumn(name = "Eidx", referencedColumnName = "id")
    public Edges data;

    @Override
    public String toString() {
        return "EdgeData{" +
                "edgeIndex=" + edgeIndex +
                ", data=" + data +
                '}';
    }
}

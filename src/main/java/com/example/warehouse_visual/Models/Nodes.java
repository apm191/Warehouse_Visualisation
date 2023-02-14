package com.example.warehouse_visual.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Nodes
{
    @Id
    public String id;

    @Override
    public String toString() {
        return "Nodes{" +
                "id='" + id + '\'' +
                '}';
    }
}
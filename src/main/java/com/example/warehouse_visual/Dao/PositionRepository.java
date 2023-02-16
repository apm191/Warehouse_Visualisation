package com.example.warehouse_visual.Dao;

import com.example.warehouse_visual.Models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}

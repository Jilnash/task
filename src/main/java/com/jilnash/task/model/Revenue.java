package com.jilnash.task.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for DB table 'revenue'
 */

@Data
@Entity
@NoArgsConstructor
@Table(name = "revenue")
public class Revenue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cafe;

    private Double revenue;

    public Revenue(String cafe, Double revenue) {
        this.cafe = cafe;
        this.revenue = revenue;
    }
}

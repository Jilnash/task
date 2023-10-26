package com.jilnash.task.repo;

import com.jilnash.task.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for handling JPA queries to MySQL
 */
public interface RevenueRepo extends JpaRepository<Revenue, Long> {
}

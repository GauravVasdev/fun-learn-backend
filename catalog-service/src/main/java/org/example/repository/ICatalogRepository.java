package org.example.repository;

import org.example.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatalogRepository extends JpaRepository<Orders, Integer> {
}

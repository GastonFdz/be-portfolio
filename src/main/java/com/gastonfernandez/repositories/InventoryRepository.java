package com.gastonfernandez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gastonfernandez.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}

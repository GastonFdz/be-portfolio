package com.gastonfernandez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gastonfernandez.models.Shopping;

@Repository
public interface ShoppingRepository extends JpaRepository<Shopping, Long>{
}

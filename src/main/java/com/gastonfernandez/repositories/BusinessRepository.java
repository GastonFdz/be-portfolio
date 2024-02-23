package com.gastonfernandez.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gastonfernandez.models.Business;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    @Query("SELECT b FROM Business b WHERE b.business = :description")
    List<Business> findByDescription(@Param("description") String description);
}

package com.gastonfernandez.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gastonfernandez.models.PaymentMethod;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    @Query("SELECT pm FROM PaymentMethod pm WHERE pm.paymentMethod = :description")
    List<PaymentMethod> findByDescription(@Param("description") String description);
}

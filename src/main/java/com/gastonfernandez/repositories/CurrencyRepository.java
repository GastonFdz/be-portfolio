package com.gastonfernandez.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gastonfernandez.models.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}

package com.credibanco.assessment.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.card.model.Titular;

@Repository
public interface ITitularRepository extends JpaRepository<Titular, Long> {

}

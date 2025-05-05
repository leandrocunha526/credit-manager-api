package com.api.creditomanager.repositories;

import com.api.creditomanager.entities.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credito, Long> {
}

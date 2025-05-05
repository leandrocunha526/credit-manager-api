package com.api.creditomanager.services;

import com.api.creditomanager.entities.Credito;
import com.api.creditomanager.repositories.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository repository;

    public Credito findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Crédito não encontrado"));
    }

    public List<Credito> findAll() {
        return repository.findAll();
    }
}

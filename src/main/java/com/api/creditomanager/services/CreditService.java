package com.api.creditomanager.services;

import com.api.creditomanager.dtos.CreditoDTO;
import com.api.creditomanager.entities.Credito;
import com.api.creditomanager.repositories.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CreditoDTO> findByNumeroNfse(String numeroNfse) {
        List<Credito> entidades = repository.findByNumeroNfse(numeroNfse);
        return entidades.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CreditoDTO toDTO(Credito c) {
        return CreditoDTO.builder()
                .numeroCredito(c.getNumeroCredito())
                .numeroNfse(c.getNumeroNfse())
                .dataConstituicao(c.getDataConstituicao())
                .valorIssqn(c.getValorIssqn())
                .tipoCredito(c.getTipoCredito())
                .simplesNacional(c.isSimplesNacional())
                .aliquota(c.getAliquota())
                .valorFaturado(c.getValorFaturado())
                .valorDeducao(c.getValorDeducao())
                .baseCalculo(c.getBaseCalculo())
                .build();
    }
}

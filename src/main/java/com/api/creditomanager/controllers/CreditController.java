package com.api.creditomanager.controllers;

import com.api.creditomanager.entities.Credito;
import com.api.creditomanager.services.CreditService;
import com.api.creditomanager.services.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;
    private final KafkaProducerService kafkaProducer;

    @GetMapping("/{id}")
    public ResponseEntity<Credito> getById(@PathVariable Long id) {
        Credito credito = creditService.findById(id);
        kafkaProducer.sendLog("Consulta realizada para crédito com ID: " + id);
        return ResponseEntity.ok(credito);
    }

    @GetMapping
    public ResponseEntity<List<Credito>> getAll() {
        List<Credito> creditos = creditService.findAll();
        kafkaProducer.sendLog("Consulta realizada para listagem de todos os créditos");
        return ResponseEntity.ok(creditos);
    }
}

package com.api.creditomanager;

import com.api.creditomanager.entities.Credito;
import com.api.creditomanager.repositories.CreditRepository;
import com.api.creditomanager.services.CreditService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreditServiceTest {

    private CreditRepository creditRepository;
    private CreditService creditService;

    @BeforeEach
    void setUp() {
        creditRepository = mock(CreditRepository.class);
        creditService = new CreditService(creditRepository);
    }

    private Credito criarCreditoExemplo(Long id) {
        return Credito.builder()
                .id(id)
                .numeroCredito("123456")
                .numeroNfse("NFSE-001")
                .dataConstituicao(LocalDate.of(2024, 1, 10))
                .valorIssqn(BigDecimal.valueOf(300))
                .tipoCredito("Simples")
                .simplesNacional(true)
                .aliquota(BigDecimal.valueOf(0.05))
                .valorFaturado(BigDecimal.valueOf(10000))
                .valorDeducao(BigDecimal.valueOf(1000))
                .baseCalculo(BigDecimal.valueOf(9000))
                .build();
    }

    @Test
    void testFindById_CreditoExiste() {
        Credito credito = criarCreditoExemplo(1L);

        when(creditRepository.findById(1L)).thenReturn(Optional.of(credito));

        Credito result = creditService.findById(1L);

        assertNotNull(result);
        assertEquals("123456", result.getNumeroCredito());
        assertEquals(BigDecimal.valueOf(0.05), result.getAliquota());
        assertTrue(result.isSimplesNacional());
    }

    @Test
    void testFindById_CreditoNaoExiste() {
        when(creditRepository.findById(99L)).thenReturn(Optional.empty());

        RuntimeException ex = assertThrows(RuntimeException.class, () -> creditService.findById(99L));

        assertEquals("Crédito não encontrado", ex.getMessage());
    }

    @Test
    void testFindAll() {
        Credito c1 = criarCreditoExemplo(1L);
        Credito c2 = criarCreditoExemplo(2L);

        when(creditRepository.findAll()).thenReturn(List.of(c1, c2));

        List<Credito> result = creditService.findAll();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }
}

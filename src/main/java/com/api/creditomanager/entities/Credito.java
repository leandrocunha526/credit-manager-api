package com.api.creditomanager.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade que representa um crédito.
 */

@Entity
@Table(name = "credito")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número do crédito é obrigatório")
    @Column(name = "numero_credito", nullable = false)
    private String numeroCredito;

    @NotBlank(message = "O número da NFS-e é obrigatório")
    @Column(name = "numero_nfse", nullable = false)
    private String numeroNfse;

    @NotNull(message = "A data de constituição é obrigatória")
    @Column(name = "data_constituicao", nullable = false)
    private LocalDate dataConstituicao;

    @NotNull(message = "O valor do ISSQN é obrigatório")
    @PositiveOrZero(message = "O valor do ISSQN deve ser positivo")
    @Column(name = "valor_issqn", nullable = false)
    private BigDecimal valorIssqn;

    @NotBlank(message = "O tipo de crédito é obrigatório")
    @Column(name = "tipo_credito", nullable = false)
    private String tipoCredito;

    @Column(name = "simples_nacional", nullable = false)
    private boolean simplesNacional;

    @NotNull(message = "A alíquota é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false, message = "A alíquota deve ser maior que zero")
    @Column(name = "aliquota", nullable = false)
    private BigDecimal aliquota;

    @NotNull(message = "O valor faturado é obrigatório")
    @PositiveOrZero(message = "O valor faturado deve ser positivo")
    @Column(name = "valor_faturado", nullable = false)
    private BigDecimal valorFaturado;

    @NotNull(message = "O valor de dedução é obrigatório")
    @PositiveOrZero(message = "O valor de dedução deve ser positivo")
    @Column(name = "valor_deducao", nullable = false)
    private BigDecimal valorDeducao;

    @NotNull(message = "A base de cálculo é obrigatória")
    @PositiveOrZero(message = "A base de cálculo deve ser positiva")
    @Column(name = "base_calculo", nullable = false)
    private BigDecimal baseCalculo;
}

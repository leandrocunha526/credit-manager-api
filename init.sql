-- Criação da tabela 'credito'
CREATE TABLE IF NOT EXISTS credito (
    id SERIAL PRIMARY KEY,
    numero_credito VARCHAR(50),
    numero_nfse VARCHAR(50),
    data_constituicao DATE,
    valor_issqn NUMERIC(10,2),
    tipo_credito VARCHAR(20),
    simples_nacional BOOLEAN,
    aliquota NUMERIC(5,2),
    valor_faturado NUMERIC(12,2),
    valor_deducao NUMERIC(12,2),
    base_calculo NUMERIC(12,2)
);

-- Inserção de dados na tabela 'credito'
INSERT INTO credito (
    numero_credito, numero_nfse, data_constituicao, valor_issqn,
    tipo_credito, simples_nacional, aliquota, valor_faturado, valor_deducao, base_calculo
) VALUES
      ('123456', '7891011', '2024-02-25', 1500.75, 'ISSQN', true, 5.0, 30000.00, 5000.00, 25000.00),
      ('789012', '7891011', '2024-02-26', 1200.50, 'ISSQN', false, 4.5, 25000.00, 4000.00, 21000.00),
      ('654321', '1122334', '2024-01-15', 800.50, 'Outros', true, 3.5, 20000.00, 3000.00, 17000.00);

CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    fabricante_id BIGINT,
    FOREIGN KEY (fabricante_id) REFERENCES fabricantes(id)
);

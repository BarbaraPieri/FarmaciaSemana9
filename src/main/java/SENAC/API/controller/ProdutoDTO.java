package SENAC.API.controller;

public record ProdutoDTO(String nome, double preco, String descricao, FabricanteDTO fabricante) {
    public record FabricanteDTO(String nome) {

    }
}
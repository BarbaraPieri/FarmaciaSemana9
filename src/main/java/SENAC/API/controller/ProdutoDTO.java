package SENAC.API.controller;

import SENAC.API.produto.Produto;

public record ProdutoDTO(String nome, double preco, String descricao, FabricanteDTO fabricante) {
    public static ProdutoDTO fromProduto(Produto produtoAtualizado) {
        return new ProdutoDTO(
                produtoAtualizado.getNome(),
                produtoAtualizado.getPreco(),
                produtoAtualizado.getDescricao(),
                new FabricanteDTO(produtoAtualizado.getFabricante().getNome())
        );
    }

    public record FabricanteDTO(String nome) {

    }
}

package SENAC.API.produto;

import SENAC.API.fabricante.Fabricante;
import jakarta.validation.constraints.NotBlank;


public record DadosCadastroProduto (
    @NotBlank
    int id,

    @NotBlank
    String nome,

    @NotBlank
    String descricao,

    @NotBlank
    Double preco,

    @NotBlank
    Fabricante fabricante){
}

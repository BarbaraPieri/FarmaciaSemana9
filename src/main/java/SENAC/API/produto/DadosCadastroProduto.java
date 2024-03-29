package SENAC.API.produto;

import SENAC.API.fabricante.Fabricante;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DadosCadastroProduto {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotBlank
    private Double preco;

    @NotBlank
    private Fabricante fabricante;
}

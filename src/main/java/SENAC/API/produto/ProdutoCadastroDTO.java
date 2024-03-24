package SENAC.API.produto;

import SENAC.API.fabricante.DadosFabricante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoCadastroDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Double preco;

    @NotNull
    private DadosFabricante fabricante;
}

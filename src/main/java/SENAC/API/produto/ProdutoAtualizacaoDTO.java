package SENAC.API.produto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProdutoAtualizacaoDTO {

    @NotBlank(message = "A descrição não pode estar em branco")
    private String descricao;

    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    private Double preco;
}
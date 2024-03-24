package SENAC.API.fabricante;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DadosFabricante {

    @NotBlank
    private String nome;
}

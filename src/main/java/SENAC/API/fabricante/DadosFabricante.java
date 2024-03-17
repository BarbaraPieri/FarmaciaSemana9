package SENAC.API.fabricante;

import jakarta.validation.constraints.NotBlank;
public record DadosFabricante (
    @NotBlank
    int id,

    @NotBlank
    String nome){
}

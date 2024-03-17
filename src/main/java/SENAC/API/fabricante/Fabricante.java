package SENAC.API.fabricante;

import SENAC.API.fabricante.DadosFabricante;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

    public class Fabricante(DadosFabricante dados) {
        this.nome = dados.nome();
        this.id = dados.id();
    }
}
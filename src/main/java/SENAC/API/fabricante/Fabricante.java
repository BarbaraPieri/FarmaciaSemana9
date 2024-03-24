package SENAC.API.fabricante;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Fabricante(String nome) {
    }

    // Trecho adicionado
    public static Fabricante criarOuObterFabricante(String nome, FabricanteRepository fabricanteRepository) {
        return fabricanteRepository.findByNome(nome)
                .orElseGet(() -> fabricanteRepository.save(new Fabricante(nome)));
    }
}

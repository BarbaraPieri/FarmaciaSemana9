package SENAC.API.produto;

import SENAC.API.fabricante.Fabricante;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;

    @Enumerated(EnumType.STRING)
    private Fabricante fabricante;


    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.Nome();
        this.descricao = dados.Descricao();
        this.preco = dados.Preco();
        this.fabricante= dados.Fabricante();
           }
}
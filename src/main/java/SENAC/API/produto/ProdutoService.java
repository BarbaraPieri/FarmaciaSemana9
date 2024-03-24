package SENAC.API.produto;

import SENAC.API.fabricante.Fabricante;
import SENAC.API.fabricante.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final FabricanteRepository fabricanteRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, FabricanteRepository fabricanteRepository) {
        this.produtoRepository = produtoRepository;
        this.fabricanteRepository = fabricanteRepository;
    }

    public Produto cadastrarProduto(ProdutoCadastroDTO produtoDTO) {
        // Verifica se o fabricante já existe no banco de dados
        Fabricante fabricante = fabricanteRepository.findByNome(produtoDTO.getFabricante().getNome())
                .orElseGet(() -> fabricanteRepository.save(new Fabricante(produtoDTO.getFabricante().getNome())));

        // Cria um novo produto com os dados do DTO e o fabricante obtido/acrescentado
        Produto novoProduto = new Produto();
        novoProduto.setNome(produtoDTO.getNome());
        novoProduto.setDescricao(produtoDTO.getDescricao());
        novoProduto.setPreco(produtoDTO.getPreco());
        novoProduto.setFabricante(fabricante);

        // Salva o novo produto no banco de dados
        return produtoRepository.save(novoProduto);
    }
}

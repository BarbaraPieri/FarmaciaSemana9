package SENAC.API.produto;
import SENAC.API.exception.ProdutoNotFoundException;
import SENAC.API.fabricante.DadosFabricante;
import SENAC.API.fabricante.Fabricante;
import SENAC.API.fabricante.FabricanteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
                .orElseGet(() -> {
                    // Se o fabricante não existir, inclui o fabricante novo
                    DadosFabricante dadosFabricante = produtoDTO.getFabricante();
                    Fabricante novoFabricante = new Fabricante(dadosFabricante.getNome());
                    return fabricanteRepository.save(novoFabricante);
                });

        // Novo produto com os dados do DTO e o fabricante obtido/acrescentado
        Produto novoProduto = new Produto();
        novoProduto.setNome(produtoDTO.getNome());
        novoProduto.setDescricao(produtoDTO.getDescricao());
        novoProduto.setPreco(produtoDTO.getPreco());
        novoProduto.setFabricante(fabricante);

        // Salva o novo produto no banco de dados
        return produtoRepository.save(novoProduto);
    }

    public Page<Produto> listarProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }
    @Transactional
    public Produto atualizarProduto(Long id, ProdutoAtualizacaoDTO produtoDTO) {

        // Busca o produto pelo ID
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com o ID: " + id));

        // Atualiza os campos fornecidos no DTO de atualização
        if (produtoDTO.getDescricao() != null) {
            produto.setDescricao(produtoDTO.getDescricao());
        }
        if (produtoDTO.getPreco() != null) {
            produto.setPreco(produtoDTO.getPreco());
        }

        // Salva as alterações e retorna o produto atualizado
        return produtoRepository.save(produto);
    }
    public void deletarProduto(Long id) {
        // Verifica se o produto existe no banco de dados
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException("Produto não encontrado com o ID: " + id));

        // Exclui o produto do banco de dados
        produtoRepository.delete(produto);
    }
}

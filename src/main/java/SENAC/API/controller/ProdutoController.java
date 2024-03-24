package SENAC.API.controller;
import SENAC.API.produto.Produto;
import SENAC.API.produto.ProdutoAtualizacaoDTO;
import SENAC.API.produto.ProdutoCadastroDTO;
import SENAC.API.produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> listarProdutos(Pageable pageable) {
        Page<Produto> produtos = produtoService.listarProdutos(pageable);
        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@Valid @RequestBody ProdutoCadastroDTO produtoDTO) {
        return produtoService.cadastrarProduto(produtoDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDTO atualizarProduto(@PathVariable Long id, @Valid @RequestBody ProdutoAtualizacaoDTO produtoDTO) {
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produtoDTO);
        return ProdutoDTO.fromProduto(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
    }
}

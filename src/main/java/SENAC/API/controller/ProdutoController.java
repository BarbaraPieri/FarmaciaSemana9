package SENAC.API.controller;

import SENAC.API.produto.Produto;
import SENAC.API.produto.ProdutoCadastroDTO;
import SENAC.API.produto.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@Valid @RequestBody ProdutoCadastroDTO produtoDTO) {
        return produtoService.cadastrarProduto(produtoDTO);
    }
}

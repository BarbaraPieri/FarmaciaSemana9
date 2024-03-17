package SENAC.API.controller;

import SENAC.API.produto.DadosCadastroProduto;
import SENAC.API.produto.Produto;
import SENAC.API.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    @Transactional
    public  void cadastrar(@RequestBody  @Valid DadosCadastroProduto dados){

        repository.save(new Produto(dados));
    }
}

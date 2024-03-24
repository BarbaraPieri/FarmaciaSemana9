package SENAC.API.controller;

import SENAC.API.fabricante.DadosFabricante;
import SENAC.API.fabricante.FabricanteDTO;
import SENAC.API.fabricante.FabricanteService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    private final FabricanteService fabricanteService;

    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @PostMapping
    public ResponseEntity<FabricanteDTO> adicionarFabricante(@Valid @RequestBody DadosFabricante dadosFabricante) {
        FabricanteDTO fabricanteDTO = fabricanteService.adicionarFabricante(dadosFabricante);
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteDTO);
    }
    @GetMapping
    public ResponseEntity<List<FabricanteDTO>> listarFabricantes(Pageable pageable) {
        List<FabricanteDTO> fabricantes = fabricanteService.listarFabricante(pageable)
                .stream()
                .map(fabricante -> FabricanteDTO.fromFabricante(fabricante))
                .collect(Collectors.toList());
        return ResponseEntity.ok(fabricantes);
    }
}

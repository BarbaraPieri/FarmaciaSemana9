package SENAC.API.fabricante;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    public FabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    public FabricanteDTO adicionarFabricante(DadosFabricante dadosFabricante) {
        Fabricante fabricante = new Fabricante(dadosFabricante.getNome());
        Fabricante fabricanteSalvo = fabricanteRepository.save(fabricante);
        return FabricanteDTO.fromFabricante(fabricanteSalvo);
    }
    public Page<Fabricante> listarFabricante(Pageable pageable) {
        return fabricanteRepository.findAll(pageable);
    }

}
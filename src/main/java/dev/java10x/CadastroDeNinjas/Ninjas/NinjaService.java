package dev.java10x.CadastroDeNinjas.Ninjas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os Ninjas
    public List<NinjasDTO> listarNinjas(){
        List<NinjaModel> ninja = ninjaRepository.findAll();
        return ninja.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos os ninjas por ID
    public NinjasDTO listarNinjasPorID(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.map(ninjaMapper::map).orElse(null);
    }

    //Criar um novo ninja
    public NinjasDTO criarNinja(NinjasDTO ninjasDTO){
        NinjaModel ninja = ninjaMapper.map(ninjasDTO);;
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar ninja por ID | tem que ser um metodo Void
    public void deletarNinjaPorID(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjasDTO atualizarNinja(Long id, NinjasDTO ninjasDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjasDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

}

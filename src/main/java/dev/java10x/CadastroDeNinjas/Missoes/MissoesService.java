package dev.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todos as Missoes
    public List<MissoesDTO> mostrarMissoes(){
        List<MissoesModel> missao = missoesRepository.findAll();
        return missao.stream().map(missoesMapper::map).collect(Collectors.toList());
    }

    //Listar todas missoes por ID
    public MissoesDTO mostrarMissoesPorID(Long id){
        Optional<MissoesModel> missoes = missoesRepository.findById(id);
        return missoes.map(missoesMapper::map).orElse(null);
    }

    //Criar missao
    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    //Deletar Missao
    public void deletarMissao(Long id){
        missoesRepository.deleteById(id);
    }

    //Atualizar Missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        if (missao.isPresent()){
            MissoesModel missoes = missoesMapper.map(missoesDTO);
            missoes.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missoes);
            return missoesMapper.map(missaoSalva);
        }else {
            return null;
        }
    }



}

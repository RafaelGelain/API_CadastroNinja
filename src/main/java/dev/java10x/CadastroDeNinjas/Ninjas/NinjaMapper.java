package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjasDTO ninjasDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjasDTO.getId());
        ninjaModel.setNome(ninjasDTO.getNome());
        ninjaModel.setEmail(ninjasDTO.getEmail());
        ninjaModel.setIdade(ninjasDTO.getIdade());
        ninjaModel.setImgUrl(ninjasDTO.getImgUrl());
        ninjaModel.setRank(ninjasDTO.getRank());
        ninjaModel.setMissoes(ninjasDTO.getMissoes());

        return ninjaModel;
    }

    public NinjasDTO map(NinjaModel ninjaModel){
        NinjasDTO ninjasDTO = new NinjasDTO();
        ninjasDTO.setId(ninjaModel.getId());
        ninjasDTO.setNome(ninjaModel.getNome());
        ninjasDTO.setEmail(ninjaModel.getEmail());
        ninjasDTO.setIdade(ninjaModel.getIdade());
        ninjasDTO.setImgUrl(ninjaModel.getImgUrl());
        ninjasDTO.setRank(ninjaModel.getRank());
        ninjasDTO.setMissoes(ninjaModel.getMissoes());

        return ninjasDTO;
    }

}

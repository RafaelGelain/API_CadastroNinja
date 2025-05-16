package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "tb_missoes")
@Data
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String dificuldade;

    //todo:  @OneToMany -> Uma Missao ( MissoesModel ) para multiplos ninjas.
    //Conceito de ler o nome da annotation , Uma ( missao ) para Multiplas ( Ninjas ) missoes.

    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;


}

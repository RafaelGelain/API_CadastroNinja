package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

// Entity transforma uma classe em uma entidade do BD
@Entity
@Data
@Table(name = "tb_cadastro")
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    //todo:  @ManyToOne -> Uma Ninja ( NinjaModel ) tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing Key || Chave Estrangeira
    private MissoesModel missoes;



}

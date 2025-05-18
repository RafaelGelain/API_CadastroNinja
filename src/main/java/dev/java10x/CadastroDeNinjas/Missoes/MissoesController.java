package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissoes(){
        return "Listado";
    }

    @PostMapping("/criar")
    public String criarMissoes(){
        return "criar";
    }

    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "ALTERADO";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "deletada";
    }


}

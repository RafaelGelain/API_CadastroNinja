package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjasDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> lista = missoesService.mostrarMissoes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissoesPorID(@PathVariable Long id){
        MissoesDTO missoesDTO = missoesService.mostrarMissoesPorID(id);
        if (missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com o ID "+id+" nao encontrado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoesDTO){
            MissoesDTO novaMissao = missoesService.criarMissao(missoesDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso, nome da missao :"+novaMissao.getNome());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id , @RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoesAtt =  missoesService.atualizarMissao(id , missoesDTO);
        if (missoesAtt != null){
            return ResponseEntity.ok(missoesAtt);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com ID "+id+" nao encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
       if (missoesService.mostrarMissoesPorID(id) != null){
           missoesService.deletarMissao(id);
           return ResponseEntity.ok("Missao deleta com Sucesso.");
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com o ID "+id+" nao encontrada.");
       }
    }

}

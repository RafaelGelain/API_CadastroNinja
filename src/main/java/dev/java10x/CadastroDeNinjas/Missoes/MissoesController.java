package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjasDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    @Operation(summary = "Mostra as Missoes", description = "Traz as missoes cadastradas no Banco de Dados")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> lista = missoesService.mostrarMissoes();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista as Missoes por o ID", description = "Procura a Missao pelo o ID, e retorna o valor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao Encontrada com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Missao nao encontrado")
    })
    public ResponseEntity<?> listarMissoesPorID(@PathVariable Long id){
        MissoesDTO missoesDTO = missoesService.mostrarMissoesPorID(id);
        if (missoesDTO != null){
            return ResponseEntity.ok(missoesDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com o ID "+id+" nao encontrado");
        }
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova Missao", description = "cria uma nova missao e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Missao criado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na criacao da Missao")
    })
    public ResponseEntity<String> criarMissoes(@RequestBody MissoesDTO missoesDTO){
            MissoesDTO novaMissao = missoesService.criarMissao(missoesDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso, nome da missao :"+novaMissao.getNome());
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera a Missao por ID", description = "Altera a Missao por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao alterado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na alteracao da Missao, ID nao existe no banco de dados")
    })
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id , @RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoesAtt =  missoesService.atualizarMissao(id , missoesDTO);
        if (missoesAtt != null){
            return ResponseEntity.ok(missoesAtt);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com ID "+id+" nao encontrada");
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Missao por ID", description = "Pega o ID e busca no banco de dados , e faz a remocao.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Missao deletada com Sucesso"),
            @ApiResponse(responseCode = "404", description = "O ID nao existe no banco de dados")
    })
    public ResponseEntity<String> deletarMissao(@PathVariable Long id){
       if (missoesService.mostrarMissoesPorID(id) != null){
           missoesService.deletarMissao(id);
           return ResponseEntity.ok("Missao deleta com Sucesso.");
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com o ID "+id+" nao encontrada.");
       }
    }

}

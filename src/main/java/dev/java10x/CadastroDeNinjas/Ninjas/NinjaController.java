package dev.java10x.CadastroDeNinjas.Ninjas;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de Boas Vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas(){
        return "Essa e minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "cria um novo ninja e insere no banco de dados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na criacao do Ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjasDTO ninja){
        NinjasDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com Sucesso: "+novoNinja.getNome());
    }

    @GetMapping("/listar")
    @Operation(summary = "Mostra os Ninjas", description = "Traz os ninjas cadastrados no Banco de Dados")
    public ResponseEntity<List<NinjasDTO>> listarNinjas(){
        List<NinjasDTO> listaNinja = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaNinja);

    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por o ID", description = "Procura o ninja pelo o ID, e retorna o valor.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Encontrado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjasDTO ninjaPorId = ninjaService.listarNinjasPorID(id);
        if (ninjaPorId != null) {
            return ResponseEntity.ok(ninjaPorId);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("ninja com id : "+id+" nao existe");
        }

    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por ID", description = "Altera o ninja por ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro na alteracao do Ninja")
    })
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjasDTO ninjaAtualizado){
        NinjasDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado "+id);
        }
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar Ninja por ID", description = "Pega o ID e busca no banco de dados , e faz a remocao.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com Sucesso"),
            @ApiResponse(responseCode = "404", description = "O ID nao existe no banco de dados")
    })
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if (ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja deletado com sucesso : " + id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id "+id+" nao foi encontrado.");
        }
    }
}

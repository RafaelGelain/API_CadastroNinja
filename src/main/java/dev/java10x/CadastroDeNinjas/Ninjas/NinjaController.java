package dev.java10x.CadastroDeNinjas.Ninjas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(){
        return "Essa e minha primeira mensagem nessa rota";
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjasDTO ninja){
        NinjasDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com Sucesso: "+novoNinja.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjasDTO>> listarNinjas(){
        List<NinjasDTO> listaNinja = ninjaService.listarNinjas();
        return ResponseEntity.ok(listaNinja);

    }

    @GetMapping("/listar/{id}")
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
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjasDTO ninjaAtualizado){
        NinjasDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja nao encontrado "+id);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
        if (ninjaService.listarNinjasPorID(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja deletado com sucesso : " + id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o id "+id+" nao foi encontrado.");
        }
    }
}

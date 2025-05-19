package dev.java10x.CadastroDeNinjas.Ninjas;

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
    public NinjasDTO criarNinja(@RequestBody NinjasDTO ninja){
        return ninjaService.criarNinja(ninja);
    }


    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorID(@PathVariable Long id){
        return ninjaService.listarNinjasPorID(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaAtualizado){
        return ninjaService.atualizarNinja(id, ninjaAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorID(@PathVariable Long id){
        ninjaService.deletarNinjaPorID(id);
    }
}

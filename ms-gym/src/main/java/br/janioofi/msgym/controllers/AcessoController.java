package br.janioofi.msgym.controllers;

import br.janioofi.msgym.domain.dtos.AcessoDTO;
import br.janioofi.msgym.domain.entities.Acesso;
import br.janioofi.msgym.domain.services.AcessoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/acesso")
@Tag(name = "Acesso", description = "API Acesso")
@RequiredArgsConstructor
public class AcessoController {
    private final AcessoService service;

    @PostMapping("/entrada")
    public ResponseEntity<Acesso> entrada(@RequestBody AcessoDTO acessoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.entrada(acessoDTO));
    }

    @PostMapping("/saida")
    public ResponseEntity<Acesso> saida(@RequestBody AcessoDTO acessoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saida(acessoDTO));
    }

    @GetMapping("/apenas-hoje")
    public ResponseEntity<List<Acesso>> findAllAcessosDoDia(){
        return ResponseEntity.ok().body(service.findAllAcessosDoDia());
    }

}

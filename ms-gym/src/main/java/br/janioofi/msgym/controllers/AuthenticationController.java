package br.janioofi.msgym.controllers;

import br.janioofi.msgym.domain.dtos.UsuarioLogin;
import br.janioofi.msgym.domain.dtos.UsuarioRegistro;
import br.janioofi.msgym.domain.services.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "API Authentication")
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UsuarioLogin user){
        return ResponseEntity.ok(service.login(user));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsuarioRegistro user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(user));
    }
}
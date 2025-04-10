package com.societyscore.authservice.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO authDTO) {
        // Lógica para autenticar com Keycloak e retornar JWT
        return ResponseEntity.ok("Usuário autenticado");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        // Lógica para registrar novo usuário no Keycloak
        return ResponseEntity.ok("Usuário registrado");
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        // Lógica para registrar novo usuário no Keycloak
        return ResponseEntity.ok("Usuário registrado");
    }
}
package com.practice.localiza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.practice.localiza.auth.Login;
import com.practice.localiza.auth.Usuario;
import com.practice.localiza.service.UsuarioService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Login loginRequest) {
        try {
            Usuario registeredUser = usuarioService.registerUser(loginRequest);
            return ResponseEntity.ok(registeredUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/role/{userId}")
    public ResponseEntity<Usuario> updateRole(
            @PathVariable Long userId,
            @RequestParam String role) {
        try {
            Usuario updatedUser = usuarioService.updateRole(userId, role);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
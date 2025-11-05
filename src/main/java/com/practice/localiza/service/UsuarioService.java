package com.practice.localiza.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.localiza.auth.Login;
import com.practice.localiza.auth.LoginRepository;
import com.practice.localiza.auth.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private LoginRepository loginRepository; //

    @Autowired
    private PasswordEncoder passwordEncoder; //

    @Transactional
    public Usuario updateRole(Long userId, String newRole) {
        Usuario userToUpdate = loginRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        userToUpdate.setRole(newRole);
        return loginRepository.save(userToUpdate);
    }

    public Usuario registerUser(Login loginDTO) {

        if (loginRepository.findByUsername(loginDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Erro: Nome de usuário já está em uso!");
        }
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUsername(loginDTO.getUsername());

        String encodedPassword = passwordEncoder.encode(loginDTO.getPassword());
        novoUsuario.setPassword(encodedPassword);

        //novoUsuario.setRole("USER");

        return loginRepository.save(novoUsuario);
    }
}
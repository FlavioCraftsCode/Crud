package com.exemplo.crud.controller;

import com.exemplo.crud.model.Usuario;
import com.exemplo.crud.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioDados) {
        return repository.findById(id)
            .map(usuario -> {
                usuario.setNome(usuarioDados.getNome());
                usuario.setEmail(usuarioDados.getEmail());
                Usuario atualizado = repository.save(usuario);
                return ResponseEntity.ok().body(atualizado);
            }).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return repository.findById(id)
            .map(usuario -> {
                repository.delete(usuario);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
    }
}

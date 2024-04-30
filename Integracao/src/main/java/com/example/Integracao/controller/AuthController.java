// AuthController.java
package com.example.Integracao.controller;

import com.example.Integracao.model.Usuario;
import com.example.Integracao.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

private final UsuarioRepository usuarioRepository;

@Autowired
public AuthController(UsuarioRepository usuarioRepository) {
this.usuarioRepository = usuarioRepository;
}
@GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
    
@PostMapping
public Usuario criarUsuarios(@RequestBody Usuario usuario ) {
    return usuarioRepository.save(usuario);
}

@PostMapping("/login")
public Boolean login(@RequestBody Usuario usuario) {
    List<Usuario> usuarios = usuarioRepository.findAll();
    for(Usuario u : usuarios){
        if(u.getUsername().equals(usuario.getUsername())&&
           u.getPassword().equals(usuario.getPassword())){
            return true;
        }  
    }
    return false;
 }
}


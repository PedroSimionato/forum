package br.com.alura.forum.controller;

import br.com.alura.forum.dto.UsuarioDto;
import br.com.alura.forum.repository.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/usuarios")
    public List<UsuarioDto> getAllUsuarios(){

        return usuarioServiceImpl.findAll();
    }

    @GetMapping("/usuario/{id}")
    public UsuarioDto getById(long id){

        return usuarioServiceImpl.findById(id);
    }
}

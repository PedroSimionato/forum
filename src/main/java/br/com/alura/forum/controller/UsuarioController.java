package br.com.alura.forum.controller;

import br.com.alura.forum.dto.UsuarioDto;
import br.com.alura.forum.forms.UsuarioForm;
import br.com.alura.forum.repository.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value ="/usuarios")
public class UsuarioController {

    @Autowired
    @Lazy
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/users")
    public List<UsuarioDto> getAllUsuarios(){

        return usuarioServiceImpl.findAll();
    }

    @GetMapping("/user/{id}")
    public UsuarioDto getById(@PathVariable long id){

        return usuarioServiceImpl.findById(id);
    }

    @PostMapping("add/user")
    public void addUsuario(@RequestBody UsuarioForm usuarioForm){
        usuarioServiceImpl.addUsuario(usuarioForm);
    }

    @DeleteMapping
    public void deleteUsuario(@RequestBody UsuarioForm usuarioForm){
        usuarioServiceImpl.deleteUsuario(usuarioForm);
    }
}

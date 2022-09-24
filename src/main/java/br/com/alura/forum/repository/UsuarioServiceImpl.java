package br.com.alura.forum.repository;

import br.com.alura.forum.dto.UsuarioDto;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioServiceImpl {

    @Autowired
    private UsuarioService usuarioService;

    public List<UsuarioDto> findAll(){

        var usuarios = usuarioService.findAll();
        var usuariosDto = new ArrayList<UsuarioDto>();

        for (var usuario: usuarios) {
            var usuarioDto = UsuarioDto.builder()
                    .nome(usuario.getNome())
                    .email(usuario.getEmail())
                    .build();

            usuariosDto.add(usuarioDto);
        }

        return usuariosDto;
    }

    public UsuarioDto findById(long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        return UsuarioDto.builder()
                .nome(usuario.get().getNome())
                .email(usuario.get().getEmail())
                .build();
    }
}

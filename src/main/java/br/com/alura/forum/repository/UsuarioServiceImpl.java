package br.com.alura.forum.repository;

import br.com.alura.forum.dto.UsuarioDto;
import br.com.alura.forum.forms.UsuarioForm;
import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.services.UsuarioService;
import br.com.alura.forum.util.Cripto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioServiceImpl {

    @Autowired
    @Lazy
    private UsuarioService usuarioService;

    @Autowired
    @Lazy
    private Cripto cripto;

    public List<UsuarioDto> findAll(){

        var usuarios = usuarioService.findAll();
        var usuariosDto = new ArrayList<UsuarioDto>();

        for (var usuario: usuarios) {
            var usuarioDto = UsuarioDto.builder()
                    .nome(cripto.descriptografar(usuario.getNome()))
                    .email(cripto.descriptografar(usuario.getEmail()))
                    .build();

            usuariosDto.add(usuarioDto);
        }

        return usuariosDto;
    }

    public UsuarioDto findById(long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        return UsuarioDto.builder()
                .nome(cripto.descriptografar(usuario.get().getNome()))
                .email(cripto.descriptografar(usuario.get().getEmail()))
                .build();
    }

    public void addUsuario(UsuarioForm usuarioform){
        var usuario = Usuario.builder()
                .nome(cripto.criptografar(usuarioform.getNome()))
                .email(cripto.criptografar(usuarioform.getEmail()))
                .build();

        usuarioService.save(usuario);

    }

    public void deleteUsuario( UsuarioForm usuarioForm){
        var usuario = usuarioService.findByEmail(cripto.criptografar(usuarioForm.getEmail()));

        usuarioService.delete(usuario);
    }

}

package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.StatusTopico;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.modelo.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TopicoController {

    @RequestMapping("/topicos")
    public List<Topico> listaTopicos(){
        var topico = new Topico(null, "topico", "mensagem", LocalDateTime.now(), StatusTopico.NAO_RESPONDIDO,
                new Usuario(null, "autor", null, null), new Curso(null, "curso", null), null);
        var topicos = new ArrayList<Topico>();
        topicos.add(topico);

        return topicos;
    }
}

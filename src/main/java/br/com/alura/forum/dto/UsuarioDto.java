package br.com.alura.forum.dto;

import br.com.alura.forum.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor@NoArgsConstructor
@Builder
public class UsuarioDto {
    private String nome;
    private String email;

}

package br.com.alura.forum.services;

import br.com.alura.forum.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioService extends JpaRepository<Usuario, Long> {
}

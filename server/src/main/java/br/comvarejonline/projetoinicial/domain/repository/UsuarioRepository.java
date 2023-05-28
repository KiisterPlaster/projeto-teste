package br.comvarejonline.projetoinicial.domain.repository;

import br.comvarejonline.projetoinicial.domain.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}

package br.comvarejonline.projetoinicial.domain.repository;

import br.comvarejonline.projetoinicial.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

//    Page <User> findByAll(Pageable page);
    
}

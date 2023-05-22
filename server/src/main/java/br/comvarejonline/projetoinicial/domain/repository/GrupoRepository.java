package br.comvarejonline.projetoinicial.domain.repository;

import br.comvarejonline.projetoinicial.domain.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    
}

package br.comvarejonline.projetoinicial.domain.repository;

import br.comvarejonline.projetoinicial.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
    
}

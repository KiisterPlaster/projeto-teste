package br.comvarejonline.projetoinicial.domain.repository;

import br.comvarejonline.projetoinicial.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    
}

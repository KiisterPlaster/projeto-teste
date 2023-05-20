package br.comvarejonline.projetoinicial.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movimentacao {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_de_movimento")
    private TipoMovimento tipoMovimento = TipoMovimento.SALDO_INICIAL;

    @Column(nullable = false)
    private Integer quantidade;

    @CreationTimestamp
    private OffsetDateTime data;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false)
    private String documento;
}

package br.com.nicolas.services.scheduler.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraRegistro;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraExecucao;

    @Column(nullable = false, length = 50)
    private String idServico;

    @Column(nullable = false, length = 100)
    private String urlOrigem;

    @Column(nullable = false, length = 100)
    private String urlDestino;
}

package br.com.nicolas.services.scheduler.model.repository;

import br.com.nicolas.services.scheduler.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> getById(@Param("id") String id);
    List<Job> getByDataHoraRegistro(@Param("dataHora") Date dataHoraRegistro);

}

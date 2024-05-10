package com.ceica.padel.Repository;

import com.ceica.padel.Model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HistoricoRepository extends JpaRepository<Historico, Integer> {
    List<Historico> findAllByIdusuario(Integer idusuario);

    List<Historico> findAllByFechaAndPista(LocalDate fecha, String pista);
}

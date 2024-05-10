package com.ceica.padel.Repository;

import com.ceica.padel.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findAllByFechaAndIdpista(LocalDate fecha, Integer idpista);

}

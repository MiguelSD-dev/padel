package com.ceica.padel.Repository;

import com.ceica.padel.Model.Reserva;
import com.ceica.padel.Model.UsuarioReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UsuarioReservaRepository extends JpaRepository<UsuarioReserva, Integer> {
 List<UsuarioReserva> findAllByIdreserva(Integer idreserva);
}

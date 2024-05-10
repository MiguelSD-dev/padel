package com.ceica.padel.Repository;

import com.ceica.padel.Model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    Horario findHorarioByHora(String hora);
}

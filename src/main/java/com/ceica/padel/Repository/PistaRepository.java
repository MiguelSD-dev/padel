package com.ceica.padel.Repository;

import com.ceica.padel.Model.Pista;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PistaRepository extends JpaRepository<Pista, Integer> {

    Pista findPistaByIdpista(Integer idpista);

}

package com.ceica.padel.Repository;

import com.ceica.padel.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByDniAndClave(String dni, String clave);
}

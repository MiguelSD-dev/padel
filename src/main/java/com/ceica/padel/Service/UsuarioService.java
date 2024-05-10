package com.ceica.padel.Service;

import com.ceica.padel.Model.Usuario;
import com.ceica.padel.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario login(String dni, String clave){
        return usuarioRepository.findByDniAndClave(dni, clave);
    }

    public Boolean register(String nombre, String dni, String clave){
        Usuario usuario = new Usuario(nombre, clave, dni);
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception excepcion){
            return false;
        }


    }

}

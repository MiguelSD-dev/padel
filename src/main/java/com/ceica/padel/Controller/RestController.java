package com.ceica.padel.Controller;


import com.ceica.padel.Model.Horario;
import com.ceica.padel.Service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final ReservaController reservaController;

    private final ReservaService reservaService;

    @Autowired
    public RestController(ReservaController reservaController,
                          ReservaService reservaService){
        this.reservaController = reservaController;
        this.reservaService = reservaService;
    }

    @GetMapping("/isLogged")
    public Boolean isLogged() {
        return reservaController.getUserLogged() != null;
    }

    @GetMapping("/horarios")
    public List<String> horarios( @RequestParam Integer idpìsta, @RequestParam LocalDate fecha) {
        return reservaService.getHorariosPlazaByIdPista(idpìsta, fecha);
    }
}

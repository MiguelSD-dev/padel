package com.ceica.padel.Controller;

import com.ceica.padel.Model.Historico;
import com.ceica.padel.Model.Horario;
import com.ceica.padel.Model.Pista;
import com.ceica.padel.Model.Usuario;
import com.ceica.padel.Service.ReservaService;
import com.ceica.padel.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservaController {

    private final ReservaService reservaService;

    private final UsuarioService usuarioService;

    private Usuario userLogged;

    @Autowired
    public ReservaController(ReservaService reservaService, UsuarioService usuarioService) {
        this.reservaService = reservaService;
        this.usuarioService = usuarioService;
    }

    public Usuario getUserLogged() {
        return userLogged;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        userLogged=null;
        return "login";
    }

    @GetMapping("/pista")
    public String pista(Model model){
        model.addAttribute("listaPistas", reservaService.getAllPistas());
        return "pista";
    }

    @GetMapping("/plaza")
    public String plaza(Model model){
        model.addAttribute("listaPistas", reservaService.getAllPistas());
        return "plaza";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam String dni, @RequestParam String clave) {
        Usuario usuario = usuarioService.login(dni, clave);
        if (usuario != null) {
            userLogged = usuario;
            return "home";
        } else {
            model.addAttribute("error", "DNI o clave incorrecta");
            return "login";
        }
    }

    @PostMapping("/register")
    public String login(Model model, @RequestParam String nombre, @RequestParam String dni, @RequestParam String clave) {
        if (usuarioService.register(nombre, dni, clave))
            return "login";
        else {
            model.addAttribute("error", "Ha ocurrido un erro en el registro");
            return "register";
        }
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/reservaPista")
    public String horariosBypista(Model model, @RequestParam int idpista, @RequestParam Optional<LocalDate> fecha) {
        List<String> horarioList;
        LocalDate fechaActual = fecha.orElse(LocalDate.now());
        horarioList = reservaService.getHorariosCompletoByIdPista(idpista, fechaActual);
        model.addAttribute("horarios", horarioList);
        model.addAttribute("idpista", idpista);
        model.addAttribute("fecha", fechaActual);
        return "reservaPista";
    }

    @GetMapping("/reservaPlaza")
    public String horariosByplaza(Model model, @RequestParam int idpista, @RequestParam Optional<LocalDate> fecha) {
        List<String> horarioList;
        LocalDate fechaActual = fecha.orElse(LocalDate.now());
        horarioList = reservaService.getHorariosPlazaByIdPista(idpista, fechaActual);
        model.addAttribute("horarios", horarioList);
        model.addAttribute("idpista", idpista);
        model.addAttribute("fecha", fechaActual);
        return "reservaPlaza";
    }

    @PostMapping("/save")
    public String save(@RequestParam LocalDate fecha, @RequestParam String hora, @RequestParam Integer idpista){

        if (reservaService.save(fecha, reservaService.getHorarioByHora(hora).getIdhorario(), idpista, userLogged))
            return "home";
        else
            return "reservaPlaza";
    }

    @PostMapping("/saveComplete")
    public String saveComplete(@RequestParam LocalDate fecha, @RequestParam String hora, @RequestParam Integer idpista){

        if (reservaService.saveComplete(fecha, reservaService.getHorarioByHora(hora).getIdhorario(), idpista, userLogged))
            return "home";
        else
            return "reservaPista";
    }

    @GetMapping("/historico")
    public String historico(Model model){
        List<Historico> historico = reservaService.getHistoricoByIdusuario(userLogged.getIdusuario());
        model.addAttribute("historico", historico);
        return "historico";
    }
}

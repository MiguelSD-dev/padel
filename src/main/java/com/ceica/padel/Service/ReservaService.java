package com.ceica.padel.Service;

import com.ceica.padel.Model.*;
import com.ceica.padel.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ReservaService {

    private final HorarioRepository horarioRepository;

    private final ReservaRepository reservaRepository;

    private final UsuarioReservaRepository usuarioReservaRepository;

    private final HistoricoRepository historicoRepository;

    private final PistaRepository pistaRepository;


    @Autowired
    public ReservaService(HorarioRepository horarioRepository,
                          ReservaRepository reservaRepository,
                          UsuarioReservaRepository usuarioReservaRepository,
                          HistoricoRepository historicoRepository,
                          PistaRepository pistaRepository) {
        this.horarioRepository = horarioRepository;
        this.reservaRepository = reservaRepository;
        this.usuarioReservaRepository = usuarioReservaRepository;
        this.historicoRepository = historicoRepository;
        this.pistaRepository = pistaRepository;
    }

    public List<String> getHorariosCompletoByIdPista(int idpista, LocalDate fecha) {
        List<Reserva> reservaList = reservaRepository.findAllByFechaAndIdpista(fecha, idpista);
        List<String> availableHorarios = new ArrayList<>();
        if (reservaList.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                availableHorarios.add("1" + i + ":00");
            }
            for (int i = 0; i < 3; i++) {
                availableHorarios.add("2" + i + ":00");
            }
            return availableHorarios;
        }
        List<Horario> horarioList = horarioRepository.findAll();
        List<Integer> reservaTimes = new ArrayList<>();
        for (Reserva reserva : reservaList)
            reservaTimes.add(reserva.getIdhorario());
        horarioList.removeIf(horario -> reservaTimes.contains(horario.getIdhorario()));
        for (Horario horario : horarioList)
            availableHorarios.add(horario.getHora());
        return availableHorarios;
    }

    public List<String> getHorariosPlazaByIdPista(int idpista, LocalDate fecha) {
        List<Historico> historicoList = historicoRepository.findAllByFechaAndPista(fecha, pistaRepository.findPistaByIdpista(idpista).getNombre());
        List<String> availableHorarios = new ArrayList<>();
        List<Horario> horarioList = horarioRepository.findAll();
        for (Horario horario : horarioList){
            availableHorarios.add(horario.getHora());
        }
        Map<String, Integer> map = new HashMap<>();
        for (Historico historico : historicoList){
            if (map.containsKey(historico.getHora())) {
                map.put(historico.getHora(), map.get(historico.getHora()) + 1);
            } else {
                map.put(historico.getHora(), 1);
            }
        }
        for (Map.Entry<String, Integer> clave : map.entrySet()) {
            if (clave.getValue() == 4) {
                availableHorarios.remove(clave.getKey());
            }
        }
        return availableHorarios;
    }

    public boolean save(LocalDate fecha, Integer idHorario, Integer idPista, Usuario userLogged) {
        try {
            Reserva reserva = reservaRepository.save(new Reserva(LocalDateTime.now(), fecha, idHorario, idPista));
            usuarioReservaRepository.save(new UsuarioReserva(userLogged.getIdusuario(), reserva.getIdreserva(), false));
            return true;
        } catch (Exception excepcion){
            return false;
        }
    }

    public boolean saveComplete(LocalDate fecha, Integer idHorario, Integer idPista, Usuario userLogged) {
        try {
            Reserva reserva = reservaRepository.save(new Reserva(LocalDateTime.now(), fecha, idHorario, idPista));
            for (int i = 0; i < 4; i++) {
                usuarioReservaRepository.save(new UsuarioReserva(userLogged.getIdusuario(), reserva.getIdreserva(), false));
            }
            return true;
        } catch (Exception excepcion){
            return false;
        }
    }

    public List<Historico> getHistoricoByIdusuario(Integer idusuario) {
        List<Historico> historicos = historicoRepository.findAllByIdusuario(idusuario);
        Set<LocalDate> fechas = new HashSet<>();
        List<Historico> historicosSinFechasRepetidas = new ArrayList<>();
        for (Historico historico : historicos) {
            LocalDate fecha = historico.getFecha();
            if (!fechas.contains(fecha)) {
                historicosSinFechasRepetidas.add(historico);
                fechas.add(fecha);
            }
        }
        return historicosSinFechasRepetidas;
    }

    public List<Pista> getAllPistas(){
        return pistaRepository.findAll();
    }

    public Horario getHorarioByHora(String hora){
        return horarioRepository.findHorarioByHora(hora);
    }

    public List<Horario> getAllHorarios() {
        return horarioRepository.findAll();
    }
}

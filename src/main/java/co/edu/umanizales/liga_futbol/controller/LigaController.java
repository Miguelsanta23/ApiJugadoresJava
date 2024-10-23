package co.edu.umanizales.liga_futbol.controller;


import co.edu.umanizales.liga_futbol.model.Equipo;
import co.edu.umanizales.liga_futbol.model.Jugador;
import co.edu.umanizales.liga_futbol.service.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/liga")
public class LigaController {
    @Autowired
    private LigaService ligaService;

    @GetMapping("/equipos")
    public List<Equipo> listarEquipos() {
        return ligaService.listarEquipos();
    }

    @PostMapping("/jugador")
    public void agregarJugador(@RequestParam String nombreEquipo, @RequestBody Jugador jugador) {
        ligaService.agregarJugador(nombreEquipo, jugador);
    }

    @GetMapping("/promedio-edad")
    public double obtenerPromedioEdad(@RequestParam String nombreEquipo) {
        return ligaService.obtenerPromedioEdad(nombreEquipo);
    }

    @GetMapping("/goleadores")
    public Map<String, Jugador> obtenerGoleadoresPorEquipo() {
        return ligaService.obtenerGoleadoresPorEquipo();
    }

    @GetMapping("/jugadores-por-posicion")
    public Map<String, List<Jugador>> filtrarJugadoresPorPosicion(@RequestParam String nombreEquipo) {
        return ligaService.filtrarJugadoresPorPosicion(nombreEquipo);
    }
}


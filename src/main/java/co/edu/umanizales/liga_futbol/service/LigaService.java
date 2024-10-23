package co.edu.umanizales.liga_futbol.service;

import co.edu.umanizales.liga_futbol.model.Entrenador;
import co.edu.umanizales.liga_futbol.model.Equipo;
import co.edu.umanizales.liga_futbol.model.Jugador;
import co.edu.umanizales.liga_futbol.model.Liga;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LigaService {
    private Liga liga;

    public LigaService() {
        this.liga = new Liga("Liga de Fútbol");
        inicializarLiga();
    }

    private void inicializarLiga() {
        // Aquí se inicializarían los 10 equipos con sus entrenadores y jugadores
        // Por brevedad, solo se muestra el ejemplo del Barcelona
        Entrenador entrenadorBarcelona = new Entrenador("Hansi", "Flick", 58, 20);
        Equipo barcelona = new Equipo("Barcelona", entrenadorBarcelona);

        List<Jugador> jugadoresBarcelona = Arrays.asList(
                new Jugador("Marc-André", "ter Stegen", 31, "Portero", 0),
                new Jugador("Alejandro", "Balde", 20, "Defensa", 2),
                new Jugador("Ronald", "Araújo", 24, "Defensa", 2),
                new Jugador("Iñigo", "Martínez", 32, "Defensa", 2),
                new Jugador("Jules", "Koundé", 25, "Defensa", 2),
                new Jugador("Pablo", "Gavi", 19, "Mediocampista", 8),
                new Jugador("Pedri", "González", 20, "Mediocampista", 8),
                new Jugador("Frenkie", "de Jong", 26, "Mediocampista", 8),
                new Jugador("Lamine", "Yamal", 16, "Delantero", 20),
                new Jugador("Robert", "Lewandowski", 35, "Delantero", 35),
                new Jugador("Raphinha", "", 26, "Delantero", 20),
                new Jugador("Iñaki", "Peña", 24, "Portero", 0)
        );
        barcelona.setJugadores(jugadoresBarcelona);
        liga.getEquipos().add(barcelona);


        Entrenador entrenadorRealMadrid = new Entrenador("Carlo", "Ancelotti", 65, 20);
        Equipo realMadrid = new Equipo("RealMadrid", entrenadorRealMadrid);

        List<Jugador> jugadoresRealMadrid = Arrays.asList(
                new Jugador("Thibaut", "Courtois", 32, "Portero", 0),
                new Jugador("Eder", "Militao", 26, "Defensa", 2),
                new Jugador("Antonio", "Rudiger", 31, "Defensa", 2),
                new Jugador("Ferland", "Mendy", 29, "Defensa", 2),
                new Jugador("Daniel", "Carvajal", 25, "Defensa", 2),
                new Jugador("Federico", "Valverde", 26, "Mediocampista", 8),
                new Jugador("Eduardo", "Camavinga", 21, "Mediocampista", 8),
                new Jugador("Jude", "Bellingham", 21, "Mediocampista", 8),
                new Jugador("Kylian", "Mbappe", 25, "Delantero", 30),
                new Jugador("Vinicius", "Junior", 24, "Delantero", 20),
                new Jugador("Rodrygo", "Goes", 23, "Delantero", 20),
                new Jugador("Andriy", "Lunin", 25, "Portero", 0)
        );
        realMadrid.setJugadores(jugadoresRealMadrid);
        liga.getEquipos().add(realMadrid);

    }

    public List<Equipo> listarEquipos() {
        return liga.getEquipos();
    }

    public void agregarJugador(String nombreEquipo, Jugador jugador) {
        for (Equipo equipo : liga.getEquipos()) {
            if (equipo.getNombre().equals(nombreEquipo) && equipo.getJugadores().size() < 12) {
                equipo.getJugadores().add(jugador);
                break;
            }
        }
    }

    public double obtenerPromedioEdad(String nombreEquipo) {
        for (Equipo equipo : liga.getEquipos()) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                return equipo.getJugadores().stream()
                        .mapToInt(Jugador::getEdad)
                        .average()
                        .orElse(0);
            }
        }
        return 0;
    }

    public Map<String, Jugador> obtenerGoleadoresPorEquipo() {
        Map<String, Jugador> goleadores = new HashMap<>();
        for (Equipo equipo : liga.getEquipos()) {
            goleadores.put(equipo.getNombre(),
                    equipo.getJugadores().stream()
                            .max(Comparator.comparingInt(Jugador::getGoles))
                            .orElse(null));
        }
        return goleadores;
    }

    public Map<String, List<Jugador>> filtrarJugadoresPorPosicion(String nombreEquipo) {
        for (Equipo equipo : liga.getEquipos()) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                Map<String, List<Jugador>> jugadoresPorPosicion = new HashMap<>();
                jugadoresPorPosicion.put("Portero", new ArrayList<>());
                jugadoresPorPosicion.put("Defensa", new ArrayList<>());
                jugadoresPorPosicion.put("Mediocampista", new ArrayList<>());
                jugadoresPorPosicion.put("Delantero", new ArrayList<>());

                for (Jugador jugador : equipo.getJugadores()) {
                    jugadoresPorPosicion.get(jugador.getPosicion()).add(jugador);
                }
                return jugadoresPorPosicion;
            }
        }
        return new HashMap<>();
    }
}
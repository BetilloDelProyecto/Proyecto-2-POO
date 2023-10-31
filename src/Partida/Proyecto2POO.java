package Partida;

import Jugador.*;

public class Proyecto2POO{
     public static void main(String[] args) {
        Jugador beto = new Jugador(new FrameLobby());
        Partida p1 = new Partida(beto);
        p1.jugadores.add(new Jugador(new FrameLobby()));
        p1.jugadores.add(new Jugador(new FrameLobby()));
        p1.repartirFichas();
        p1.imprimirFichasPorJugador();
        System.out.println("Tamanno bote: " + p1.bote.size());
    }
}

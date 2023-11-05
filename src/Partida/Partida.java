
package Partida;

import Jugador.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Partida implements Serializable {
    transient ArrayList<Ficha> mesa;
    transient ArrayList<Ficha> bote;
    Jugador host;
    transient ArrayList<ThreadJugador> threadsJugadores;
    transient ArrayList<Jugador> jugadores;
    transient Random rand = new Random();
    
    public Partida(Jugador host) {
        this.host = host;
        this.bote = new ArrayList<>();
        this.mesa = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.jugadores.add(host);
        this.threadsJugadores = new ArrayList<>();
        generarFichas(true);
        generarFichas(false);
    }
    
    public void generarFichas(boolean flag){
        if (flag) 
            bote.add(new Ficha(0, 0, true));
        else
            bote.add(new Ficha(0, 2, true));
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                bote.add(new Ficha(i, j, false));
            }
        }
    }
    
    public void imprimirFichasPorJugador(){
        System.out.println("Fichas: \n");
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador get = jugadores.get(i);
            System.out.println("Mano del jugador: " + i);
            for (int j = 0; j < get.getFichas().size(); j++) {
                Ficha ficha = get.getFichas().get(j);
                System.out.println(ficha);
            }
        }
    }
    
    public void repartirFichas(){
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador get = jugadores.get(i);
            for (int j = 0; j < 14; j++) {
                int randomNumber = rand.nextInt(bote.size());
                get.getFichas().add(bote.remove(randomNumber));
            }
            
        }
    }

    public Jugador getHost() {
        return host;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    
    
}

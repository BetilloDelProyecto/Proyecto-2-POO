
package Partida;

import Jugador.*;
import MainServer.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Partida implements Serializable {
    ArrayList<Ficha> mesa;
    ArrayList<Ficha> bote;
    String host;
    ArrayList<ThreadMainServer> threadsInLobby;
    //ArrayList<Jugador> jugadores;
    Random rand = new Random();
    
    public Partida(String host, ThreadMainServer threadHost) {
        this.host = host;
        this.bote = new ArrayList<>();
        this.mesa = new ArrayList<>();
        this.threadsInLobby = new ArrayList<>();
        threadsInLobby.add(threadHost);
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
    
   
    public ArrayList<Ficha> repartirFichas(){
        ArrayList <Ficha> mano = new ArrayList<>();
        for (int j = 0; j < 14; j++){
            int randomNumber = rand.nextInt(bote.size());
            mano.add(bote.remove(randomNumber));
        }
        return mano;
    }

    public String getHost() {
        return host;
    }

    public ArrayList<ThreadMainServer> getThreadsInLobby() {
        return threadsInLobby;
    }
    
    
    
}


package Partida;

import Jugador.*;
import MainServer.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Partida implements Serializable {
    ArrayList<ArrayList<Ficha>> mesa;
    ArrayList<Ficha> bote;
    ArrayList<ThreadMainServer> threadsInLobby;
    String host;
    Random rand = new Random();
    int turno;
    public Partida(String host, ThreadMainServer threadHost) {
        this.host = host;
        this.bote = new ArrayList<>();
        this.mesa = new ArrayList<>();
        this.threadsInLobby = new ArrayList<>();
        threadsInLobby.add(threadHost);
        generarFichas(true);
        generarFichas(false);
        this.turno = 0;
    }
    
    public int getTurno(){
        return turno%threadsInLobby.size();
    }
    
    public void sigTurno(){
        turno++;
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
    
    
    public Ficha tomarFichaBote(){
        if(bote.size() > 0 ){
            int randomNumber = rand.nextInt(bote.size());
            return bote.remove(randomNumber);
        }return null;
    }
    
    public void actualizarTurno(){
        for (int i = 0; i < threadsInLobby.size(); i++) {
            ThreadMainServer get = threadsInLobby.get(i);
            try {
                get.getSalida().writeInt(100);
                if(getTurno() == i){
                    get.getSalida().writeBoolean(true);
                }else{
                    get.getSalida().writeBoolean(false);
                }
            } catch (IOException ex) {
                System.out.println("ERROR EN ACTUALIZAR TURNOS");
            }
        }
        
    }
    
    
}


package Partida;

import MainServer.*;
import java.io.*;
import java.util.*;

public class Partida implements Serializable {
    //ARRAYS
    ArrayList<ArrayList<Ficha>> mesa = new ArrayList<>();
    ArrayList<Ficha> bote = new ArrayList<>();
    ArrayList<ThreadMainServer> threadsInLobby = new ArrayList<>();
    //STRING
    String host;
    //STUFF
    Random rand = new Random();
    //INTs
    int turno;
    
    //-------------------------------CONSTRUCTOR-------------------------------
    public Partida(String host, ThreadMainServer threadHost) {
        this.host = host;
        threadsInLobby.add(threadHost);
        generarFichas(true);
        generarFichas(false);
        this.turno = 0;
    }
   
    //-------------------------------GET & SET----------------------------------
    public String getHost() {
        return host;
    }

    public ArrayList<ThreadMainServer> getThreadsInLobby() {
        return threadsInLobby;
    }
    
    public int getTurno(){
        return turno%threadsInLobby.size();
    }
    public void sigTurno(){
        turno++;
    }

    public ArrayList<ArrayList<Ficha>> getMesa() {
        return mesa;
    }
    
    //-------------------------------GET & SET----------------------------------
    
    private void generarFichas(boolean flag){
        if (flag) {
             Ficha com = new Ficha(0, 0, true);
             bote.add(com);
        }else{
            Ficha com = new Ficha(0, 2, true);
            bote.add(com);
        }
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                bote.add(new Ficha(i, j, false));
            }
        }
    }
    
    public void imprimirFichas(){
        for (int i = 0; i < bote.size(); i++) 
            System.out.println(bote.get(i));
    }
   
    public ArrayList<Ficha> repartirFichas(){
        ArrayList <Ficha> mano = new ArrayList<>();
        for (int j = 0; j < 14; j++){
            int randomNumber = rand.nextInt(bote.size());
            mano.add(bote.remove(randomNumber));
        }
        return mano;
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

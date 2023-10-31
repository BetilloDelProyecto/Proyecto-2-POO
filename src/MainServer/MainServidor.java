package MainServer;

import Jugador.*;
import MainServer.*;
import Partida.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class MainServidor{
    ArrayList<Socket> jugadores;
    ArrayList<ThreadMainServer>  threadsMainServer;
    ArrayList<String> nombres;
    ArrayList<Partida> partidas;
    int cont;
    
    //ATRIBUTOS PROPIOS//
    ServerSocket servidorMain;
    FrameServidorMain ventana;
    ThreadAceptarClientes threadAceptarClientes;
    
    //-------------------------------------------CONSTRUCTOR----------------
    public MainServidor(FrameServidorMain ventana) {
        this.ventana = ventana;
        this.jugadores = new ArrayList<>();
        this.threadsMainServer = new ArrayList<>();
        this.nombres = new ArrayList<>();
        
        this.threadAceptarClientes = new ThreadAceptarClientes(this);
        this.partidas = new ArrayList<>();
    }
    
    //-------------------------------------------GETTER & SETTER----------------

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }
  
    
    //-------------------------------------------METHODS----------------
    public void runServer(){
        try{
            servidorMain = new ServerSocket(1025);
            ventana.mostrar("Servidor Main Activo");
            threadAceptarClientes.start();
        }catch(IOException e){
            
        }
    }
    
    boolean existeNombre(String nombre){
        for (int i = 0; i < nombres.size(); i++) {
            String get = nombres.get(i);
            if (get.equals(nombre))
                return true;
        }
        return false;
    }
}

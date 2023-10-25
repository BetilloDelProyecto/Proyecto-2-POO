package MainServer;

import JuegoServidor.FrameWaitingPlayers;
import Jugador.*;
import MainServer.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class MainServidor {
    ArrayList<FrameWaitingPlayers> servidores;
    ArrayList<Socket> jugadores;
    ArrayList<ThreadMainServer>  threadsMainServer;
    ArrayList<String> nombres;
    int cont;
    
    //ATRIBUTOS PROPIOS//
    ServerSocket servidorMain;
    FrameServidorMain ventana;
    ThreadAceptarClientes threadAceptarClientes;
    
    //-------------------------------------------CONSTRUCTOR----------------
    public MainServidor(FrameServidorMain ventana) {
        this.ventana = ventana;
        this.servidores = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.threadsMainServer = new ArrayList<>();
        this.nombres = new ArrayList<>();
        this.cont = 1025;
        this.threadAceptarClientes = new ThreadAceptarClientes(this);
    }
    
    //-------------------------------------------GETTER & SETTER----------------
    public ArrayList<FrameWaitingPlayers> getServidores() {
        return servidores;
    }
    
    //-------------------------------------------GETTER & SETTER----------------
    
    
    //-------------------------------------------METHODS----------------
    public void runServer(){
        try{
            servidorMain = new ServerSocket(cont++);
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

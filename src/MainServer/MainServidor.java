package MainServer;

import Jugador.ThreadJugador;
import MainServer.FrameServidorMain;
import java.io.IOException;
import java.net.*;
import java.util.*;
import proyecto2poo.JuegoServidor;

public class MainServidor {
    ArrayList<JuegoServidor> servidores;
    ArrayList<Socket> jugadores;
    ArrayList<ThreadMainServer>  threadsServer;
    int cont;
    ServerSocket servidorMain;
    FrameServidorMain ventana;
    ThreadAceptarClientes threadAceptarClientes;
    
    //-------------------------------------------CONSTRUCTOR----------------
    public MainServidor(FrameServidorMain ventana) {
        this.ventana = ventana;
        this.servidores = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.threadsServer = new ArrayList<>();
        this.cont = 1025;
        this.threadAceptarClientes = new ThreadAceptarClientes(this);
    }
    
    //-------------------------------------------GETTER & SETTER----------------
    public ArrayList<JuegoServidor> getServidores() {
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
}

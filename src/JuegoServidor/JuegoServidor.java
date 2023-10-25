package JuegoServidor;

import Jugador.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class JuegoServidor {
    FrameWaitingPlayers ventana; // manejo de la ventana
    ServerSocket localServidor; // es el server socket de los jugadores
    ArrayList<Socket> jugadores;
    ArrayList<ThreadJuegoServer> threadsJuegoServer;
    ThreadAceptarClientesJuego threadAceptarClientesJuego;
    
    //-------------------------------------------CONSTRUCTOR----------------
    public JuegoServidor(FrameWaitingPlayers ventana) {
        this.ventana = ventana;
        this.threadAceptarClientesJuego = new ThreadAceptarClientesJuego(this);
    }

    //-------------------------------------------GETTER & SETTER----------------
//    public void setMainServidor(MainServidor mainServidor) {
//        this.mainServidor = mainServidor;
//    }
//    
//    public MainServidor getMainServidor() {
//        return mainServidor;
//    }
    //-------------------------------------------GETTER & SETTER----------------
    
    
    public void runServer(int puerto){
        try{
            localServidor = new ServerSocket(puerto);
            threadAceptarClientesJuego.start();
        }catch(IOException e){
            
        }
    }
    
    
    
    
}

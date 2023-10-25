package proyecto2poo;

import java.io.*;
import java.net.*;

public class JuegoServidor {
    FrameWaitingPlayers ventana; // manejo de la ventana
    MainServidor mainServidor;// conexion al main servidor
    ServerSocket localServidor; // es el server socket de los jugadores
    //ArrayList<ThreadJugando> jugadores  threads de las personas en la partida
    
    
    //-------------------------------------------CONSTRUCTOR----------------
    public JuegoServidor(FrameWaitingPlayers ventana) {
        this.ventana = ventana;
    }

    //-------------------------------------------GETTER & SETTER----------------
    public void setMainServidor(MainServidor mainServidor) {
        this.mainServidor = mainServidor;
    }
    
    public MainServidor getMainServidor() {
        return mainServidor;
    }
    //-------------------------------------------GETTER & SETTER----------------
    
    
    public void runServer(int puerto){
        try{
            localServidor = new ServerSocket(puerto);
        }catch(IOException e){
            
        }
    }
    
    
    
    
}

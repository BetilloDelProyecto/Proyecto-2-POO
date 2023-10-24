package MainServer;

import MainServer.FrameServidorMain;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto2poo.JuegoServidor;

public class MainServidor {
    ArrayList<JuegoServidor> servidores;
    ArrayList<Socket> clientes;
    int cont;
    ServerSocket servidorMain;
    FrameServidorMain ventana;
    ThreadAceptarClientes threadAceptarClientes;
    
    //-------------------------------------------CONSTRUCTOR----------------
    public MainServidor(FrameServidorMain ventana) {
        this.ventana = ventana;
        this.servidores = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.cont = 1025;
        threadAceptarClientes = new ThreadAceptarClientes(this);
        
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

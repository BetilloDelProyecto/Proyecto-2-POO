package MainServer;

import Partida.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class MainServidor{
    //ARRAYS
    private ArrayList<Socket> jugadores = new ArrayList<>();
    private ArrayList<ThreadMainServer>  threadsMainServer = new ArrayList<>();
    private ArrayList<String> nombres = new ArrayList<>();
    private ArrayList<Partida> partidas = new ArrayList<>();
    //INTs
    private int cont;
    
    //ATRIBUTOS PROPIOS//
    private ServerSocket servidorMain;
    private FrameServidorMain ventana;
    private ThreadAceptarClientes threadAceptarClientes;
    
    //-------------------------------------------CONSTRUCTOR----------------
    public MainServidor(FrameServidorMain ventana) {
        this.ventana = ventana;
        this.threadAceptarClientes = new ThreadAceptarClientes(this);
    }
    
    //-------------------------------------------GETTER & SETTER----------------

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public ArrayList<Socket> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Socket> jugadores) {
        this.jugadores = jugadores;
    }

    public ServerSocket getServidorMain() {
        return servidorMain;
    }

    public void setServidorMain(ServerSocket servidorMain) {
        this.servidorMain = servidorMain;
    }
    
    

    public ArrayList<ThreadMainServer> getThreadsMainServer() {
        return threadsMainServer;
    }

    public void setThreadsMainServer(ArrayList<ThreadMainServer> threadsMainServer) {
        this.threadsMainServer = threadsMainServer;
    }

    public ArrayList<String> getNombres() {
        return nombres;
    }

    public void setNombres(ArrayList<String> nombres) {
        this.nombres = nombres;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public FrameServidorMain getVentana() {
        return ventana;
    }

    public void setVentana(FrameServidorMain ventana) {
        this.ventana = ventana;
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

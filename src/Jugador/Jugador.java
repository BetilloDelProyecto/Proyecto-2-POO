package Jugador;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Jugador {
    public static String IP_SERVER = "localhost"; //IP del Servidor
    DataInputStream entrada = null;//leer comunicacion
    DataOutputStream salida = null;//escribir comunicacion
    Socket cliente = null;//para la comunicacion
    private String nomCliente;// nombre del user
    FrameLobby lobby;
    private boolean host = false;

    
    
    //------------------------------------------------CONSTRUCTOR
    public Jugador(FrameLobby lobby) {
        this.lobby = lobby;
    }

    //----------------------------------------GETTER & SETTER
    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public boolean getHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }
    
    
    
    
    public void conexion(int puerto) throws IOException{
        try {
            cliente = new Socket(IP_SERVER, puerto);
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            
        } catch (IOException e) {
            System.out.println("\tEl servidor no esta levantado");
            System.out.println("\t=============================");
        }
        new ThreadJugador(entrada, salida, lobby).start();
        
   }
    
    
    
    
    
}

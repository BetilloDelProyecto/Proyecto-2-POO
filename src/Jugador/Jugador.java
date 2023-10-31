package Jugador;

import Partida.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;

public class Jugador implements Serializable {
    public static String IP_SERVER = "localhost"; //IP del Servidor
    transient DataInputStream entrada = null;//leer comunicacion
    transient DataOutputStream salida = null;//escribir comunicacion
    transient ObjectOutputStream salidaO = null;//Para enviar comunicacion
    transient ObjectInputStream entradaO = null;//Para leer comunicacion
   
    transient Socket cliente = null;//para la comunicacion
    private String nomCliente;// nombre del user
    FrameLobby lobby;
    private boolean host = false;
    private Partida partida;
    transient private PartidaGUI ventanaPartida;
    private ArrayList<Ficha> fichas;
    
    
    //------------------------------------------------CONSTRUCTOR
    public Jugador(FrameLobby lobby) {
        this.lobby = lobby;
        this.partida = null;
        this.ventanaPartida = null;
        this.fichas = new ArrayList<>();
        this.ventanaPartida = null;
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

    public PartidaGUI getVentanaPartida() {
        return ventanaPartida;
    }

    public void setVentanaPartida(PartidaGUI ventanaPartida) {
        this.ventanaPartida = ventanaPartida;
    }
    
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setHost(boolean host) {
        this.host = host;
    }
    
    public void conexion(int puerto) throws IOException{
        try {
            cliente = new Socket(IP_SERVER, puerto);
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            System.out.println("Licho");
            try{
                salidaO = new ObjectOutputStream(cliente.getOutputStream());//comunic
                entradaO = new ObjectInputStream(cliente.getInputStream());//comunic
                
            }  catch (IOException e) {
                System.out.println("Licho 2");
            }
            System.out.println("Licho 3");
        } catch (IOException e) {
            System.out.println("\tEl servidor no esta levantado");
            System.out.println("\t=============================");
        }
        new ThreadJugador(entrada, salida, lobby, salidaO, entradaO).start();
        
   }
    
}

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

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    
    public void setHost(boolean host) {
        this.host = host;
    }
    
    public void refrescaNombresPartida(){
        int cont = 0;
        for (int i = 0; i < getPartida().getJugadores().size(); i++) {
           
            Jugador j = getPartida().getJugadores().get(i);
            if (cont==0 && j != this) {
                getVentanaPartida().getLblEnemigo1().setText(j.getNomCliente());
                cont++;
            }else if (cont==1 && j != this){
                getVentanaPartida().getLblEnemigo2().setText(j.getNomCliente());
                cont++;
            }else if (cont==2 && j != this)
                getVentanaPartida().getLblEnemigo2().setText(j.getNomCliente());
            
        }
    }
    
    public void conexion(int puerto) throws IOException{
        try {
            cliente = new Socket(IP_SERVER, puerto);
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            
            try{
                salidaO = new ObjectOutputStream(cliente.getOutputStream());//comunic
                entradaO = new ObjectInputStream(cliente.getInputStream());//comunic
                
            }  catch (IOException e) {
                System.out.println("No sirven los ObjectInputStream en Clase Jugador");
            }
           
        } catch (IOException e) {
            System.out.println("\tEl servidor no esta levantado");
            System.out.println("\t=============================");
        }
        new ThreadJugador(entrada, salida, lobby, salidaO, entradaO).start();
        
   }
    
}

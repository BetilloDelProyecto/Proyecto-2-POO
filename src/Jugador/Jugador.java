package Jugador;

import Partida.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;

public class Jugador implements Serializable {
    public static String IP_SERVER = "localhost"; //IP del Servidor
    private DataInputStream entrada = null;//leer comunicacion
    DataOutputStream salida = null;//escribir comunicacion
    private ObjectOutputStream salidaO = null;//Para enviar comunicacion
    private ObjectInputStream entradaO = null;//Para leer comunicacion
   
    private Socket cliente = null;//para la comunicacion
    private String nomCliente;// nombre del user
    private FrameLobby lobby;
    private boolean turno = false;
    private PartidaGUI ventanaPartida;
    private ArrayList<Ficha> fichas;
    private String hostPartida = "";
    
    ArrayList<Ficha> seleccionadas;
    //------------------------------------------------CONSTRUCTOR
    public Jugador(FrameLobby lobby) {
        this.lobby = lobby;
        this.seleccionadas = new ArrayList<>();
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

    

    public PartidaGUI getVentanaPartida() {
        return ventanaPartida;
    }

    public void setVentanaPartida(PartidaGUI ventanaPartida) {
        this.ventanaPartida = ventanaPartida;
    }
    
    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public String getHostPartida() {
        return hostPartida;
    }

    public void setHostPartida(String host) {
        this.hostPartida = host;
    }

    public DataInputStream getEntrada() {
        return entrada;
    }

    public DataOutputStream getSalida() {
        return salida;
    }

    public ObjectOutputStream getSalidaO() {
        return salidaO;
    }

    public ObjectInputStream getEntradaO() {
        return entradaO;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public ArrayList<Ficha> getSeleccionadas() {
        return seleccionadas;
    }

    public void setSeleccionadas(ArrayList<Ficha> seleccionadas) {
        this.seleccionadas = seleccionadas;
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
        new ThreadJugador(entrada, salida, lobby, salidaO, entradaO, this).start();
        
   }
    
   public void ordenarFichas(){
       for (int i = 0; i < seleccionadas.size()-1; i++) {
           for (int j = 0; j < seleccionadas.size()-1; j++) {
               Ficha ficha1 = seleccionadas.get(j);
               Ficha ficha2 = seleccionadas.get(j+1);
               if (ficha1.getNum() < ficha2.getNum()){
                   Ficha aux = ficha1;
                   ficha1 = ficha2;
                   ficha2 = aux;
               }
               
           }
       }
   }
   
   public boolean esEscalera(){
       ordenarFichas();
       if(seleccionadas.size()>= 3){
           for (int i = 0; i < seleccionadas.size()-1; i++) {
                Ficha ficha = seleccionadas.get(i);
                Ficha ficha2 = seleccionadas.get(i+1);
                if((ficha2.getNum()-1 != ficha.getNum() || ficha.getColor() != ficha2.getColor()) && !ficha.isComodin() && !ficha2.isComodin() )
                    return false;
           }
           return true;
       }
       return false;
       
   }
    
   public boolean difColor(){
       ordenarFichas();
       if(seleccionadas.size()>= 3 && seleccionadas.size()<= 4){
           for (int i = 0; i < seleccionadas.size(); i++) {
                Ficha ficha = seleccionadas.get(i);
                for (int j = 0; j < seleccionadas.size(); j++) {
                   Ficha get = seleccionadas.get(j);
                   if((ficha.getNum() != get.getNum() || ficha.getColor()== get.getColor()) && !ficha.isComodin() && !get.isComodin())
                       return false;
                }
           }
           return true;
       }
       return false;
   }
   
   public boolean validarJugada(){
       return difColor() || esEscalera();
   }
   
   
   
}

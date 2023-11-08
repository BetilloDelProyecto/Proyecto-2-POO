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
    private boolean firstPlay = true;
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

    public boolean isFirstPlay() {
        return firstPlay;
    }

    public void setFirstPlay(boolean firstPlay) {
        this.firstPlay = firstPlay;
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
        for (int i = 0; i < seleccionadas.size() - 1; i++){
            for (int j = 0; j < seleccionadas.size() - 1 - i; j++) {
                Ficha ficha1 = seleccionadas.get(j);
                Ficha ficha2 = seleccionadas.get(j + 1);
                if (ficha1.getNum() > ficha2.getNum()) {
                    // Intercambiar las fichas en la lista
                    seleccionadas.set(j, ficha2);
                    seleccionadas.set(j + 1, ficha1);
                }
            }
        }
        System.out.println("Sout del ArrayList seleccionadas en el Sort: " + seleccionadas);
    }
    
    public void colocarComodin(){
        for (int i = 0; i < seleccionadas.size(); i++){
            Ficha f = seleccionadas.get(i);
            if (f.getNum() == 0){
                f.setNum(getValorComodin());
                f.setComodin(true);
            }
        }
        ordenarFichas();
    }
    
    public boolean esEscalera(){
        //ordenarFichas();
        if(seleccionadas.size()>= 3){
            for (int i = 0; i < seleccionadas.size()-1; i++) {
                 Ficha ficha = seleccionadas.get(i);
                 Ficha ficha2 = seleccionadas.get(i+1);
                 if((ficha2.getNum()-1 != ficha.getNum() || ficha.getColor() != ficha2.getColor()) && !ficha.isComodin() && !ficha2.isComodin() ){
                    System.out.println("False esEscalera");
                     return false;
                 }
            }
            System.out.println("True esEscalera");
            return true;
        }
        System.out.println("False2 esEscalera");
        return false;
    }

    public boolean difColor(){
        //ordenarFichas();
        if(seleccionadas.size()>= 3 && seleccionadas.size()<= 4){
            for (int i = 0; i < seleccionadas.size(); i++) {
                 Ficha ficha = seleccionadas.get(i);
                 for (int j = 0; j < seleccionadas.size(); j++) {
                    Ficha get = seleccionadas.get(j);
                    if((ficha.getNum() != get.getNum() && ficha.getColor()== get.getColor()) && !ficha.isComodin() && !get.isComodin()){
                        System.out.println("False DifColor");
                        System.out.println(ficha);
                        System.out.println(get);
                        return false;
                    }
                 }
            }
            System.out.println("True DifColor");
            return true;
        }
        System.out.println("False 2 DifColor");
        return false;
    }

    public boolean validarJugada(){
        //ordenarFichas();
        System.out.println("Seleccionadas: " + seleccionadas);
        if (firstPlay){
            colocarComodin();
            if(primeraJugada()){
                firstPlay = false;
                return difColor() || esEscalera();
            }else
                return false;
        }
        colocarComodin();
        return difColor() || esEscalera();
    }
    
    public boolean hayComodin(){
       for (int i = 0; i < seleccionadas.size(); i++) {
           Ficha get = seleccionadas.get(i);
           if(get.getNum()==0)
               return true;
       }

       return false;
    }

    public boolean esExtremo(){//dice si el comodín es un extremo
        System.out.println("sout 8");
        //ordenarFichas();
        for (int i = 0; i < seleccionadas.size() - 1; i++) {
            Ficha ficha1 = seleccionadas.get(i);
            if(ficha1.getNum() == 0)
                continue;
            Ficha ficha2 = seleccionadas.get(i+1);
            if (ficha2.getNum()-ficha1.getNum()>1)
                return false;
        }
        return true;
    }

    public boolean esMedio(){//dice si el comodín está en medio
        //ordenarFichas();
        System.out.println("Sout 666");
        for (int i = 0; i < seleccionadas.size() - 1; i++) {
            Ficha ficha1 = seleccionadas.get(i);
            if(ficha1.getNum()==0)
                continue;
            Ficha ficha2 = seleccionadas.get(i+1);
            if (ficha2.getNum()-ficha1.getNum()==2)
                return true;
        }
        return false;
    }
    public boolean esColorComodin(){
        for (int i = 0; i < seleccionadas.size()-1; i++) {
            Ficha f1 = seleccionadas.get(i);
            if (!f1.isComodin()){
                for (int j = i+1; j < seleccionadas.size(); j++) {
                    Ficha f2 = seleccionadas.get(j);
                    if (f1.getNum()!= f2.getNum() || f1.getColor() == f2.getColor()  ){
                        System.out.println("If buscado, f1: " + f1);
                        System.out.println("If buscado, f2: " + f2);
                        return false;
                    }
                }
            }
            
        }
        return true;
    }
    public int getValorComodin(){
        if (hayComodin()){
             if (esColorComodin()){
                 System.out.println("1010");
                 return seleccionadas.get(1).getNum();
             }else if(esExtremo()){
                 System.out.println("sout 3");
                 Ficha mayor = seleccionadas.get(seleccionadas.size()-1);
                 if(mayor.getNum() == 13){
                     System.out.println("sout 4");
                     return seleccionadas.get(1).getNum() - 1;
                 }
                 return mayor.getNum() + 1;
             }else if (esMedio()){
                 System.out.println("sout 5");
                 for (int i = 0; i < seleccionadas.size() - 1; i++) {
                     Ficha f1 = seleccionadas.get(i);
                     if (f1.getNum() == 0){
                         System.out.println("sout 6");
                         continue;
                     }
                     Ficha f2 = seleccionadas.get(i+1);
                     if (f2.getNum() - f1.getNum() == 2){
                         System.out.println("sout 7");
                         System.out.println(((f1.getNum()+f2.getNum())/2)+"");
                         return (f1.getNum()+f2.getNum())/2;
                     }
                         
                 }
             }

        }
        return 0;
    }
    
    public boolean primeraJugada(){
        int cont = 0;
        for (int i = 0; i < seleccionadas.size(); i++) 
            
            cont += seleccionadas.get(i).getNum();
        System.out.println("Contador de la play: " + cont);
        return cont >= 30; 
    }
   
}

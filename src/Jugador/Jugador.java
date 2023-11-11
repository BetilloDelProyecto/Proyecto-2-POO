package Jugador;

import Partida.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Jugador implements Serializable {
    //SOCKET STUFF
    public static String IP_SERVER = "localhost"; //IP del Servidor
    private Socket cliente = null;//para la comunicacion
    private DataInputStream entrada = null;//leer comunicacion
    private DataOutputStream salida = null;//escribir comunicacion
    private ObjectOutputStream salidaO = null;//Para enviar comunicacion
    private ObjectInputStream entradaO = null;//Para leer comunicacion
    //BOOLEANS
    private boolean turno = false;
    private boolean firstPlay = true;
    //STRINGS
    private String hostPartida = "";
    private String nomCliente;// nombre del user
    //GUI
    private FrameLobby lobby;
    private PartidaGUI ventanaPartida;
    //ARRAYS
    private ArrayList<Ficha> seleccionadas = new ArrayList<>();
    private ArrayList<Ficha> fichas = new ArrayList<>();
    private ArrayList<ArrayList<Ficha>> mesa = new ArrayList<>();
    //FICHA
    Ficha selec1 = null;
    Ficha selec2 = null;
    
    //------------------------------------------------CONSTRUCTOR
    public Jugador(FrameLobby lobby) {
        this.lobby = lobby;
        this.ventanaPartida = null;
    }

    //----------------------------------------GETTER & SETTER

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public Ficha getSelec1() {
        return selec1;
    }

    public void setSelec1(Ficha selec1) {
        this.selec1 = selec1;
    }

    public Ficha getSelec2() {
        return selec2;
    }

    public void setSelec2(Ficha selec2) {
        this.selec2 = selec2;
    }
    

    public ArrayList<ArrayList<Ficha>> getMesa() {
        return mesa;
    }

    public void setMesa(ArrayList<ArrayList<Ficha>> mesa) {
        this.mesa = mesa;
    }
    

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    
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
    
    
    //-----------------------------METODOS--------------------------------------
    public void conexion(int puerto) throws IOException{
        try {
            cliente = new Socket(IP_SERVER, puerto);
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            try{
                salidaO = new ObjectOutputStream(cliente.getOutputStream());
                entradaO = new ObjectInputStream(cliente.getInputStream());
                
            }  catch (IOException e) {
                System.out.println("No sirven los ObjectInputStream en Clase Jugador");
            }
           
        } catch (IOException e) {
            System.out.println("\tEl servidor no esta levantado");
            System.out.println("\t=============================");
        }
        new ThreadJugador(entrada, salida, lobby, salidaO, entradaO, this).start();
        
    }
    
    public void actualizarFichas(){
        for (int i = 0; i < fichas.size(); i++) {
            Ficha get = fichas.get(i);
            if(get.getNum() == 0)
                get.setComodin(true);
        }
    }
   
    public void ordenarFichas(ArrayList<Ficha>jugada){
        for (int i = 0; i < jugada.size() - 1; i++){
            for (int j = 0; j < jugada.size() - 1 - i; j++) {
                Ficha ficha1 = jugada.get(j);
                Ficha ficha2 = jugada.get(j + 1);
                if (ficha1.getNum() > ficha2.getNum()) {
                    // Intercambiar las fichas en la lista
                    jugada.set(j, ficha2);
                    jugada.set(j + 1, ficha1);
                }
            }
        }
        System.out.println("Sout del ArrayList jugadas en el Sort: " + jugada);
    }
    
    public void colocarComodin(ArrayList<Ficha>jugada){
        for (int i = 0; i < jugada.size(); i++){
            Ficha f = jugada.get(i);
            if (f.getNum() == 0){
                f.setNum(getValorComodin(jugada));
                f.setComodin(true);
            }
        }
        ordenarFichas(jugada);
    }
    
    public boolean esEscalera(ArrayList<Ficha>jugada){
        if(jugada.size()>= 3){
            for (int i = 0; i < jugada.size()-1; i++) {
                 Ficha ficha = jugada.get(i);
                 Ficha ficha2 = jugada.get(i+1);
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

    public boolean difColor(ArrayList<Ficha>jugada){
        //cuando es dif color, el comodín no adopta el val numerico del resto de nums, sino que adopta val num + 1
        if(jugada.size()>= 3 && jugada.size()<= 4){
            for (int i = 0; i < jugada.size(); i++) {
                 Ficha ficha = jugada.get(i);
                 for (int j = 0; j < jugada.size(); j++) {
                    Ficha get = jugada.get(j);
                    if(ficha != get&&(ficha.getNum() != get.getNum() || ficha.getColor()== get.getColor()) && !ficha.isComodin() && !get.isComodin()){
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
    
    public void quitarFichaMano(Ficha f){
        for (int i = 0; i < fichas.size(); i++) {
            Ficha get = fichas.get(i);
            if(get.getNum() == f.getNum() && get.getColor() == f.getColor())
                fichas.remove(get);
        }
    }

    public boolean validarJugada(ArrayList<Ficha>jugada){
        System.out.println("Jugadas: " + jugada);
        if (firstPlay){
            colocarComodin(jugada);
            if(primeraJugada(jugada)){
                firstPlay = false;
                return difColor(jugada) || esEscalera(jugada);
            }else
                return false;
        }
        colocarComodin(jugada);
        return difColor(jugada) || esEscalera(jugada);
    }
    
    public boolean hayComodin(ArrayList<Ficha>jugada){
       for (int i = 0; i < jugada.size(); i++) {
           Ficha get = jugada.get(i);
           if(get.getNum()==0)
               return true;
       }

       return false;
    }

    public boolean esExtremo(ArrayList<Ficha>jugada){//dice si el comodín es un extremo
        System.out.println("sout 8");
        for (int i = 0; i < jugada.size() - 1; i++) {
            Ficha ficha1 = jugada.get(i);
            if(ficha1.getNum() == 0)
                continue;
            Ficha ficha2 = jugada.get(i+1);
            if (ficha2.getNum()-ficha1.getNum()>1)
                return false;
        }
        return true;
    }

    public boolean esMedio(ArrayList<Ficha>jugada){//dice si el comodín está en medio
        System.out.println("Sout 666");
        for (int i = 0; i < jugada.size() - 1; i++) {
            Ficha ficha1 = jugada.get(i);
            if(ficha1.getNum()==0)
                continue;
            Ficha ficha2 = jugada.get(i+1);
            if (ficha2.getNum()-ficha1.getNum()==2)
                return true;
        }
        return false;
    }
    
    public boolean esColorComodin(ArrayList<Ficha>jugada){
        for (int i = 0; i < jugada.size()-1; i++) {
            Ficha f1 = jugada.get(i);
            if (!f1.isComodin()){
                for (int j = i+1; j < jugada.size(); j++) {
                    Ficha f2 = jugada.get(j);
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
    
    public int getValorComodin(ArrayList<Ficha>jugada){
        if (hayComodin(jugada)){
             if (esColorComodin(jugada)){
                 System.out.println("1010");
                 return jugada.get(1).getNum();
             }else if(esExtremo(jugada)){
                 System.out.println("sout 3");
                 Ficha mayor = jugada.get(jugada.size()-1);
                 if(mayor.getNum() == 13){
                     System.out.println("sout 4");
                     return jugada.get(1).getNum() - 1;
                 }
                 return mayor.getNum() + 1;
             }else if (esMedio(jugada)){
                 System.out.println("sout 5");
                 for (int i = 0; i < jugada.size() - 1; i++) {
                     Ficha f1 = jugada.get(i);
                     if (f1.getNum() == 0){
                         System.out.println("sout 6");
                         continue;
                     }
                     Ficha f2 = jugada.get(i+1);
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
    
    public boolean primeraJugada(ArrayList<Ficha>jugada){
        int cont = 0;
        for (int i = 0; i < jugada.size(); i++) 
            
            cont += jugada.get(i).getNum();
        System.out.println("Contador de la play: " + cont);
        return cont >= 30; 
    }
   
}

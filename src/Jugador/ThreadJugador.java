package Jugador;

import Partida.Ficha;
import Partida.PartidaGUI;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadJugador extends Thread implements Serializable{
    private DataInputStream entrada;//Para leer comunicacion
    private DataOutputStream salida; //Para enviar comunicacion
    private ObjectOutputStream salidaO=null;//Para enviar comunicacion
    private ObjectInputStream entradaO=null;//Para leer comunicacion
    
    private FrameLobby lobby;
    private PartidaGUI ventanaPartida;
    
    
    private Jugador jugador;
    
    public ThreadJugador (DataInputStream entrada,DataOutputStream salida,FrameLobby lobby, ObjectOutputStream salidaO, ObjectInputStream entradaO, Jugador jugador) throws IOException{
        this.entrada = entrada;
        this.salida = salida;
        this.salidaO = salidaO;
        this.entradaO = entradaO;
        this.lobby = lobby;
        this.jugador = jugador;
    }
    //--------------------------GET & SET----------------------------------
    public DataInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(DataInputStream entrada) {
        this.entrada = entrada;
    }

    public DataOutputStream getSalida() {
        return salida;
    }

    public void setSalida(DataOutputStream salida) {
        this.salida = salida;
    }

    public ObjectOutputStream getSalidaO() {
        return salidaO;
    }

    public void setSalidaO(ObjectOutputStream salidaO) {
        this.salidaO = salidaO;
    }

    public ObjectInputStream getEntradaO() {
        return entradaO;
    }

    public void setEntradaO(ObjectInputStream entradaO) {
        this.entradaO = entradaO;
    }

    public FrameLobby getLobby() {
        return lobby;
    }

    public void setLobby(FrameLobby lobby) {
        this.lobby = lobby;
    }

    public PartidaGUI getVentanaPartida() {
        return ventanaPartida;
    }

    public void setVentanaPartida(PartidaGUI ventanaPartida) {
        this.ventanaPartida = ventanaPartida;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    //--------------------------GET & SET----------------------------------

    
    
    //------------------FUNCION MAIN
    public void run(){
        int opcion=0;
        while(true){
            try{
                setVentanaPartida(jugador.getVentanaPartida());
                opcion=entrada.readInt();
                switch(opcion){
                    case 1:
                        try {
                            ArrayList<String> servers = new ArrayList<>();
                            int tamannoPartidas = entrada.readInt();
                            for (int i = 0; i < tamannoPartidas; i++) 
                                servers.add(entrada.readUTF());
                            lobby.refreshDefensesListBox(servers);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        jugador.setHostPartida(entrada.readUTF());
                        jugador.getVentanaPartida().llenarNombres(jugador.getHostPartida());
                        break;
                    case 3:
                        jugador.setFichas((ArrayList<Ficha>)entradaO.readObject());
                        jugador.getVentanaPartida().setMano();
                        break;
                    case 4:
                        Ficha nueva = (Ficha)entradaO.readObject();
                        jugador.getVentanaPartida().agregarFichaMano(nueva);
                        break;
                    case 5:
                        ArrayList<Ficha> jugada = (ArrayList<Ficha>)entradaO.readObject();
                        int fila = entrada.readInt();
                        int columna = entrada.readInt();
                        jugador.getVentanaPartida().pintarJugada(fila, columna, jugada);
                        break;
                    case 6:
                        ArrayList<ArrayList<Ficha>> mesa = (ArrayList<ArrayList<Ficha>>)entradaO.readObject();
                        jugador.getVentanaPartida().pintarMesa(mesa);
                        break;
                    case 7: 
                        jugador.getVentanaPartida().agregarChat(entrada.readUTF());
                        break;
                    case 20:
                        lobby.setVisible(true);
                        JOptionPane.showMessageDialog(lobby,"Error, existe nombre","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    case 21:
                        jugador.getVentanaPartida().msgError();
                        break;
                    case 100://SETEA EL TURNO DE CADA JUGADOR EN LA PARTIDA
                        jugador.setTurno(entrada.readBoolean());
                        break;
                    case 101://SETEA EL TURNO DE CADA JUGADOR EN LA PARTIDA
                        String nombre = entrada.readUTF();
                        if(!nombre.equals(jugador.getNomCliente()))
                            jugador.getVentanaPartida().llenarNombres(nombre);
                        break;
                    default:
                        break;
                }
         }catch (IOException e){
            System.out.println("Error en la comunicacion ");
            break;
         } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      System.out.println("se desconecto el servidor");
   }
    
}

package Jugador;

import Partida.Ficha;
import Partida.PartidaGUI;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadJugador extends Thread implements Serializable{
    //solo de lectura
    transient DataInputStream entrada;
    transient DataOutputStream salida;
    transient ObjectOutputStream salidaO=null;//Para enviar comunicacion
    transient ObjectInputStream entradaO=null;//Para leer comunicacion
    
    FrameLobby lobby; //referencia acliente
    PartidaGUI ventanaPartida;
    Jugador jugador;
    public ThreadJugador (DataInputStream entrada,DataOutputStream salida,FrameLobby lobby, ObjectOutputStream salidaO, ObjectInputStream entradaO, Jugador jugador) throws IOException{
        this.entrada = entrada;
        this.salida = salida;
        this.salidaO = salidaO;
        this.entradaO = entradaO;
        this.lobby = lobby;
        this.jugador = jugador;
    }
    public void run(){
        int opcion=0;
        // solamente lee lo que el servidor threadServidor le envia
        while(true){
            try{
                // esta leyendo siempre la instruccion, un int
                opcion=entrada.readInt();
                switch(opcion){
                    case 1://mensaje enviado
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
                        break;
                    case 3:
                        jugador.setFichas((ArrayList<Ficha>)entradaO.readObject());
                        jugador.getVentanaPartida().setMano();
                        break;
                    case 20:
                        lobby.setVisible(true);
                        JOptionPane.showMessageDialog(lobby,"Error, existe nombre","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    default:
                        break;
                }
         }
         catch (IOException e){
            System.out.println("Error en la comunicacion ");
            break;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ThreadJugador.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      System.out.println("se desconecto el servidor");
   }
    
}

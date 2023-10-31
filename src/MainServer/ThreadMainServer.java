
package MainServer;

import Jugador.Jugador;
import Partida.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadMainServer extends Thread{
    transient Socket jugador = null;//referencia a socket de comunicacion de cliente
    transient DataInputStream entrada=null;//Para leer comunicacion
    transient DataOutputStream salida=null;//Para enviar comunicacion
    
    transient ObjectOutputStream salidaO=null;//Para enviar comunicacion
    transient ObjectInputStream entradaO=null;//Para leer comunicacion
    
    MainServidor servidor;// referencia al servidor
    boolean isRunning = true;
    public ThreadMainServer(Socket jugador, MainServidor serv) {
        this.jugador = jugador;
        this.servidor = serv;
    }
    public void run(){
        try{
            entrada = new DataInputStream(jugador.getInputStream());//comunic
            salida = new DataOutputStream(jugador.getOutputStream());//comunic
            salidaO = new ObjectOutputStream(jugador.getOutputStream());//comunic
            entradaO = new ObjectInputStream(jugador.getInputStream());//comunic
        }
        
        catch (IOException e) {  e.printStackTrace();     }
        //VARIABLES
        int opcion=0;
        while (isRunning) {            
            try {
                opcion = entrada.readInt();
                switch (opcion) {
                    case 1:
                        String nuevoSv = entrada.readUTF();
                        if(!servidor.existeNombre(nuevoSv)){
                            servidor.nombres.add(nuevoSv);
                            Jugador j = (Jugador) entradaO.readObject();
                            System.out.println("ESTE ES EL SOUT BUSCADO, NOMBRE: " + j.getNomCliente());
                            Partida nueva = new Partida(j);
                            servidor.getPartidas().add(nueva);
                            for (int i = 0; i < servidor.threadsMainServer.size(); i++) {
                                servidor.threadsMainServer.get(i).salida.writeInt(1);
                                servidor.threadsMainServer.get(i).salida.writeUTF(nuevoSv);
                            }
                        }else{
                            salida.writeInt(20);
                            System.out.println("Si existe el nombre");                              
                        }
                        break;
                    default:
                        System.out.println("Default del ThreadMainServer");
                }
            } catch (IOException ex) {
                System.out.println("THREAD CLIENTE SE HA DETENIDO");
                this.isRunning = false;
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase Jugador no encontrada");
            }
            
        }
    }
    
    
    
}


package MainServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import JuegoServidor.FrameWaitingPlayers;
import javax.swing.JOptionPane;

public class ThreadMainServer extends Thread{
    Socket jugador = null;//referencia a socket de comunicacion de cliente
    DataInputStream entrada=null;//Para leer comunicacion
    DataOutputStream salida=null;//Para enviar comunicacion
    MainServidor servidor;// referencia al servidor
    boolean isRunning = true;

    public ThreadMainServer(Socket jugador, MainServidor serv) {
        this.jugador = jugador;
        this.servidor = serv;
    }
    
    public void run(){
        try{
            // inicializa para lectura y escritura con stream de cliente
            entrada=new DataInputStream(jugador.getInputStream());//comunic
            salida=new DataOutputStream(jugador.getOutputStream());//comunic
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
                            salida.writeInt(21);
                            servidor.nombres.add(nuevoSv);
                            FrameWaitingPlayers nuevo = new FrameWaitingPlayers();
                            //nuevo.setVisible(true);
                            nuevo.getLocalServidor().runServer(servidor.cont++);
                            servidor.servidores.add(nuevo);
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
            }
            
        }
    }
    
    
    
}


package MainServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadMainServer extends Thread{
    Socket jugador = null;//referencia a socket de comunicacion de cliente
    DataInputStream entrada=null;//Para leer comunicacion
    DataOutputStream salida=null;//Para enviar comunicacion
    //String nameUser; //Para el nombre del usuario de esta conexion
    MainServidor servidor;// referencia al servidor

    // para envio de mensajes al enemigo
    //ArrayList <ThreadMainServer> enemigos = null;
    // identificar el numero de jugador
    //int numeroDeJugador;

    public ThreadMainServer(Socket jugador, MainServidor serv) {
        this.jugador = jugador;
        this.servidor = serv;
    }
    
    public void run(){
        try{
            // inicializa para lectura y escritura con stream de cliente
            entrada=new DataInputStream(jugador.getInputStream());//comunic
            salida=new DataOutputStream(jugador.getOutputStream());//comunic
            // Es el primer read que hace, para el nombre del user

            //System.out.println("lee el nombre");
            //this.setNameUser(entrada.readUTF());
            
        }
        catch (IOException e) {  e.printStackTrace();     }
        //VARIABLES
        int opcion=0;
        int numUsers=0;
        String amigo="";
        String mencli="";
        while (true) {            
            try {
                opcion = entrada.readInt();
                switch (opcion) {
                    case 1:
                        String nuevoSv = entrada.readUTF();
                        //salida.writeInt(1);
                        for (int i = 0; i < servidor.threadsServer.size(); i++) {
                            servidor.threadsServer.get(i).salida.writeInt(1);
                            servidor.threadsServer.get(i).salida.writeUTF(nuevoSv);
                            //recien guardado
                        }
                        System.out.println("Opcion 1 ha llegado al ThreadMainServer");
                        
                        //enemigos.get(0).salida.writeInt(1);
                        //System.out.println(servidor.jugadores.size());
                        //System.out.println("Estoy en el Thread Main Server");
                        break;
                    default:
                        System.out.println("Default del ThreadMainServer");
                }
            } catch (IOException ex) {
                System.out.println("Pinga");
            }
            
        }
    }
    
    
    
}

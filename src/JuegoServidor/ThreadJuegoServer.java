package JuegoServidor;

import java.io.*;
import java.net.*;

public class ThreadJuegoServer extends Thread{
    Socket jugador = null;//referencia a socket de comunicacion de cliente
    DataInputStream entrada=null;//Para leer comunicacion
    DataOutputStream salida=null;//Para enviar comunicacion
    JuegoServidor servidor;// referencia al servidor


    public ThreadJuegoServer(Socket jugador, JuegoServidor serv) {
        this.jugador = jugador;
        this.servidor = serv;
    }
    
    public void run(){
        try{
            entrada=new DataInputStream(jugador.getInputStream());
            salida=new DataOutputStream(jugador.getOutputStream());
   
        }
        catch (IOException e) {  e.printStackTrace();     }
        //VARIABLES
        int opcion=0;
        while (true) {            
            try {
                opcion = entrada.readInt();
                switch (opcion) {
                    case 1:
                        break;
                    default:
                        System.out.println("Default del ThreadJuegoServer");
                }
            } catch (IOException ex) {
                System.out.println("Pinga");
            }
            
        }
    }
}

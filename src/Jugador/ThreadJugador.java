package Jugador;

import java.io.*;

public class ThreadJugador extends Thread{
    //solo de lectura
    DataInputStream entrada;
    DataOutputStream salida;
    FrameLobby lobby; //referencia acliente
    public ThreadJugador (DataInputStream entrada,DataOutputStream salida,FrameLobby lobby) throws IOException{
        this.entrada = entrada;
        this.salida = salida;
        this.lobby = lobby;
    }
    
    public void run(){
        int opcion=0;
        // solamente lee lo que el servidor threadServidor le envia
        while(true){
            try{
                // esta leyendo siempre la instruccion, un int
                opcion=entrada.readInt();
                switch(opcion)
                {
                    case 1://mensaje enviado
                        System.out.println("dawklmklmawdl");
                        break;
                    default:
                        break;
            }
         }
         catch (IOException e){
            System.out.println("Error en la comunicaci�n "+"Informaci�n para el usuario");
            break;
         }
      }
      System.out.println("se desconecto el servidor");
   }
    
}

package Jugador;

import java.io.*;
import javax.swing.JOptionPane;

public class ThreadJugador extends Thread implements Serializable{
    //solo de lectura
    transient DataInputStream entrada;
    transient DataOutputStream salida;
    transient ObjectOutputStream salidaO=null;//Para enviar comunicacion
    transient ObjectInputStream entradaO=null;//Para leer comunicacion
    
    FrameLobby lobby; //referencia acliente
    public ThreadJugador (DataInputStream entrada,DataOutputStream salida,FrameLobby lobby, ObjectOutputStream salidaO, ObjectInputStream entradaO) throws IOException{
        this.entrada = entrada;
        this.salida = salida;
        this.salidaO = salidaO;
        this.entradaO = entradaO;
        
        this.lobby = lobby;
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
                        String name = entrada.readUTF();
                        lobby.refreshDefensesListBox(name);
                        //System.out.println(name);
                        //System.out.println("Estoy en el Thread Jugador");
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
            System.out.println("Error en la comunicacion "+"Informacion para el usuario   pinga");
            break;
         }
      }
      System.out.println("se desconecto el servidor");
   }
    
}

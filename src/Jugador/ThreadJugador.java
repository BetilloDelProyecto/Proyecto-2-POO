package Jugador;

import java.io.*;
import javax.swing.JOptionPane;

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
                switch(opcion){
                    case 1://mensaje enviado
                        String name = entrada.readUTF();
                        lobby.refreshDefensesListBox(name);
                        //System.out.println(name);
                        
                        //System.out.println("Estoy en el Thread Jugador");
                        break;
                    case 20:
                        lobby.revalidate();
                        lobby.repaint();
                        lobby.setVisible(true);
                        
                        JOptionPane.showMessageDialog(lobby,"Error, existe nombre","Error",JOptionPane.ERROR_MESSAGE);
                        break;
                    case 21:
                        lobby.revalidate();
                        lobby.repaint();
                        lobby.setVisible(false);
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


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
                    case 1://crea una lobby nueva
                        String nuevoSv = entrada.readUTF();
                        if(!servidor.existeNombre(nuevoSv)){
                            if(!"".equals(nuevoSv)){
                                servidor.nombres.add(nuevoSv);
                                Jugador j = (Jugador) entradaO.readObject();
                                Partida nueva = new Partida(j);
                                j.setPartida(nueva);
                                servidor.getPartidas().add(nueva);
                                
                            }
                            for (int i = 0; i < servidor.threadsMainServer.size(); i++) {
                                servidor.threadsMainServer.get(i).salida.writeInt(1);
                                servidor.threadsMainServer.get(i).salida.writeInt(servidor.getPartidas().size());
                                //salida.writeUTF("Paquito");
                                for (int j = 0; j < servidor.getPartidas().size(); j++) {
                                    System.out.println("Entro al for del threadMainServer");
                                    Partida get = servidor.getPartidas().get(j);
                                    servidor.threadsMainServer.get(i).salida.writeUTF(get.getHost().getNomCliente());
                                }
                            }
                        }else{
                            salida.writeInt(20);
                            System.out.println("Si existe el nombre");                              
                        }
                        break;
                    case 2://se une a una lobby
                        nuevoSv = entrada.readUTF();
                        String svBuscado = entrada.readUTF();
                        if(!servidor.existeNombre(nuevoSv)){
                            if (partidaBuscada(svBuscado)!=null){
                                Jugador nuevo = (Jugador) entradaO.readObject();
                                partidaBuscada(svBuscado).getJugadores().add(nuevo);
                                nuevo.setPartida(partidaBuscada(svBuscado));
                            }
                        }else{
                            salida.writeInt(20);
                            System.out.println("Si existe el nombre");                              
                        }
                        break;
                    case 3://agrega los nombres de los rivales en la interfaz de cada jugador en la sala
                        svBuscado = entrada.readUTF();
                        for (int i = 0; i < partidaBuscada(svBuscado).getJugadores().size(); i++) {
                            Jugador get = partidaBuscada(svBuscado).getJugadores().get(i);
                            System.out.println("Nombre del jugador por modificar ventana: " + get.getNomCliente());
                            get.refrescaNombresPartida();
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
    
    public Partida partidaBuscada(String nombreHost){
        for (int i = 0; i < servidor.getPartidas().size(); i++) {
            if(servidor.getPartidas().get(i).getHost().getNomCliente().equals(nombreHost)){
                return servidor.getPartidas().get(i);
            }
        }
        return null;
    }
    
}

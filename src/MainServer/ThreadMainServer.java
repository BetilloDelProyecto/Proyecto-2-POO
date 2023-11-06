
package MainServer;

import Jugador.Jugador;
import Partida.*;
import java.io.*;
import java.net.*;

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
                                String host = entrada.readUTF();
                                Partida nueva = new Partida(host,this);
                                servidor.getPartidas().add(nueva);
                                
                            }
                            for (int i = 0; i < servidor.threadsMainServer.size(); i++) {
                                servidor.threadsMainServer.get(i).salida.writeInt(1);
                                servidor.threadsMainServer.get(i).salida.writeInt(servidor.getPartidas().size());
                                //salida.writeUTF("Paquito");
                                for (int j = 0; j < servidor.getPartidas().size(); j++){
                                    Partida get = servidor.getPartidas().get(j);
                                    servidor.threadsMainServer.get(i).salida.writeUTF(get.getHost());
                                }
                            }
                        }else{
                            salida.writeInt(20);
                            System.out.println("Nickname en uso, inténtalo con otro.");                               
                        }
                        break;
                    case 2://se une a una lobby
                        nuevoSv = entrada.readUTF();
                        String svBuscado = entrada.readUTF();
                        if(!servidor.existeNombre(nuevoSv)){
                            if (partidaBuscada(svBuscado)!=null){
                                partidaBuscada(svBuscado).getThreadsInLobby().add(this);
                                salida.writeInt(2);
                                salida.writeUTF(svBuscado);
                            }
                            else{
                                System.out.println("No se encontró la partida. Case 2 threadMainSv");
                                salida.writeInt(2);
                                salida.writeUTF("");
                            }
                            
                            System.out.println("Tamanho de los threads en la partida buscada: " + partidaBuscada(svBuscado).getThreadsInLobby().size());
                        }else{
                            salida.writeInt(20);
                            System.out.println("Nickname en uso, inténtalo con otro.");                              
                        }
                        //se deben refrescar los nombres de los miembros de la partida
                        
                        break;

                    case 3://se inicia la partida por el host
                        
                        svBuscado = entrada.readUTF();
                        Partida partidaBuscada = partidaBuscada(svBuscado);
                        if (partidaBuscada != null) {
                            for (int i = 0; i < partidaBuscada.getThreadsInLobby().size(); i++) {
                                ThreadMainServer get = partidaBuscada.getThreadsInLobby().get(i);
                                get.salida.writeInt(3);
                                get.salidaO.writeObject(partidaBuscada.repartirFichas());
                            }
                        }else{
                            System.out.println("Partida no encontrada, error en el servidor.");
                            
                        }
                        //Se reparten fichas
                        
                        //se asignan turnos
                        
                      
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
    
    public Partida partidaBuscada(String nombreHost){
        for (int i = 0; i < servidor.getPartidas().size(); i++) {
            if(servidor.getPartidas().get(i).getHost().equals(nombreHost)){
                return servidor.getPartidas().get(i);
            }
        }
        return null;
    }
    
}

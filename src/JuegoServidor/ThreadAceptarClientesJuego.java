package JuegoServidor;

import MainServer.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;

public class ThreadAceptarClientesJuego extends Thread {
    Socket jugador = null; 
    JuegoServidor servidor;
    boolean isRunning;

    public ThreadAceptarClientesJuego(JuegoServidor servidor) {
        this.servidor = servidor;
        this.isRunning = true;
    }
    
    public void run(){
        while(isRunning){
            try {
                try {
                    servidor.jugadores.add(servidor.localServidor.accept());
                    //el nick name tiene que aparecer en el list box de todos los jugadores
                    servidor.threadsJuegoServer.add(new ThreadJuegoServer(servidor.jugadores.get(servidor.jugadores.size()-1),servidor));
                    servidor.threadsJuegoServer.get(servidor.threadsJuegoServer.size()-1).start();
                    System.out.println("Se metio un jugador a la nueva partida");
                } catch (IOException ex) {
                    
                }
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}

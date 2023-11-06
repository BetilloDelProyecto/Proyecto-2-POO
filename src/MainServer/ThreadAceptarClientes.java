package MainServer;

import java.io.*;

public class ThreadAceptarClientes extends Thread{
    MainServidor servidor;
    boolean isRunning;

    public ThreadAceptarClientes(MainServidor servidor) {
        this.servidor = servidor;
        this.isRunning = true;
    }
    
    public void run(){
        while(isRunning){
            try {
                try {
                    servidor.jugadores.add( servidor.servidorMain.accept());
                    servidor.ventana.mostrar("Cliente se ha conectado");
                    servidor.threadsMainServer.add(new ThreadMainServer(servidor.jugadores.get(servidor.jugadores.size()-1), servidor));
                    servidor.threadsMainServer.get(servidor.threadsMainServer.size()-1).start();
                } catch (IOException ex) {
                    
                }
                servidor.ventana.mostrar("Estoy esperando clientes");
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
   
}

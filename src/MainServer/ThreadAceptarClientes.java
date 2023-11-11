package MainServer;

import java.io.*;

public class ThreadAceptarClientes extends Thread{
    private MainServidor servidor;
    private boolean isRunning;

    public ThreadAceptarClientes(MainServidor servidor) {
        this.servidor = servidor;
        this.isRunning = true;
    }
    
    public void run(){
        while(isRunning){
            try {
                try {
                    servidor.getJugadores().add( servidor.getServidorMain().accept());
                    servidor.getVentana().mostrar("Cliente se ha conectado");
                    servidor.getThreadsMainServer().add(new ThreadMainServer(servidor.getJugadores().get(servidor.getJugadores().size()-1), servidor));
                    servidor.getThreadsMainServer().get(servidor.getThreadsMainServer().size()-1).start();
                } catch (IOException ex) {
                    
                }
                servidor.getVentana().mostrar("Estoy esperando clientes");
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
   
}

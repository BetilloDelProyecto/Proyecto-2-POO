
package MainServer;

import Partida.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ThreadMainServer extends Thread{
    //SOCKETS STUFF
    private Socket jugador = null;
    private DataInputStream entrada=null;
    private DataOutputStream salida=null;
    private ObjectOutputStream salidaO=null;
    private ObjectInputStream entradaO=null;
    //MAIN SERVER
    private MainServidor servidor;
    //BOOLEANS
    private boolean isRunning = true;
    
    //-------------------------------CONSTRUCTOR--------------------------------
    public ThreadMainServer(Socket jugador, MainServidor serv) {
        this.jugador = jugador;
        this.servidor = serv;
    }
    
    //-------------------------------GET & SET----------------------------------

    public DataInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(DataInputStream entrada) {
        this.entrada = entrada;
    }

    public DataOutputStream getSalida() {
        return salida;
    }

    public void setSalida(DataOutputStream salida) {
        this.salida = salida;
    }

    public MainServidor getServidor() {
        return servidor;
    }

    public void setServidor(MainServidor servidor) {
        this.servidor = servidor;
    }
    

    public ObjectOutputStream getSalidaO() {
        return salidaO;
    }

    public void setSalidaO(ObjectOutputStream salidaO) {
        this.salidaO = salidaO;
    }

    public ObjectInputStream getEntradaO() {
        return entradaO;
    }

    public void setEntradaO(ObjectInputStream entradaO) {
        this.entradaO = entradaO;
    }
    //-------------------------------GET & SET----------------------------------
    
    
    
    //-------------------------------METODO MAIN--------------------------------
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
                                servidor.getNombres().add(nuevoSv);
                                String host = entrada.readUTF();
                                Partida nueva = new Partida(host,this);
                                servidor.getPartidas().add(nueva);
                                nueva.actualizarTurno();
                            }
                            for (int i = 0; i < servidor.getThreadsMainServer().size(); i++) {
                                servidor.getThreadsMainServer().get(i).salida.writeInt(1);
                                servidor.getThreadsMainServer().get(i).salida.writeInt(servidor.getPartidas().size());
                                for (int j = 0; j < servidor.getPartidas().size(); j++){
                                    Partida get = servidor.getPartidas().get(j);
                                    servidor.getThreadsMainServer().get(i).salida.writeUTF(get.getHost());
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
                        Partida partidaBuscada = partidaBuscada(svBuscado);
                        if(!servidor.existeNombre(nuevoSv)){
                            System.out.println("ENCONTRO EL SV");
                            if (partidaBuscada!=null){
                                partidaBuscada.getThreadsInLobby().add(this);
                                salida.writeInt(2);
                                salida.writeUTF(svBuscado);
                                for (int i = 0; i < partidaBuscada.getThreadsInLobby().size(); i++) {
                                    ThreadMainServer get = partidaBuscada.getThreadsInLobby().get(i);get.salida.writeInt(101);
                                    get.salida.writeInt(101);
                                    get.salida.writeUTF(nuevoSv);
                                    
                                    
                                }
                            }
                            else{
                                System.out.println("No se encontró la partida. Case 2 threadMainSv");
                                salida.writeInt(2);
                                salida.writeUTF("");
                            }
                            
                        }else{
                            salida.writeInt(20);
                            System.out.println("Nickname en uso, inténtalo con otro.");                              
                        }
                        break;

                    case 3: //se inicia la partida por el host
                        svBuscado = entrada.readUTF();
                        partidaBuscada = partidaBuscada(svBuscado);
                        if (partidaBuscada != null) {
                            partidaBuscada.actualizarTurno();
                            for (int i = 0; i < partidaBuscada.getThreadsInLobby().size(); i++) {
                                ThreadMainServer get = partidaBuscada.getThreadsInLobby().get(i);
                                get.salida.writeInt(3);
                                get.salidaO.writeObject(partidaBuscada.repartirFichas());
                            }
                        }else
                            System.out.println("Partida no encontrada, error en el servidor.");
                        break;
                    case 4: //se toma una ficha del bote
                        svBuscado = entrada.readUTF();
                        partidaBuscada = partidaBuscada(svBuscado);
                        if (partidaBuscada != null) {
                            salida.writeInt(4);
                            Ficha ficha = partidaBuscada.tomarFichaBote();
                            if (ficha != null)
                                salidaO.writeObject(partidaBuscada.tomarFichaBote());
                            else
                                salida.writeInt(21);
                            partidaBuscada.sigTurno();
                            partidaBuscada.actualizarTurno();
                        }else{
                            System.out.println("Partida no encontrada, error en el servidor. OPCION 4 Thre");
                        }
                      
                        break;
                    case 5: //se ingresa una jugada en la mesa
                        svBuscado = entrada.readUTF();
                        int fila = entrada.readInt();
                        int columna = entrada.readInt();
                        partidaBuscada = partidaBuscada(svBuscado);
                        if (partidaBuscada != null) {
                            ArrayList<Ficha> jugada = new ArrayList<>(); // Crear un nuevo ArrayList
                            int sizeJugada = entrada.readInt();
                            for (int i = 0; i < sizeJugada; i++) {
                                jugada.add((Ficha)entradaO.readObject());
                            }
                            partidaBuscada.getMesa().add(jugada);
                            for (int i = 0; i < partidaBuscada.getThreadsInLobby().size(); i++) {
                                ThreadMainServer get = partidaBuscada.getThreadsInLobby().get(i);
                                get.salida.writeInt(5);
                                get.salidaO.writeObject(jugada);
                                get.salida.writeInt(fila);
                                get.salida.writeInt(columna);
                            }

                        }else{
                            System.out.println("Partida no encontrada, error en el servidor. OPCION 4 Thre");
                        }
                        break;
                    case 6:
                        svBuscado = entrada.readUTF();
                        partidaBuscada = partidaBuscada(svBuscado);
                        if (partidaBuscada != null) {
                            ArrayList<ArrayList<Ficha>> mesa = (ArrayList<ArrayList<Ficha>>)entradaO.readObject();
                            for (int i = 0; i < partidaBuscada.getThreadsInLobby().size(); i++) {
                                ThreadMainServer get = partidaBuscada.getThreadsInLobby().get(i);
                                get.getSalida().writeInt(6);
                                get.getSalidaO().writeObject(mesa);
                            }
                            partidaBuscada.sigTurno();
                            partidaBuscada.actualizarTurno();
                        }
                        break;
                    case 7:
                        svBuscado = entrada.readUTF();
                        partidaBuscada = partidaBuscada(svBuscado);
                        String msg = entrada.readUTF();
                        String nombre = entrada.readUTF();
                        if (partidaBuscada != null) {
                            for (int i = 0; i < partidaBuscada.getThreadsInLobby().size(); i++) {
                                ThreadMainServer get = partidaBuscada.getThreadsInLobby().get(i);
                                get.salida.writeInt(7);
                                get.salida.writeUTF(nombre + " >> " + msg + "\n");
                            }
                        }
                        break;
                    default:
                        System.out.println("Default del ThreadMainServer");
                }
            } catch (IOException ex) {
                System.out.println("THREAD CLIENTE SE HA DETENIDO");
                this.isRunning = false;
            }catch (ClassNotFoundException ex) {
                System.out.println("No se encontro una clase...");
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

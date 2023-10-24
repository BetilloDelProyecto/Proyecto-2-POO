package Jugador;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class Jugador {
    public static String IP_SERVER = "localhost"; //IP del Servidor
    DataInputStream entrada = null;//leer comunicacion
    DataOutputStream salida = null;//escribir comunicacion
    Socket cliente = null;//para la comunicacion
    String nomCliente;// nombre del user
    FrameLobby lobby;

    public Jugador(FrameLobby lobby) {
        this.lobby = lobby;
    }
    
    public void conexion(int puerto) throws IOException{
        try {
            // se conecta con dos sockets al server, uno comunicacion otro msjes
            cliente = new Socket("localhost", puerto);
            // inicializa las entradas-lectura y salidas-escritura
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            // solicita el nombre del user
            //nomCliente = JOptionPane.showInputDialog("Introducir Nick: ");
            //Lo coloca en la ventana
            //ventanaCliente.setTitle(nomCliente);
            // es lo primero que envia al server
            // el thread servidor esta pendiente de leer el nombre antes de entrar
            // al while para leer opciones
            //salida.writeUTF(nomCliente);
            //System.out.println("1. Envia el nombre del cliente: "+nomCliente);
        } catch (IOException e) {
            System.out.println("\tEl servidor no esta levantado");
            System.out.println("\t=============================");
        }
        // solo se le pasa entrada pues es solo para leer mensajes
        // el hiloCliente lee lo que el servidor le envia, opciones y como tiene referencia
        // a la ventana gato puede colocar en la pantalla cualquier cosa, como las
        //imagenes de X o O, llamar a metodo marcar, colocar el nombre de enemigo
        // o el suyo propio
        //new threadCliente(entrada, ventanaCliente).start();
   }
    
    
    
    
    
}
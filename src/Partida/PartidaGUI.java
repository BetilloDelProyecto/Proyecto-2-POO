
package Partida;

import Jugador.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class PartidaGUI extends javax.swing.JFrame implements Serializable{
    Jugador jugador;
    JLabel[][] matrizMesa = new JLabel[11][16];
    JLabel[][] matrizMano = new JLabel[3][13];
    
    public PartidaGUI() {
        initComponents();
        //this.setSize(1030, 938);
        this.setLayout(null);
        pnlMesa.setSize(816, 594);
        pnlMano.setSize(585, 192);
        generarMatrizMano();
        generarMatrizMesa();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEnemigo1 = new javax.swing.JLabel();
        lblEnemigo2 = new javax.swing.JLabel();
        lblEnemigo3 = new javax.swing.JLabel();
        pnlMesa = new javax.swing.JPanel();
        btnIniciarPartida = new javax.swing.JButton();
        btnSalirPartida = new javax.swing.JButton();
        btnCogerMano = new javax.swing.JButton();
        btnTerminarTurno = new javax.swing.JButton();
        txfEnviar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaChat = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlMano = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEnemigo1.setText(". . .");

        lblEnemigo2.setText(". . .");

        lblEnemigo3.setText(". . .");

        pnlMesa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa.setPreferredSize(new java.awt.Dimension(820, 500));

        javax.swing.GroupLayout pnlMesaLayout = new javax.swing.GroupLayout(pnlMesa);
        pnlMesa.setLayout(pnlMesaLayout);
        pnlMesaLayout.setHorizontalGroup(
            pnlMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 812, Short.MAX_VALUE)
        );
        pnlMesaLayout.setVerticalGroup(
            pnlMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        btnIniciarPartida.setText("Iniciar Partida");
        btnIniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPartidaActionPerformed(evt);
            }
        });

        btnSalirPartida.setText("Salir");
        btnSalirPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPartidaActionPerformed(evt);
            }
        });

        btnCogerMano.setText("Coger Ficha");
        btnCogerMano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCogerManoActionPerformed(evt);
            }
        });

        btnTerminarTurno.setText("Terminar Turno");
        btnTerminarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarTurnoActionPerformed(evt);
            }
        });

        txaChat.setColumns(20);
        txaChat.setRows(5);
        jScrollPane1.setViewportView(txaChat);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        jLabel1.setText("Turno de ");

        pnlMano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlManoLayout = new javax.swing.GroupLayout(pnlMano);
        pnlMano.setLayout(pnlManoLayout);
        pnlManoLayout.setHorizontalGroup(
            pnlManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        pnlManoLayout.setVerticalGroup(
            pnlManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(lblEnemigo1)
                        .addGap(315, 315, 315)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblEnemigo3)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblEnemigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnTerminarTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSalirPartida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnCogerMano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnIniciarPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txfEnviar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEnviar)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEnemigo1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(lblEnemigo3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(lblEnemigo2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTerminarTurno)
                            .addComponent(btnCogerMano))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalirPartida)
                            .addComponent(btnIniciarPartida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnviar))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    
    
    private void btnSalirPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPartidaActionPerformed
        if (jugador.getHostPartida()=="") {
            System.out.println("NO TIENE PARTIDA EL JUGADOR");
        }else{
            System.out.println("SÍ TIENE PARTIDA EL JUGADOR");
        }
    }//GEN-LAST:event_btnSalirPartidaActionPerformed
    
    private void btnIniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPartidaActionPerformed
        try {
            btnIniciarPartida.setVisible(false);
            jugador.getSalida().writeInt(3);
            jugador.getSalida().writeUTF(jugador.getHostPartida());
            
        } catch (IOException ex) {
            System.out.println("SE CAYO EN BTN INICIAR PARTIDA");
        }
    }//GEN-LAST:event_btnIniciarPartidaActionPerformed
    
    public void llenarNombres(String nom){
        if(lblEnemigo1.getText().equals(". . .")){
            lblEnemigo1.setText(nom);
        }else if (lblEnemigo2.getText().equals(". . .")){
            lblEnemigo2.setText(nom);
        }else if(lblEnemigo3.getText().equals(". . .")){
            lblEnemigo3.setText(nom);
        }else{
            System.out.println("HOLA GENTE");
        }
    }
    
    private void btnCogerManoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCogerManoActionPerformed
        if(jugador.isTurno()){
            try {
                jugador.getSalida().writeInt(4);
                jugador.getSalida().writeUTF(jugador.getHostPartida());
            } catch (IOException ex) {
                System.out.println("NO SE PUDO ENVIAR LA SENHA 4 DEL BTN DE LA MANO");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No estas en tu turno, achantela...", "Error, no puede tomar una ficha", ERROR_MESSAGE);
        
        }
        
    }//GEN-LAST:event_btnCogerManoActionPerformed

    private void btnTerminarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarTurnoActionPerformed
        if(jugador.isTurno()){
            ArrayList <ArrayList <Ficha>> mesaJugadas = getArraysMesa();
            refreshMesa();
            if(validarMesa(mesaJugadas)){
                for (int i = 0; i < mesaJugadas.size(); i++) {
                    ArrayList<Ficha> get = mesaJugadas.get(i);
                    for(Ficha f: get){
                        matrizMesa[f.getPosX()][f.getPosY()].setText(f.getNum()+"");
                        matrizMesa[f.getPosX()][f.getPosY()].setForeground(getColor(f.getColor()));
                    }
                    jugador.setMesa(mesaJugadas);  
                }
                try{
                    jugador.getSalida().writeInt(6);
                    jugador.getSalida().writeUTF(jugador.getHostPartida());
                    jugador.getSalidaO().writeObject(jugador.getMesa());
                }catch (IOException ex) {
                    System.out.println("NO SE MANDO LA SENHAL DEL BOTON TERMINAR JUGADA");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Mesa no valida", "Muy sobo", ERROR_MESSAGE);
                refreshMano();
                setMano();
                for (int i = 0; i < jugador.getFichas().size(); i++) {
                    Ficha get = jugador.getFichas().get(i);
                    JLabel lbl = getPosLibreMano();
                    if(lbl!= null){
                        lbl.setText(get.getNum()+"");
                        lbl.setForeground(getColor(get.getColor()));
                    }

                }
                for (int i = 0; i < jugador.getMesa().size(); i++) {
                    ArrayList<Ficha> get = jugador.getMesa().get(i);
                    for(Ficha f: get){
                        matrizMesa[f.getPosX()][f.getPosY()].setText(f.getNum()+"");
                        matrizMesa[f.getPosX()][f.getPosY()].setForeground(getColor(f.getColor()));
                    }
                }
            }

        }else
            JOptionPane.showMessageDialog(null, "No estas en tu turno, achantela...", "Error, no puede tomar una ficha", ERROR_MESSAGE);
    }//GEN-LAST:event_btnTerminarTurnoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            String msg = txfEnviar.getText();
            
            jugador.getSalida().writeInt(7);
            jugador.getSalida().writeUTF(jugador.getHostPartida());
            jugador.getSalida().writeUTF(msg);
            jugador.getSalida().writeUTF(jugador.getNomCliente());
            txfEnviar.setText("");
        } catch (IOException ex) {
            System.out.println("NO SE PUDO ENVIAR LA SENHAL DEL BTN ENVIAR CHAT");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed
    
    public void agregarChat(String msg){
        txaChat.append(msg);
    }
    public void pintarMesa(ArrayList<ArrayList<Ficha>> mesa){
        for (int i = 0; i < mesa.size(); i++) {
            ArrayList<Ficha> get = mesa.get(i);
            for (int j = 0; j < get.size(); j++) {
                Ficha f = get.get(j);
                if(f.isComodin())
                    matrizMesa[f.getPosX()][f.getPosY()].setText(":)");
                else
                    matrizMesa[f.getPosX()][f.getPosY()].setText(""+f.getNum());
                matrizMesa[f.getPosX()][f.getPosY()].setForeground(getColor(f.getColor()));   
            }
        }
    }
    public boolean validarMesa(ArrayList <ArrayList <Ficha>> jugadas){
        for (int i = 0; i < jugadas.size(); i++) {
            ArrayList<Ficha> get = jugadas.get(i);
            if(!jugador.validarJugada(get)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartidaGUI().setVisible(true);
            }
        });
    }
    
    
    //-------------------------------GET & SET----------------------------------
    public JLabel getLblEnemigo1() {
        return lblEnemigo1;
    }

    public JLabel getLblEnemigo2() {
        return lblEnemigo2;
    }

    public JLabel getLblEnemigo3() {
        return lblEnemigo3;
    }

    public JButton getBtnIniciarPartida() {
        return btnIniciarPartida;
    }

    public JButton getBtnSalirPartida() {
        return btnSalirPartida;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public Jugador getJugador() {
        return jugador;
    }
    //-------------------------------GET & SET----------------------------------
    
    //-------------------------------METODOS------------------------------------
    public Color getColor(int n){
        switch (n) {
            case 0:
                return new Color(0,0,0);//negro
            case 1:
                return new Color(0,0,255);//azul
            case 2:
                return new Color(255,0,0);//rojo
            case 3:
                return new Color(166, 123, 3);//amarillo
            default:
                return new Color(127,16,224);//morado, por si llega a fallar
        }
    }
    
    public void setMano(){
        jugador.actualizarFichas();
        for (int i = 0; i < jugador.getFichas().size(); i++) {
            Ficha ficha = jugador.getFichas().get(i);
            if (getPosLibreMano()!=null){
                JLabel pos = getPosLibreMano();
                pos.setText(""+ficha.getNum());
                pos.setForeground(getColor(ficha.getColor()));
            }else{
                System.out.println("No se pudo cargar la ficha, mano fullete");
            }
        }
    }
    
    public JLabel getPosLibreMano(){
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 13; j++) 
                if (matrizMano[i][j].getText().equals("")) 
                    return matrizMano[i][j];
        return null;
    }
    
    public void generarMatrizMesa (){
        int posX, posY = 0;
        for (int i = 0; i < 11; i++){
            posX = 0;
            for (int j = 0; j < 16; j++){
                matrizMesa[i][j] = new JLabel("");
                matrizMesa[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                matrizMesa[i][j].setHorizontalAlignment(JLabel.CENTER);
                matrizMesa[i][j].setLayout(null);
                matrizMesa[i][j].setSize(51,54);
                matrizMesa[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new Color(102, 102, 102)));
                JLabel label = matrizMesa[i][j];
                matrizMesa[i][j].addMouseListener(new MouseListener() {
                    
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(jugador.isTurno()){
                            int[] posicion = obtenerPosicionLabelClickeado(label,11,16);
                            int fila = posicion[0];
                            int columna = posicion[1];
                            if("".equals(label.getText()) ){//caso para acomodar mi jugada
                                if(jugador.getSelec1() != null){
                                    matrizMesa[fila][columna].setText(jugador.getSelec1().getNum()+"");
                                    matrizMesa[fila][columna].setForeground(getColor(jugador.getSelec1().getColor()));
                                    matrizMesa[jugador.getSelec1().getPosX()][jugador.getSelec1().getPosY()].setText("");
                                    jugador.setSelec1(null);
                                    return;
                                }
                                if(jugador.getSeleccionadas().size() == 1){
                                    matrizMesa[fila][columna].setText(jugador.getSeleccionadas().get(0).getNum()+"");
                                    matrizMesa[fila][columna].setForeground(getColor(jugador.getSeleccionadas().get(0).getColor()));
                                    jugador.getSeleccionadas().clear(); 
                                    return;
                                }
                                if(!jugador.getSeleccionadas().isEmpty()){
                                    System.out.println("FICHAS SELECCIONADAS");
                                    for (int i = 0; i < jugador.getSeleccionadas().size(); i++) {
                                        Ficha get = jugador.getSeleccionadas().get(i);
                                        System.out.println(get);
                                    }
                                    if(jugador.validarJugada(jugador.getSeleccionadas())){
                                        if(validarJugada(fila, columna, jugador.getSeleccionadas().size())){
                                            try {
                                                ArrayList<Ficha> nuevaJugada = jugador.getSeleccionadas();
                                                jugador.getSalida().writeInt(5);
                                                jugador.getSalida().writeUTF(jugador.getHostPartida());
                                                jugador.getSalida().writeInt(fila);
                                                jugador.getSalida().writeInt(columna);
                                                jugador.getSalida().writeInt(nuevaJugada.size());
                                                for(Ficha f: nuevaJugada)
                                                    jugador.getSalidaO().writeObject(f);
                                            } catch (IOException ex) {
                                                System.out.println("NO SE PUDO MANDAR LA SENHAL DE COLOCAR JUGADA EN LA MESA, OPCION 5");
                                            }
                                        }else
                                            JOptionPane.showMessageDialog(null, "Tu jugada no cabe en esa posicion", "Error, posicion incorrecta", ERROR_MESSAGE);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Jugada no valida", "JAJAJAJAJAJAJAJAJ", ERROR_MESSAGE);
                                        for(Ficha f : jugador.getSeleccionadas()){
                                            JLabel lbl = getPosLibreMano();
                                            jugador.getFichas().add(f);
                                            if(lbl != null){
                                                lbl.setText(f.getNum()+"");
                                                lbl.setForeground(getColor(f.getColor()));
                                            }
                                        }
                                    }
                                }else
                                    JOptionPane.showMessageDialog(null, "No hay nada seleccionado", "Error, posicion incorrecta", ERROR_MESSAGE);

                                jugador.getSeleccionadas().clear();
                            }else{//caso para reacomodar una jugada hecha
                                if(jugador.getSelec1() == null){
                                    jugador.setSelec1(getFichaFromLabel(matrizMesa[posicion[0]][posicion[1]], posicion[0], posicion[1]));
                                    System.out.println("FICHA 1 SELECCC:\n"+jugador.getSelec1());
                                }else if(jugador.getSelec2() == null){
                                    jugador.setSelec2(getFichaFromLabel(matrizMesa[posicion[0]][posicion[1]], posicion[0], posicion[1]));
                                    System.out.println("FICHA 1 SELECCC:\n"+jugador.getSelec2());
                                    matrizMesa[jugador.getSelec1().getPosX()][jugador.getSelec1().getPosY()].setText(jugador.getSelec2().getNum()+"");
                                    matrizMesa[jugador.getSelec1().getPosX()][jugador.getSelec1().getPosY()].setForeground(getColor(jugador.getSelec2().getColor()));
                                    matrizMesa[jugador.getSelec2().getPosX()][jugador.getSelec2().getPosY()].setText(jugador.getSelec1().getNum()+"");
                                    matrizMesa[jugador.getSelec2().getPosX()][jugador.getSelec2().getPosY()].setForeground(getColor(jugador.getSelec1().getColor()));
                                    jugador.setSelec1(null);
                                    jugador.setSelec2(null);
                                }else{
                                    matrizMesa[jugador.getSelec1().getPosX()][jugador.getSelec1().getPosY()].setText(jugador.getSelec2().getNum()+"");
                                    matrizMesa[jugador.getSelec1().getPosX()][jugador.getSelec1().getPosY()].setForeground(getColor(jugador.getSelec2().getColor()));
                                    matrizMesa[jugador.getSelec2().getPosX()][jugador.getSelec2().getPosY()].setText(jugador.getSelec1().getNum()+"");
                                    matrizMesa[jugador.getSelec2().getPosX()][jugador.getSelec2().getPosY()].setForeground(getColor(jugador.getSelec1().getColor()));
                                    jugador.setSelec1(null);
                                    jugador.setSelec2(null);
                                }
                            } 
                        }else
                            JOptionPane.showMessageDialog(null, "No estas en tu turno, achantela...", "Error, no puede tomar una ficha", ERROR_MESSAGE);
                               
                    }
                    
                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                });
                pnlMesa.add(matrizMesa[i][j]);
                matrizMesa[i][j].setLocation(posX, posY);
                posX += 51;
            }
            posY += 54;
        }
    }
    
    public Ficha getFichaFromLabel(JLabel lbl,int x,int y){
        if(!"".equals(lbl.getText())){
            int color;
            if(lbl.getForeground().equals(Color.BLACK)){
                color = 0;
            }else if(lbl.getForeground().equals(Color.BLUE)){
                color = 1;
            }else if(lbl.getForeground().equals(Color.RED)){
                color = 2;
            }else{
                color = 3;
            }
            if(lbl.getText().equals(":)")){
                Ficha ficha = new Ficha(0, color, true);
                ficha.setPosX(x);
                ficha.setPosY(y);
                return ficha;
            }else{
                Ficha ficha = new Ficha(Integer.parseInt(lbl.getText()),color, false);
                ficha.setPosX(x);
                ficha.setPosY(y);
                return ficha;
            }
        }
        return null; 
    }
    
    public void generarMatrizMano (){
        int posX, posY = 0;
        for (int i = 0; i < 3; i++){
            posX = 0;
            for (int j = 0; j < 13; j++){
                matrizMano[i][j] = new JLabel("");
                matrizMano[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                matrizMano[i][j].setHorizontalAlignment(JLabel.CENTER);
                matrizMano[i][j].setLayout(null);
                matrizMano[i][j].setSize(45,64);
                matrizMano[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                JLabel label = matrizMano[i][j];
                matrizMano[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(jugador.isTurno()){
                            int[] posicion = obtenerPosicionLabelClickeadoMano(label,3,13);
                            int r = posicion[0];
                            int c = posicion[1];
                            if(!"".equals(matrizMano[r][c].getText())){
                                Ficha ficha = getFichaFromLabel(label,r,c);
                                jugador.getSeleccionadas().add(ficha);
                                jugador.ordenarFichas(jugador.getSeleccionadas());
                                matrizMano[r][c].setText("");
                                jugador.quitarFichaMano(ficha);
                                refreshMano();
                                setMano();
                            }else
                                JOptionPane.showMessageDialog(null, "Nada seleccionado", "Nada seleccionado", ERROR_MESSAGE);
                        }else
                            JOptionPane.showMessageDialog(null, "No estas en tu turno, achantela...", "Error, no puede tomar una ficha", ERROR_MESSAGE);
                        
                        
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        label.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        label.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                    }
                });
                matrizMano[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                pnlMano.add(matrizMano[i][j]);
                matrizMano[i][j].setLocation(posX, posY);
                posX += 45;
            }
            posY += 64;
        }
    }
    
    public void agregarFichaMano(Ficha ficha){
        JLabel lbl = getPosLibreMano();
        if (lbl != null){
            lbl.setText(ficha.getNum()+"");
            lbl.setForeground(getColor(ficha.getColor()));
            jugador.getFichas().add(ficha);
        }else{
            JOptionPane.showMessageDialog(null, "No hay más campo en tu mano", "Error, no puede tomar una ficha", ERROR_MESSAGE);
        }
    }
    
    public int[] obtenerPosicionLabelClickeado(JLabel label,int r, int c) {
        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                if (matrizMesa[i][j] == label) {
                    int[] posicion = {i, j};
                    return posicion;
                }
        int[] noEncontrado = {-1, -1};
        return noEncontrado;
    }
    
    public int[] obtenerPosicionLabelClickeadoMano(JLabel label,int r, int c) {
        for (int i = 0; i < r; i++) 
            for (int j = 0; j < c; j++) 
                if (matrizMano[i][j] == label) {
                    int[] posicion = {i, j};
                    return posicion;
                }
        int[] noEncontrado = {-1, -1};
        return noEncontrado;
    }
    
    public boolean validarJugada(int r,int c,int largo){
        if(c != 0 && !"".equals(matrizMesa[r][c-1].getText())){
            return false;
        }else if(largo+c > 16){
            return false;
        }else if(largo+c == 16){
            largo--;
        }else{
            for (int i = c; i <= c+largo; i++) {
                if(!"".equals(matrizMesa[r][i].getText()))
                    return false;
            }
            return true;
        }
        return true;
        
    }
    
    public void pintarJugada(int r,int c,ArrayList<Ficha> jugada){
        int cont = 0;
        for (int i = c; i < c+jugada.size(); i++) {
            if (jugada.get(cont).isComodin())
                matrizMesa[r][i].setText(":)");
            else
                matrizMesa[r][i].setText(jugada.get(cont).getNum()+"");
            matrizMesa[r][i].setForeground(getColor(jugada.get(cont++).getColor()));
            matrizMesa[r][i].repaint();
            matrizMesa[r][i].revalidate();
            
        }
        pnlMesa.repaint();
        pnlMesa.revalidate();
        ArrayList<ArrayList<Ficha>> mesa = getArraysMesa();
        jugador.setMesa(mesa);
    }
    
    public boolean estaFichaEnMesa(Ficha f){
        for (int i = 0; i < jugador.getMesa().size(); i++) {
            ArrayList<Ficha> play = jugador.getMesa().get(i);
            for (int j = 0; j < play.size(); j++) {
                Ficha get = play.get(j);
                if(get.getNum() == f.getNum() && get.getColor()== f.getColor() && get.isComodin()== f.isComodin())
                    return true;
            }
        }
        return false;
    }
    
    public void refreshMesa(){
        for (int i = 0; i < 11; i++) 
            for (int j = 0; j < 16; j++) 
                matrizMesa[i][j].setText("");   
    }
    
    public void refreshMano(){
        for (int i = 0; i < 3; i++) 
            for (int j = 0; j < 13; j++) 
                matrizMano[i][j].setText("");
    }
    
    public ArrayList<ArrayList<Ficha>> getArraysMesa(){
        ArrayList<ArrayList<Ficha>> jugadas = new ArrayList <>();
        for (int i = 0; i < 11; i++) {
            ArrayList <Ficha> play = new ArrayList<>();
            for (int j = 0; j < 15; j++) {
                if (!"".equals(matrizMesa[i][j].getText())){
                    play.add(getFichaFromLabel(matrizMesa[i][j],i,j));
                    if(j == 14 && !"".equals(matrizMesa[i][j+1].getText())){
                        play.add(getFichaFromLabel(matrizMesa[i][j],i,j));
                    }
                    if ("".equals(matrizMesa[i][j+1].getText())||j ==14){
                        ArrayList <Ficha> playClone = (ArrayList <Ficha>)play.clone();
                        jugadas.add(playClone);
                        play.clear();
                    }
                }
            }
        }
        return jugadas;
    }
    
    public boolean mesaValida(ArrayList<ArrayList<Ficha>> mesa){
        for (int i = 0; i < mesa.size(); i++) {
            ArrayList<Ficha> get = mesa.get(i);
            if (!jugador.validarJugada(get))
                return false;
        }
        return true;
    }
    
    public void msgError(){
        JOptionPane.showMessageDialog(null, "No hay más fichas en el bote", "Error, no puede tomar una ficha", ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCogerMano;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnSalirPartida;
    private javax.swing.JButton btnTerminarTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnemigo1;
    private javax.swing.JLabel lblEnemigo2;
    private javax.swing.JLabel lblEnemigo3;
    private javax.swing.JPanel pnlMano;
    private javax.swing.JPanel pnlMesa;
    private javax.swing.JTextArea txaChat;
    private javax.swing.JTextField txfEnviar;
    // End of variables declaration//GEN-END:variables
}


package Partida;

import Jugador.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        this.setLayout(null);
        pnlMesa.setSize(816, 594);
        pnlMano.setSize(585, 192);
        System.out.println(pnlMesa.getSize());
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
        pnlMano = new javax.swing.JPanel();
        btnIniciarPartida = new javax.swing.JButton();
        btnSalirPartida = new javax.swing.JButton();
        btnCogerMano = new javax.swing.JButton();
        btnColocarFichas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEnemigo1.setText(". . .");

        lblEnemigo2.setText(". . .");

        lblEnemigo3.setText(". . . ");

        pnlMesa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa.setPreferredSize(new java.awt.Dimension(820, 500));

        javax.swing.GroupLayout pnlMesaLayout = new javax.swing.GroupLayout(pnlMesa);
        pnlMesa.setLayout(pnlMesaLayout);
        pnlMesaLayout.setHorizontalGroup(
            pnlMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlMesaLayout.setVerticalGroup(
            pnlMesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 621, Short.MAX_VALUE)
        );

        pnlMano.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnlManoLayout = new javax.swing.GroupLayout(pnlMano);
        pnlMano.setLayout(pnlManoLayout);
        pnlManoLayout.setHorizontalGroup(
            pnlManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
        pnlManoLayout.setVerticalGroup(
            pnlManoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 209, Short.MAX_VALUE)
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

        btnColocarFichas.setText("Colocar");
        btnColocarFichas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColocarFichasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEnemigo1)
                .addGap(444, 444, 444))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblEnemigo3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIniciarPartida)
                                    .addComponent(btnSalirPartida))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(btnCogerMano, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnColocarFichas)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(pnlMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblEnemigo2)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEnemigo3)
                            .addComponent(lblEnemigo2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblEnemigo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnIniciarPartida)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSalirPartida)
                            .addGap(73, 73, 73)
                            .addComponent(btnColocarFichas))
                        .addComponent(pnlMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCogerMano, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
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
            //getBtnIniciarPartida().setVisible(false);
            jugador.getSalida().writeInt(3);
            jugador.getSalida().writeUTF(jugador.getHostPartida());
            System.out.println("Punto buscado justo abajo: ");
            for (int i = 0; i < jugador.getFichas().size(); i++) {
                Ficha ficha = jugador.getFichas().get(i);
                System.out.println(ficha);
            }
        } catch (IOException ex) {
            System.out.println("COCOS LOCOS");
        }
    }//GEN-LAST:event_btnIniciarPartidaActionPerformed

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

    private void btnColocarFichasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColocarFichasActionPerformed
        if(jugador.isTurno()){
            if(jugador.validarJugada()){
                
            }else
                JOptionPane.showMessageDialog(null, "Jugada no valida, sobo...", "Error, jugada no valida", ERROR_MESSAGE);
            
        }else
            JOptionPane.showMessageDialog(null, "No estas en tu turno, achantela...", "Error, sin turno", ERROR_MESSAGE);
        
        
    }//GEN-LAST:event_btnColocarFichasActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartidaGUI().setVisible(true);
            }
        });
    }

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
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 13; j++) {
                if (matrizMano[i][j].getText().equals("")) {
                    return matrizMano[i][j];
                }
            }
        }
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
                        if(label.getText() == "" ){//caso para acomodar mi jugada
                            if(jugador.getSeleccionadas().size() != 0){
                                System.out.println("FICHAS SELECCIONADAS");
                                for (int i = 0; i < jugador.getSeleccionadas().size(); i++) {
                                    
                                    Ficha get = jugador.getSeleccionadas().get(i);
                                    System.out.println(get);

                                }
                                int[] posicion = obtenerPosicionLabelClickeado(label);
                                if (posicion[0] != -1 && posicion[1] != -1) {
                                    int fila = posicion[0];
                                    int columna = posicion[1];
                                    System.out.println("FILA,COL: " + fila+","+columna);
                                    
                                    if(jugador.validarJugada()){
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
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Tu jugada no cabe en esa posicion", "Error, posicion incorrecta", ERROR_MESSAGE);
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Jugada no valida", "JAJAJAJAJAJAJAJAJ", ERROR_MESSAGE);
                                    }   
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "No hay nada seleccionado", "Error, posicion incorrecta", ERROR_MESSAGE);
                            }
                            jugador.getSeleccionadas().clear();
                        }else{//caso para reacomodar una jugada hecha
                            jugador.getSeleccionadas().clear();
                        }
                        
                        // Obtiene el texto y el color del JLabel cuando se hace clic en él
                        String labelText = label.getText();
                        Color labelColor = label.getForeground();
                        
                        
                    }

                    // Implementa otros métodos del MouseListener
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
                        // Obtiene el texto y el color del JLabel cuando se hace clic en él
                        String labelText = label.getText();
                        Color labelColor = label.getForeground();
                        System.out.println("Texto: " + labelText);
                        System.out.println("Color de foreground: " + labelColor);
                        int color = 0;
                        if(labelColor.equals(Color.BLACK)){
                            color = 0;
                        }else if(labelColor.equals(Color.BLUE)){
                            color = 1;
                        }else if(labelColor.equals(Color.RED)){
                            color = 2;
                        }else{
                            color = 3;
                        }
                        if(labelText.equals("0")){
                            jugador.getSeleccionadas().add(new Ficha(0,0, true));
                        }else{
                            jugador.getSeleccionadas().add(new Ficha(Integer.parseInt(labelText),color, false));
                        }
                        System.out.println("Sout inicial");
                        jugador.ordenarFichas();
                    }

                    // Implementa otros métodos del MouseListener
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
        }else{
            JOptionPane.showMessageDialog(null, "No hay más campo en tu mano", "Error, no puede tomar una ficha", ERROR_MESSAGE);
        }
    }
    
    public int[] obtenerPosicionLabelClickeado(JLabel label) {
        for (int i = 0; i < 11; i++) 
            for (int j = 0; j < 16; j++) 
                if (matrizMesa[i][j] == label) {
                    int[] posicion = {i, j};
                    return posicion;
                }
        int[] noEncontrado = {-1, -1};
        return noEncontrado;
    }
    
    public boolean validarJugada(int r,int c,int largo){
        System.out.println("R: " + r + " C: " + c + "Largo: " + largo );
        if(c != 0 && !"".equals(matrizMesa[r][c-1].getText())){
            System.out.println("CASO1");
            return false;
        }else if(largo+c > 16){
            System.out.println("CASO2");
            return false;
        }else if(largo+c == 16){
            System.out.println("CASO3");
            largo--;
        }else{
            System.out.println("CASO4");
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
            System.out.println("fila,columna:  "+r+","+i);
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
    }
    
    public void msgError(){
        JOptionPane.showMessageDialog(null, "No hay más fichas en el bote", "Error, no puede tomar una ficha", ERROR_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCogerMano;
    private javax.swing.JButton btnColocarFichas;
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnSalirPartida;
    private javax.swing.JLabel lblEnemigo1;
    private javax.swing.JLabel lblEnemigo2;
    private javax.swing.JLabel lblEnemigo3;
    private javax.swing.JPanel pnlMano;
    private javax.swing.JPanel pnlMesa;
    // End of variables declaration//GEN-END:variables
}

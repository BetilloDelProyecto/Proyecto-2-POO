
package Partida;

import Jugador.*;
import java.awt.Color;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

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
                        .addComponent(pnlMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblEnemigo2)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIniciarPartida)
                            .addComponent(btnSalirPartida))
                        .addContainerGap(104, Short.MAX_VALUE))))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnIniciarPartida)
                        .addGap(30, 30, 30)
                        .addComponent(btnSalirPartida)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pnlMano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
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
                return new Color(245,241,12);//amarillo
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
                //matrizMesa[i][j].setOpaque(true);
                matrizMesa[i][j].setLayout(null);
                matrizMesa[i][j].setSize(51,54);
                matrizMesa[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
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
                //matrizMano[i][j].setOpaque(true);
                matrizMano[i][j].setLayout(null);
                matrizMano[i][j].setSize(45,64);
                matrizMano[i][j].setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
                pnlMano.add(matrizMano[i][j]);
                matrizMano[i][j].setLocation(posX, posY);
                posX += 45;
            }
            posY += 64;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarPartida;
    private javax.swing.JButton btnSalirPartida;
    private javax.swing.JLabel lblEnemigo1;
    private javax.swing.JLabel lblEnemigo2;
    private javax.swing.JLabel lblEnemigo3;
    private javax.swing.JPanel pnlMano;
    private javax.swing.JPanel pnlMesa;
    // End of variables declaration//GEN-END:variables
}

package Jugador;

import Partida.PartidaGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

public class FrameLobby extends javax.swing.JFrame implements Serializable{
    Jugador jugador;
    
    //--------------------------------------CONSTRUCTOR
    public FrameLobby() {
        try {
            initComponents();
            setLayout(null);
            jugador = new Jugador(this);
            jugador.conexion(1025);
            jugador.salida.writeInt(1);
            jugador.salida.writeUTF("");
            
            lstServidores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList<String> list = (JList<String>) e.getSource();
                    int selectedIndex = list.getSelectedIndex();
                    if (selectedIndex >= 0) {
                        DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
                        String svSelected = model.getElementAt(selectedIndex);
                        System.out.println("Doble clic en: " + svSelected);
                    }
                }
            }
            });
            
        } catch (IOException ex){
            
        }
    }
    
    public void refreshDefensesListBox(ArrayList<String> partidas){
        limpiarDefensasListBox();
        DefaultListModel<String> modelo = (DefaultListModel<String>) lstServidores.getModel();
        for (int i = 0; i < partidas.size(); i++) 
            modelo.addElement(partidas.get(i));
    }

    public void limpiarDefensasListBox(){
        DefaultListModel modelo = new DefaultListModel();
        lstServidores.setModel(modelo); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNickName = new javax.swing.JLabel();
        txfNickName = new javax.swing.JTextField();
        lblBuscarLobby = new javax.swing.JLabel();
        lblCrearLobby = new javax.swing.JLabel();
        lblTamano = new javax.swing.JLabel();
        cbxTamanho = new javax.swing.JComboBox<>();
        btnCrearLobby = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstServidores = new javax.swing.JList<>();
        btnScores = new javax.swing.JButton();
        btnUnirseLobby = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNickName.setText("Nick Name:");

        txfNickName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNickNameActionPerformed(evt);
            }
        });

        lblBuscarLobby.setText("Lobbies:");

        lblCrearLobby.setText("Crear Lobby");

        lblTamano.setText("Tamano:");

        cbxTamanho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));
        cbxTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTamanhoActionPerformed(evt);
            }
        });

        btnCrearLobby.setText("Crear");
        btnCrearLobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearLobbyActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(lstServidores);

        btnScores.setText("Scores");

        btnUnirseLobby.setText("Unirse");
        btnUnirseLobby.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnirseLobbyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnUnirseLobby)
                            .addComponent(lblCrearLobby)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnScores, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(32, 32, 32)
                                            .addComponent(lblBuscarLobby))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txfNickName))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCrearLobby)
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfNickName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNickName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBuscarLobby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnUnirseLobby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCrearLobby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTamano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrearLobby)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnScores)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNickNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNickNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNickNameActionPerformed
    
    private void btnCrearLobbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearLobbyActionPerformed
        try {
            this.setVisible(false);
            jugador.setNomCliente(txfNickName.getText());
            jugador.salida.writeInt(1);
            jugador.salida.writeUTF(txfNickName.getText());
            jugador.setVentanaPartida(new PartidaGUI());
            jugador.getVentanaPartida().setVisible(true);
            jugador.getVentanaPartida().setJugador(jugador);
            jugador.getVentanaPartida().getLblEnemigo1().setText(jugador.getNomCliente());
            jugador.salida.writeUTF(txfNickName.getText());
            jugador.getVentanaPartida().getBtnSalirPartida().setText("Cerrar Lobby");
            jugador.setHostPartida(jugador.getNomCliente());
            
        } catch (IOException ex) {
            System.out.println("No se pudo crear la lobby");
        }
    }//GEN-LAST:event_btnCrearLobbyActionPerformed

    private void cbxTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTamanhoActionPerformed

    private void btnUnirseLobbyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnirseLobbyActionPerformed
        if(lstServidores.getSelectedValue()!=null){
            try {
                this.setVisible(false);
                jugador.setNomCliente(txfNickName.getText());
                jugador.salida.writeInt(2);
                jugador.salida.writeUTF(txfNickName.getText());
                jugador.salida.writeUTF(lstServidores.getSelectedValue());
                jugador.setVentanaPartida(new PartidaGUI());
                jugador.getVentanaPartida().setVisible(true);
                jugador.getVentanaPartida().getBtnIniciarPartida().setVisible(false);
                jugador.getVentanaPartida().setJugador(jugador);
                
                
            } catch (IOException ex) {
                System.out.println("No se pudo unir a la lobby");
            }
        }
    }//GEN-LAST:event_btnUnirseLobbyActionPerformed
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameLobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameLobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameLobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameLobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameLobby().setVisible(true);
            }
        });
    }

    public JLabel getLblNickName() {
        return lblNickName;
    }

    public void setLblNickName(JLabel lblNickName) {
        this.lblNickName = lblNickName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearLobby;
    private javax.swing.JButton btnScores;
    private javax.swing.JButton btnUnirseLobby;
    private javax.swing.JComboBox<String> cbxTamanho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscarLobby;
    private javax.swing.JLabel lblCrearLobby;
    private javax.swing.JLabel lblNickName;
    private javax.swing.JLabel lblTamano;
    private javax.swing.JList<String> lstServidores;
    private javax.swing.JTextField txfNickName;
    // End of variables declaration//GEN-END:variables
}
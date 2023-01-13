/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Players;

import static Players.PlayerO.turn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author walla
 */
public class PlayerX extends javax.swing.JFrame {

    /**
     * Creates new form Player2
     */
    
    static String turn = "inicio";
    
    public PlayerX() {
        initComponents();
        setTitle("JOGADOR X");
        
        new Thread(()->{
            try {   
                //para receber dados do controller no geral
                ServerSocket reading_playerX_controller = new ServerSocket(5050);
                String controller_data;
                //para receber turno inicial do controller
                ServerSocket read_initial_turn = new ServerSocket(7070);
                Socket send_initial_turn_toX = read_initial_turn.accept();
                ObjectInputStream data_initial_turn = new ObjectInputStream(send_initial_turn_toX.getInputStream());
                turn = data_initial_turn.readUTF();
                read_initial_turn.close();
                send_initial_turn_toX.close();
                
                
                while(true){
                    System.out.println(turn);
                    Socket controller_sending_playerX = reading_playerX_controller.accept();
                    ObjectInputStream data_receiving_controller  = new ObjectInputStream(controller_sending_playerX.getInputStream());
                    turn = data_receiving_controller.readUTF();
                    controller_data = data_receiving_controller.readUTF();
                    System.out.println(turn);
                    System.out.println(controller_data);
                    //verificações
                    switch (controller_data) {
                           case "upLeft-X" -> {
                               upLeft.setText("X");
                               upLeft.setEnabled(false);
                           }
                           case "upMid-X" -> {
                               upMid.setText("X");
                               upMid.setEnabled(false);
                           }
                           case "upRight-X" -> {
                               upRight.setText("X");
                               upRight.setEnabled(false);
                           }
                           case "centerLeft-X" -> {
                               centerLeft.setText("X");
                               centerLeft.setEnabled(false);
                           }
                           case "centerMid-X" -> {
                               centerMid.setText("X");
                               centerMid.setEnabled(false);
                           }
                           case "centerRight-X" -> {
                               centerRight.setText("X");
                               centerRight.setEnabled(false);
                           }
                           case "downLeft-X" -> {
                               downLeft.setText("X");
                               downLeft.setEnabled(false);
                           }
                           case "downMid-X" -> {
                               downMid.setText("X");
                               downMid.setEnabled(false);
                           }
                           case "downRight-X" -> {
                               downRight.setText("X");
                               downRight.setEnabled(false);
                           }
                           case "upLeft-O" -> {
                               upLeft.setText("O");
                               upLeft.setEnabled(false);
                           }
                           case "upMid-O" -> {
                               upMid.setText("O");
                               upMid.setEnabled(false);
                           }
                           case "upRight-O" -> {
                               upRight.setText("O");
                               upRight.setEnabled(false);
                           }
                           case "centerLeft-O" -> {
                               centerLeft.setText("O");
                               centerLeft.setEnabled(false);
                           }
                           case "centerMid-O" -> {
                               centerMid.setText("O");
                               centerMid.setEnabled(false);
                           }
                           case "centerRight-O" -> {
                               centerRight.setText("O");
                               centerRight.setEnabled(false);
                           }
                           case "downLeft-O" -> {
                               downLeft.setText("O");
                               downLeft.setEnabled(false);
                           }
                           case "downMid-O" -> {
                               downMid.setText("O");
                               downMid.setEnabled(false);
                           }
                           case "downRight-O" -> {
                               downRight.setText("O");
                               downRight.setEnabled(false);
                           }
                           default -> {
                           }
                       }
                    
                    controller_sending_playerX.close();
                    data_receiving_controller.close();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Erro player X:" + e);
            }
        }).start();
        
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        upMid = new javax.swing.JButton();
        centerMid = new javax.swing.JButton();
        downMid = new javax.swing.JButton();
        upRight = new javax.swing.JButton();
        centerLeft = new javax.swing.JButton();
        centerRight = new javax.swing.JButton();
        downLeft = new javax.swing.JButton();
        upLeft = new javax.swing.JButton();
        downRight = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSeparator1.setOpaque(true);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator6.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        upMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upMidActionPerformed(evt);
            }
        });

        centerMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centerMidActionPerformed(evt);
            }
        });

        downMid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downMidActionPerformed(evt);
            }
        });

        upRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upRightActionPerformed(evt);
            }
        });

        centerLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centerLeftActionPerformed(evt);
            }
        });

        centerRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                centerRightActionPerformed(evt);
            }
        });

        downLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downLeftActionPerformed(evt);
            }
        });

        upLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upLeftActionPerformed(evt);
            }
        });

        downRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downRightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(upLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(centerLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(upMid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downMid, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(centerMid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upRight, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(centerRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator6, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(upRight, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(upLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(centerLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(downLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(centerRight, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(downRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(upMid, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(centerMid, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(downMid, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(208, 208, 208)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(97, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(101, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(202, 202, 202)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void centerMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centerMidActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("centerMid-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }

    }//GEN-LAST:event_centerMidActionPerformed

    private void centerRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centerRightActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("centerRight-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }    
    }//GEN-LAST:event_centerRightActionPerformed

    private void upLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upLeftActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("upLeft-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }
    }//GEN-LAST:event_upLeftActionPerformed

    private void upMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upMidActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("upMid-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
       }
    }//GEN-LAST:event_upMidActionPerformed

    private void upRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upRightActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("upRight-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }
    }//GEN-LAST:event_upRightActionPerformed

    private void centerLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_centerLeftActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("centerLeft-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }
    }//GEN-LAST:event_centerLeftActionPerformed

    private void downLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downLeftActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("downLeft-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }
    }//GEN-LAST:event_downLeftActionPerformed

    private void downMidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downMidActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("downMid-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }
    }//GEN-LAST:event_downMidActionPerformed

    private void downRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downRightActionPerformed
        if(turn.equals("X")){
            new Thread(()->{
               try{
                   Socket playerX_sending = new Socket("127.0.0.1", 3030);
                   ObjectOutputStream playerX_data = new ObjectOutputStream(playerX_sending.getOutputStream());
                   playerX_data.flush();
                   playerX_data.writeUTF("downRight-X");

                   //Finaliza ObjectOutputStream e Socket
                   playerX_data.close();    
                   playerX_sending.close();
               }catch(Exception e){
                   JOptionPane.showMessageDialog(null,"Erro Botão do PlayerX: " + e);
               }
           }).start();
        }
    }//GEN-LAST:event_downRightActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(PlayerX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayerX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayerX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayerX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlayerX().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton centerLeft;
    private javax.swing.JButton centerMid;
    private javax.swing.JButton centerRight;
    private javax.swing.JButton downLeft;
    private javax.swing.JButton downMid;
    private javax.swing.JButton downRight;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton upLeft;
    private javax.swing.JButton upMid;
    private javax.swing.JButton upRight;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Services.servicesBookDeliverySettings;
import Services.texts;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahri
 */
public class adminBookDeliverySettings extends javax.swing.JFrame {

    public static int bookDeliveryTime;
    public static int lateDeliveryPenalty;
    public static int takeBookLimit;

    /**
     * Creates new form adminBookDeliverySettings
     */
    public adminBookDeliverySettings() {
        initComponents();

        List();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDeliveryTimeLimit = new javax.swing.JLabel();
        lblLateDeliveryPenalty = new javax.swing.JLabel();
        txtLateDeliveryPenalty = new javax.swing.JTextField();
        lblTakeBookLimit = new javax.swing.JLabel();
        txtTakeBookLimit = new javax.swing.JTextField();
        txtDeliveryTimeLimit = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        backPage = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookDeliverySettings = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(new texts().panelBookDeliverySetting());

        lblDeliveryTimeLimit.setText(new texts().deliveryTimeLimit());

        lblLateDeliveryPenalty.setText(new texts().lateDeliveryPenalty());

        lblTakeBookLimit.setText(new texts().takeBookLimit());

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        btnSave.setText(new texts().save());
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLateDeliveryPenalty)
                            .addComponent(lblDeliveryTimeLimit)
                            .addComponent(lblTakeBookLimit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTakeBookLimit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLateDeliveryPenalty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDeliveryTimeLimit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDeliveryTimeLimit)
                    .addComponent(txtDeliveryTimeLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLateDeliveryPenalty)
                    .addComponent(txtLateDeliveryPenalty, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTakeBookLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTakeBookLimit))
                .addGap(40, 40, 40)
                .addComponent(btnSave)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        backPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back.png"))); // NOI18N
        backPage.setToolTipText("");
        backPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backPageActionPerformed(evt);
            }
        });

        tblBookDeliverySettings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ));
        tblBookDeliverySettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookDeliverySettingsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBookDeliverySettings);
        if (tblBookDeliverySettings.getColumnModel().getColumnCount() > 0) {
            tblBookDeliverySettings.getColumnModel().getColumn(0).setHeaderValue(new texts().ID());
            tblBookDeliverySettings.getColumnModel().getColumn(1).setHeaderValue(new texts().deliveryTimeLimit());
            tblBookDeliverySettings.getColumnModel().getColumn(2).setHeaderValue(new texts().lateDeliveryPenalty());
            tblBookDeliverySettings.getColumnModel().getColumn(3).setHeaderValue(new texts().takeBookLimit());
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(backPage, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(backPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(339, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        int ID = 1;
        String bookDeliveryTimeString = txtDeliveryTimeLimit.getText().trim();
        String lateDeliveryPenaltyString = txtLateDeliveryPenalty.getText().trim();
        String takeBookLimitString = txtTakeBookLimit.getText().trim();
        bookDeliveryTime = Integer.parseInt(bookDeliveryTimeString);
        lateDeliveryPenalty = Integer.parseInt(lateDeliveryPenaltyString);
        takeBookLimit = Integer.parseInt(takeBookLimitString);
        new servicesBookDeliverySettings().vtUpdate(ID, bookDeliveryTime, lateDeliveryPenalty, takeBookLimit);
        List();

    }//GEN-LAST:event_btnSaveActionPerformed

    private void backPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backPageActionPerformed
        // TODO add your handling code here:
        adminMainPanel panel = new adminMainPanel();
        panel.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backPageActionPerformed

    private void tblBookDeliverySettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookDeliverySettingsMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tblBookDeliverySettings.getModel();
        int selected = tblBookDeliverySettings.getSelectedRow();
        txtDeliveryTimeLimit.setText(model.getValueAt(selected, 1).toString());
        txtLateDeliveryPenalty.setText(model.getValueAt(selected, 2).toString());
        txtTakeBookLimit.setText(model.getValueAt(selected, 3).toString());

    }//GEN-LAST:event_tblBookDeliverySettingsMouseClicked

    public void List() {
        DefaultTableModel model = (DefaultTableModel) tblBookDeliverySettings.getModel();
        new servicesBookDeliverySettings().bring(model);
    }

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
            java.util.logging.Logger.getLogger(adminBookDeliverySettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminBookDeliverySettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminBookDeliverySettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminBookDeliverySettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminBookDeliverySettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backPage;
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeliveryTimeLimit;
    private javax.swing.JLabel lblLateDeliveryPenalty;
    private javax.swing.JLabel lblTakeBookLimit;
    private javax.swing.JTable tblBookDeliverySettings;
    private javax.swing.JTextField txtDeliveryTimeLimit;
    private javax.swing.JTextField txtLateDeliveryPenalty;
    private javax.swing.JTextField txtTakeBookLimit;
    // End of variables declaration//GEN-END:variables
}

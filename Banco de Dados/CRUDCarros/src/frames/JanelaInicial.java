/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package frames;

public class JanelaInicial extends javax.swing.JFrame {
    
    private String responsabilidade = "total";

   
    public JanelaInicial() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public JanelaInicial(String responsabilidade){
        this.responsabilidade = responsabilidade;
        initComponents();
        desabilitarOpcoes();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelFundo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuControles = new javax.swing.JMenu();
        itemMenuCliente = new javax.swing.JMenuItem();
        itemMenuVendedor = new javax.swing.JMenuItem();
        itemMenuCarro = new javax.swing.JMenuItem();
        itemMenuConcessionária = new javax.swing.JMenuItem();
        itemMenuEncomenda = new javax.swing.JMenuItem();
        itemMenuFabricantes = new javax.swing.JMenuItem();
        itemMenuVendas = new javax.swing.JMenuItem();
        itemMenuCarrosDisponiveis = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelFundo.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(255, 221, 0), null, null), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, null, new java.awt.Color(1, 1, 1), new java.awt.Color(255, 157, 0))));
        painelFundo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        painelFundo.setMinimumSize(new java.awt.Dimension(600, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fundo_1.jpeg"))); // NOI18N

        javax.swing.GroupLayout painelFundoLayout = new javax.swing.GroupLayout(painelFundo);
        painelFundo.setLayout(painelFundoLayout);
        painelFundoLayout.setHorizontalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, Short.MAX_VALUE)
        );
        painelFundoLayout.setVerticalGroup(
            painelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFundoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        menuControles.setText("Controles");

        itemMenuCliente.setText("Cliente");
        itemMenuCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuClienteActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuCliente);

        itemMenuVendedor.setText("Vendedor");
        itemMenuVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuVendedorActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuVendedor);

        itemMenuCarro.setText("Carro");
        itemMenuCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCarroActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuCarro);

        itemMenuConcessionária.setText("Concessionária");
        itemMenuConcessionária.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuConcessionáriaActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuConcessionária);

        itemMenuEncomenda.setText("Encomenda");
        itemMenuEncomenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuEncomendaActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuEncomenda);

        itemMenuFabricantes.setText("Fabricantes");
        itemMenuFabricantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuFabricantesActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuFabricantes);

        itemMenuVendas.setText("Venda");
        itemMenuVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuVendasActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuVendas);

        itemMenuCarrosDisponiveis.setText("Carros Disponíveis");
        itemMenuCarrosDisponiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCarrosDisponiveisActionPerformed(evt);
            }
        });
        menuControles.add(itemMenuCarrosDisponiveis);

        jMenuBar1.add(menuControles);

        jMenu3.setText("Operações do BD");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Janela De Operações do Banco de Dados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFundo, javax.swing.GroupLayout.PREFERRED_SIZE, 452, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuClienteActionPerformed
        JanelaClientes jan = new JanelaClientes();
        jan.setVisible(true);
    }//GEN-LAST:event_itemMenuClienteActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        JanelaOperacoesBD janBD = new JanelaOperacoesBD();
        janBD.setVisible(true);
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JanelaOperacoesBD janBD = new JanelaOperacoesBD();
        janBD.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void itemMenuCarrosDisponiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCarrosDisponiveisActionPerformed
        JanelaCarrosDisponiveis janCar = new JanelaCarrosDisponiveis();
        janCar.setVisible(true);
    }//GEN-LAST:event_itemMenuCarrosDisponiveisActionPerformed

    private void itemMenuVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuVendasActionPerformed
        JanelaVenda janVen = new JanelaVenda();
        janVen.setVisible(true);
    }//GEN-LAST:event_itemMenuVendasActionPerformed

    private void itemMenuFabricantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuFabricantesActionPerformed
        JanelaFabricantes janFab = new JanelaFabricantes();
        janFab.setVisible(true);
    }//GEN-LAST:event_itemMenuFabricantesActionPerformed

    private void itemMenuEncomendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuEncomendaActionPerformed
        JanelaEncomenda janEnc = new JanelaEncomenda();
        janEnc.setVisible(true);
    }//GEN-LAST:event_itemMenuEncomendaActionPerformed

    private void itemMenuConcessionáriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuConcessionáriaActionPerformed
        JanelaConcessionaria janCon = new JanelaConcessionaria();
        janCon.setVisible(true);
    }//GEN-LAST:event_itemMenuConcessionáriaActionPerformed

    private void itemMenuCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCarroActionPerformed
       JanelaCarro janCar = new JanelaCarro();
       janCar.setVisible(true);
    }//GEN-LAST:event_itemMenuCarroActionPerformed

    private void itemMenuVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuVendedorActionPerformed
       JanelaVendedores janVen = new JanelaVendedores();
       janVen.setVisible(true);
    }//GEN-LAST:event_itemMenuVendedorActionPerformed

     public final void desabilitarOpcoes(){
        if(this.responsabilidade.toLowerCase().equals("vendedor")){
            itemMenuVendedor.setArmed(false);
        }
    }
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
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemMenuCarro;
    private javax.swing.JMenuItem itemMenuCarrosDisponiveis;
    private javax.swing.JMenuItem itemMenuCliente;
    private javax.swing.JMenuItem itemMenuConcessionária;
    private javax.swing.JMenuItem itemMenuEncomenda;
    private javax.swing.JMenuItem itemMenuFabricantes;
    private javax.swing.JMenuItem itemMenuVendas;
    private javax.swing.JMenuItem itemMenuVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuControles;
    private javax.swing.JPanel painelFundo;
    // End of variables declaration//GEN-END:variables
}

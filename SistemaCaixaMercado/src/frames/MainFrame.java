package frames;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.plaf.basic.BasicLookAndFeel;
import sistemacaixamercado.SistemaCaixaMercado;

class Theme {

    static void install() {
        FlatLightLaf.install();
    }

    static BasicLookAndFeel theme() {
        return new FlatLightLaf();
    }
}

/**
 * JFrame da tela principal
 *
 * @author Leonardo
 */
public class MainFrame extends javax.swing.JFrame {

    private SistemaCaixaMercado mercado;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        mercado = new SistemaCaixaMercado();
        Theme.install();

        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estatisticasBtn = new javax.swing.JButton();
        produtosBtn = new javax.swing.JButton();
        clientesBtn = new javax.swing.JButton();
        compraBtn = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caixa de Mercado");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/dairy-products-64.png")).getImage());

        estatisticasBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        estatisticasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analytics-64.png"))); // NOI18N
        estatisticasBtn.setText("Estatísticas");

        produtosBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        produtosBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dairy-products-64.png"))); // NOI18N
        produtosBtn.setText("Produtos");
        produtosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosBtnActionPerformed(evt);
            }
        });

        clientesBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clientesBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clients-64.png"))); // NOI18N
        clientesBtn.setText("Clientes");

        compraBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        compraBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/online-shopping-64.png"))); // NOI18N
        compraBtn.setText("Nova Compra");
        compraBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraBtnActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Caixa");
        titleLabel.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(produtosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(compraBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estatisticasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clientesBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(produtosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compraBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estatisticasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void produtosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosBtnActionPerformed
        new ProdutosFrame(this, mercado.getBd(), mercado.getProdutos()).setVisible(true);
    }//GEN-LAST:event_produtosBtnActionPerformed

    private void compraBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraBtnActionPerformed
        new CompraFrame(this, mercado.getProdutos(), carrinho -> {
            if (carrinho == null) {
                return;
            }

        }).setVisible(true);
    }//GEN-LAST:event_compraBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(Theme.theme());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientesBtn;
    private javax.swing.JButton compraBtn;
    private javax.swing.JButton estatisticasBtn;
    private javax.swing.JButton produtosBtn;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

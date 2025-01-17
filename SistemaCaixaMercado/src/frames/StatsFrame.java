/*
 * Copyright (C) 2020 Leonardo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package frames;

import javax.swing.JFrame;
import sistemacaixamercado.Estatisticas;
import sistemacaixamercado.Produto;

/**
 * Mostra as estatísticas armazenadas
 *
 * @author Leonardo
 */
public class StatsFrame extends ChildFrame {

    private final Estatisticas stats;

    /**
     * Creates new form StatsFrame
     */
    public StatsFrame(JFrame parent, Estatisticas stats) {
        super(parent);
        this.stats = stats;
        initComponents();
        setLocationRelativeTo(null);

        calcStats();
    }

    /**
     * Adiciona o texto `text` à label `label`
     *
     * @param label
     * @param text
     */
    private void appendToLabel(javax.swing.JLabel label, Object text) {
        label.setText(label.getText() + " " + text);
    }

    /**
     * Calcula as estatísticas e mostra nos JLabels
     */
    private void calcStats() {
        double media = stats.mediaTotais();
        double variancia = stats.varTotais(media);
        int total = stats.sumTotais();
        int qtd = stats.totalQtdProdutos();

        appendToLabel(mediaLabel, Produto.strPreco((int)Math.round(media)));
        appendToLabel(varLabel, Produto.strPreco((int)Math.round(variancia)));
        appendToLabel(totalLabel, Produto.strPreco(total));
        appendToLabel(qtdLabel, qtd);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        qtdLabel = new javax.swing.JLabel();
        mediaLabel = new javax.swing.JLabel();
        varLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estatísticas");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/dairy-products-64.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analytics-64.png"))); // NOI18N
        jLabel1.setText("Estatísticas");

        qtdLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        qtdLabel.setText("Quantidade de produtos comprados:");

        mediaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mediaLabel.setText("Média dos totais dos carrinhos:");

        varLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        varLabel.setText("Variância dos totais dos carrinhos:");

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalLabel.setText("Total gasto:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtdLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                            .addComponent(totalLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(varLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mediaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mediaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(varLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qtdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mediaLabel;
    private javax.swing.JLabel qtdLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel varLabel;
    // End of variables declaration//GEN-END:variables
}

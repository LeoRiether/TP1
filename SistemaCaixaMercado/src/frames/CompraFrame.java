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

import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sistemacaixamercado.Carrinho;
import sistemacaixamercado.ItemCarrinho;
import sistemacaixamercado.Produto;
import sistemacaixamercado.ProdutoComDesconto;

/**
 * Um Callback é utilizado para mandar dados da compra realizada para a janela
 * que criou o CompraFrame. O método `callback` é chamado assim que a janela de
 * compra é fechada.
 *
 * @author Leonardo
 */
interface Callback {

    public void callback(Carrinho carrinho);
}

/**
 *
 * @author Leonardo
 */
public class CompraFrame extends ChildFrame {

    private ArrayList<Produto> produtos;
    private Carrinho carrinho;
    private Callback cb;

    /**
     * Creates new form CompraFrame
     * @param parent o frame que criou o CompraFrame
     * @param produtos os produtos cadastrados
     * @param cb um callback, chamado quando a compra é finalizada
     */
    public CompraFrame(JFrame parent, ArrayList<Produto> produtos, Callback cb) {
        super(parent);
        this.produtos = produtos;
        this.carrinho = new Carrinho();
        this.cb = cb;

        initComponents();
        setLocationRelativeTo(null);

        initAddCombo();
        updateView();
        addRng();
    }

    /**
     * Atualiza a lista de itens no carrinho e o preço total
     */
    private void updateView() {
        DefaultListModel model = new DefaultListModel();
        int precoTotal = 0;
        for (ItemCarrinho item : carrinho.getItens()) {
            model.addElement(item);
            precoTotal += carrinho.precoComDesconto(item);
        }
        itensList.setModel(model);
        
        totalLabel.setText(Produto.strPreco(precoTotal));
    }

    /**
     * Coloca o gerador de números aleatórios apropriado nos produtos com
     * desconto
     */
    private void addRng() {
        Random rng = new Random();
        for (Produto p : produtos) {
            if (p instanceof ProdutoComDesconto) {
                ((ProdutoComDesconto) p).setRng(rng);
            }
        }
    }

    /**
     * Inicializa a addComboBox
     */
    private void initAddCombo() {
        addComboBox.removeAllItems();
        for (Produto p : produtos) {
            addComboBox.addItem(p.getNome());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        itensList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        addComboBox = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        doneBtn = new javax.swing.JButton();
        rmBtn = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nova Compra");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/images/online-shopping-64.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/online-shopping-32.png"))); // NOI18N
        jLabel1.setText("Nova Compra");

        itensList.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        itensList.setCellRenderer(new ItemCarrinhoRenderer(carrinho));
        jScrollPane1.setViewportView(itensList);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/market.jpg"))); // NOI18N

        addComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addBtn.setText("+");
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        doneBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        doneBtn.setText("Concluir");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        rmBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rmBtn.setText("-");
        rmBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmBtnActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalLabel.setText("R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addComboBox)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                        .addComponent(rmBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addComponent(doneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void close() {
        cb.callback(carrinho);
        setVisible(false);
        dispose();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Fecha a tela sem o alerta se o carrinho está vazio
        if (carrinho.getItens().isEmpty()) {
            close();
            return;
        }

        String[] options = {"Sim", "Não"};
        int chosen = JOptionPane.showOptionDialog(
                this,
                "Deseja cancelar a compra?",
                "Atenção",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null, options, options[1]);
        if (chosen == JOptionPane.YES_OPTION) {
            carrinho = null;
            close();
        }
    }//GEN-LAST:event_formWindowClosing

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        JOptionPane.showMessageDialog(this, "Compra concluída com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
        close();
    }//GEN-LAST:event_doneBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        int index = addComboBox.getSelectedIndex();
        if (index >= 0) {
            carrinho.add(produtos.get(index), 1);
            updateView();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void rmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmBtnActionPerformed
        int index = addComboBox.getSelectedIndex();
        if (index >= 0) {
            carrinho.remove(produtos.get(index), 1);
            updateView();
        }
    }//GEN-LAST:event_rmBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<String> addComboBox;
    private javax.swing.JButton doneBtn;
    private javax.swing.JList<sistemacaixamercado.ItemCarrinho> itensList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rmBtn;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}

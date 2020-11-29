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

import java.awt.Component;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import sistemacaixamercado.ItemCarrinho;
import sistemacaixamercado.Produto;

/**
 * Componente que renderiza os itens de um carrinho
 *
 * @author Leonardo
 */
public class ItemCarrinhoRenderer extends JPanel implements ListCellRenderer {

    /**
     * Guardamos os ícones que já foram vistos colocados no carrinho antes, para
     * que pegar a imagem correspondente seja mais rápido das próximas vezes.
     * Isso aumenta bastante a performance caso o ícone venha de uma URL, porque
     * só precisamos fazer o download da imagem uma vez
     */
    private HashMap<String, ImageIcon> cache;

    public ItemCarrinhoRenderer() {
        cache = new HashMap<>();

        setOpaque(true);
        //setHorizontalAlignment(LEFT);
        //setVerticalAlignment(CENTER);
    }

    /**
     * Retorna a imagem correspondente à string do ícone dada
     *
     * @param icon
     * @return
     */
    private ImageIcon getIcon(String icon) {
        // Ícone vem de um resource
        var resource = getClass().getResource("/images/produtos/" + icon + ".png");
        if (resource != null) {
            return new javax.swing.ImageIcon(resource);
        }

        try {
            // Ícone vem de uma URL
            var imageIcon = new javax.swing.ImageIcon(new URL(icon));
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(scaledImage);
            return imageIcon;
        } catch (MalformedURLException e) {
            // no icon
            // wasn't meant to be
            return null;
        }

    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        ItemCarrinho item = (ItemCarrinho) value;
        Produto produto = item.getProduto();

        // Set icon
        String icone = produto.getIcone();
        ImageIcon image;
        if (cache.containsKey(icone)) {
            image = cache.get(icone);
        } else {
            image = getIcon(icone);
            cache.put(icone, image);
        }

        // Set text
        var nameLabel = new javax.swing.JLabel();
        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
        nameLabel.setText(produto.getNome() + " (" + produto.strPreco() + ")");
        nameLabel.setIcon(image);

        var countLabel = new javax.swing.JLabel();
        var lessBtn = new javax.swing.JButton();
        var moreBtn = new javax.swing.JButton();

        countLabel.setFont(new java.awt.Font("Segoe UI", 0, 18));
        countLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countLabel.setText(item.getQtd() + "");

        lessBtn.setFont(new java.awt.Font("Segoe UI", 0, 24));
        lessBtn.setText("-");
        lessBtn.addActionListener(evt -> {
            Warning.show("you have been warned");
        });

        moreBtn.setFont(new java.awt.Font("Segoe UI", 0, 24));
        moreBtn.setText("+");
        
        this.removeAll();

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(lessBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moreBtn)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLabel)
                    .addComponent(lessBtn)
                    .addComponent(moreBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        return this;
    }

}

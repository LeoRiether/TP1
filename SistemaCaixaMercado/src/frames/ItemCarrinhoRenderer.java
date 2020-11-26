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
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import sistemacaixamercado.ItemCarrinho;

/**
 * Componente que renderiza os itens de um carrinho
 *
 * @author Leonardo
 */
public class ItemCarrinhoRenderer extends JLabel implements ListCellRenderer {

    public ItemCarrinhoRenderer() {

        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        /*if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }*/

        ItemCarrinho item = (ItemCarrinho) value;

        // Set icon
        String icone = item.getProduto().getIcone();
        var resource = getClass().getResource("/images/produtos/" + icone + ".png");
        if (resource != null) {
            setIcon(new javax.swing.ImageIcon(resource));
        } else {
            try {
                setIcon(new javax.swing.ImageIcon(new URL(icone)));
            } catch (MalformedURLException e) {
                // no icon
                // wasn't meant to be
            }
        }

        // Set text
        setText(item.getProduto().getNome());
        setFont(list.getFont());

        return this;
    }

}

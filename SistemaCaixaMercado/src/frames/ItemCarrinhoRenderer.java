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
import javax.swing.ListCellRenderer;
import sistemacaixamercado.ItemCarrinho;

/**
 * Componente que renderiza os itens de um carrinho
 *
 * @author Leonardo
 */
public class ItemCarrinhoRenderer extends JLabel implements ListCellRenderer {

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
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
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

        // Set icon
        String icone = item.getProduto().getIcone();
        if (cache.containsKey(icone)) {
            setIcon(cache.get(icone));
        } else {
            ImageIcon image = getIcon(icone);
            setIcon(image);
            cache.put(icone, image);
        }

        // Set text
        setText(item.getProduto().getNome());
        setFont(list.getFont());

        return this;
    }

}

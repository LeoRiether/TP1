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
package sistemacaixamercado;

/**
 * Representa um item do carrinho, com um produto e uma quantidade
 * @author Leonardo
 */
public class ItemCarrinho {
    private Produto p;
    private int qtd;

    public ItemCarrinho(Produto p, int qtd) {
        this.p = p;
        this.qtd = qtd;
    }
    
    public void add(int x) {
        this.qtd += x;
    }
    public void remove(int x) {
        this.qtd -= x;
    }
    
    public int getQtd(int x) {
        return this.qtd;
    }
    public void setQtd(int x) {
        this.qtd = x;
    }
    
    public Produto getProduto() {
        return p;
    }
}
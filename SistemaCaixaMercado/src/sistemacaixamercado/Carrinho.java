package sistemacaixamercado;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa um carrinho de compras, utilizado em CompraFrame
 * @author Leonardo
 */
public class Carrinho {
    ArrayList<ItemCarrinho> itens;
    HashMap<Produto, Integer> posicoes;

    public Carrinho() {
        itens = new ArrayList<>();
        posicoes = new HashMap<>();
    }
    
    public void add(Produto p, int qtd) {
        if (posicoes.containsKey(p)) {
            int i = posicoes.get(p);
            itens.get(i).add(qtd);
        } else {
            posicoes.put(p, itens.size());
            itens.add(new ItemCarrinho(p, qtd));
        }
    }
    
    public void remove(Produto p, int qtd) {
        if (posicoes.containsKey(p)) {
            int i = posicoes.get(p);
            itens.get(i).remove(qtd);
            if (itens.get(i).getQtd() <= 0) {
                posicoes.remove(p);
                itens.remove(i);
            }
        }
    }
    
    public void setQtd(Produto p, int qtd) {
        if (posicoes.containsKey(p)) {
            int i = posicoes.get(p);
            itens.get(i).setQtd(qtd);
            
            if (itens.get(i).getQtd() <= 0) {
                posicoes.remove(p);
                itens.remove(i);
            }
        } else {
            posicoes.put(p, itens.size());
            itens.add(new ItemCarrinho(p, qtd));
        }
    }
    
    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }
}

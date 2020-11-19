package sistemacaixamercado;

import java.util.ArrayList;
import java.util.HashMap;


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
            itens.add(new ItemCarrinho(p, qtd));
        }
    }
    
    public void remove(Produto p, int qtd) {
        add(p, -qtd);
    }
    
    public void setQtd(Produto p, int qtd) {
        if (posicoes.containsKey(p)) {
            int i = posicoes.get(p);
            itens.get(i).setQtd(qtd);
        } else {
            itens.add(new ItemCarrinho(p, qtd));
        }
    }
    
    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }
}

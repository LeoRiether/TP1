package sistemacaixamercado;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Representa um carrinho de compras, utilizado em CompraFrame
 *
 * @author Leonardo
 */
public class Carrinho {

    ArrayList<ItemCarrinho> itens;
    HashMap<Produto, Integer> posicoes;
    HashMap<ProdutoComDesconto, Integer> preco;

    public Carrinho() {
        itens = new ArrayList<>();
        posicoes = new HashMap<>();
        preco = new HashMap<>();
    }

    /**
     * Refaz todo o hashmap das posições
     */
    private void rebuildPosicoes() {
        posicoes.clear();
        for (int i = 0; i < itens.size(); i++) {
            posicoes.put(itens.get(i).getProduto(), i);
        }
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
                itens.remove(i);
                rebuildPosicoes();
            }
        }
    }

    public void setQtd(Produto p, int qtd) {
        if (posicoes.containsKey(p)) {
            int i = posicoes.get(p);
            itens.get(i).setQtd(qtd);

            if (itens.get(i).getQtd() <= 0) {
                itens.remove(i);
                rebuildPosicoes();
            }
        } else {
            posicoes.put(p, itens.size());
            itens.add(new ItemCarrinho(p, qtd));
        }
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }

    /**
     * Calcula o preço de um item do carrinho, já aplicando desconto se necessário
     * e contabilizando a quantidade correta.
     * @param item o item que queremos calcular o preço
     * @return o preço de item.qtd produtos com desconto aplicado (se o RNG quiser)
     */
    public int precoComDesconto(ItemCarrinho item) {
        Produto p = item.getProduto();
        if (!(p instanceof ProdutoComDesconto)) {
            return p.getPreco() * item.getQtd();
        }
        
        if (preco.containsKey(p)) {
            return preco.get(p) * item.getQtd();
        }
        
        ProdutoComDesconto pcd = (ProdutoComDesconto)p;
        int novoPreco = pcd.aplicarDesconto();
        preco.put(pcd, novoPreco);
        return novoPreco * item.getQtd();
    }
}

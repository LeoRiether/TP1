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
    
    /**
     * Adiciona x produtos ao item
     * @param x 
     */
    public void add(int x) {
        this.qtd += x;
    }
    
    /**
     * Remove x produtos do item
     * @param x 
     */
    public void remove(int x) {
        this.qtd -= x;
    }
    
    public int getQtd() {
        return this.qtd;
    }
    public void setQtd(int x) {
        this.qtd = x;
    }
    
    public Produto getProduto() {
        return p;
    }
}
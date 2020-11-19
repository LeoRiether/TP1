package sistemacaixamercado;

/**
 * Representa um produto do mercado
 * @author Leonardo
 */
public class Produto {
    private int id;
    protected int preco; // preço em centavos

    public Produto(int id, int preco) {
        this.id = id;
        this.preco = preco;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }
    
    /**
     * No caso de um Produto (não um ProdutoComDesconto), apenas retorna o preço
     * @return O preço do produto
     */
    public int aplicarDesconto() {
        return preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return this.id == other.id;
    }
 
    /**
     * @return uma string do preço do tipo "R$10,00", ou "R$0,50"
     */
    public String strPreco() {
        return String.format("R$%d,%02d", preco / 100, preco % 100);
    }
}

package sistemacaixamercado;

import java.io.Serializable;
import java.util.Random;

/**
 * Representa um produto que pode receber descontos aleatórios
 *
 * @author Leonardo
 */
public class ProdutoComDesconto extends Produto implements Serializable {

    private int probabilidade; // probabilidade de desconto
    private float desconto;
    private transient Random rng;

    public ProdutoComDesconto(int probabilidade, float desconto, int id, int preco, String nome, String icone) {
        super(id, preco, nome, icone);
        this.probabilidade = probabilidade;
        this.desconto = desconto;
    }

    /**
     * @return O preço do produto com ou sem desconto, com probabilidade de
     * `this.probabilidade`%
     */
    @Override
    public int aplicarDesconto() {
        int r = rng.nextInt(100);
        if (r < probabilidade) {
            return Math.round((desconto / 100) * (float) preco);
        }
        return preco;
    }

    public void setRng(Random rng) {
        this.rng = rng;
    }

    public int getProbabilidade() {
        return probabilidade;
    }

    public float getDesconto() {
        return desconto;
    }
    
    
}

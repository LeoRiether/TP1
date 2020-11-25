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
    Random rng;

    public ProdutoComDesconto(int probabilidade, float desconto, Random rng, int id, int preco, String nome, String icone) {
        super(id, preco, nome, icone);
        this.probabilidade = probabilidade;
        this.desconto = desconto;
        this.rng = rng;
    }

    /**
     * @return O preço do produto com ou sem desconto, com probabilidade de
     * `this.probabilidade`%
     */
    @Override
    public int aplicarDesconto() {
        int r = rng.nextInt(100);
        if (r < probabilidade) {
            return Math.round(desconto * (float) preco);
        }
        return preco;
    }
}

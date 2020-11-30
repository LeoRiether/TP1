package sistemacaixamercado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Estatísticas dos produtos e dos carrinhos de compras feitas
 *
 * @author Leonardo
 */
public class Estatisticas implements Serializable {

    /**
     * Associa o ID de um produto a quantas vezes ele foi comprado
     */
    private final HashMap<Integer, Integer> qtdProdutos;

    /**
     * Array com os preços totais de cada carrinho comprado
     */
    private final ArrayList<Integer> totalCarrinhos;

    public Estatisticas() {
        qtdProdutos = new HashMap<>();
        totalCarrinhos = new ArrayList<>();
    }

    /**
     * Atualiza as estatísticas com base em um novo carrinho adicionado
     *
     * @param c o carrinho a ser adicionado
     */
    public void addCarrinho(Carrinho c) {
        int total = 0;
        for (ItemCarrinho item : c.getItens()) {
            total += c.precoComDesconto(item);

            int qtd = qtdProdutos.getOrDefault(item.getProduto().getId(), 0);
            qtdProdutos.put(item.getProduto().getId(), qtd + item.getQtd());
        }

        totalCarrinhos.add(total);
    }

    /**
     * Calcula a média de totalCarrinhos
     *
     * @return a média calculada
     */
    public double mediaTotais() {
        if (totalCarrinhos.isEmpty()) {
            return 0.0;
        }

        int sum = totalCarrinhos.stream().reduce(0, Integer::sum);
        return (double) sum / (double) totalCarrinhos.size();
    }

    /**
     * Calcula a variância amostral de totalCarrinhos
     *
     * @param media a média calculada por `mediaTotais()`
     * @return a variância calculada
     */
    public double varTotais(double media) {
        if (totalCarrinhos.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (int t : totalCarrinhos) {
            sum += (t - media) * (t - media);
        }
        return sum / (double) (totalCarrinhos.size() - 1);
    }

    /**
     * @return a soma dos elementos em totalCarrinhos
     */
    public int sumTotais() {
        return totalCarrinhos.stream().map(t -> t).reduce(0, Integer::sum);
    }

    /**
     * @return o total de produtos comprados
     */
    public int totalQtdProdutos() {
        return qtdProdutos.values().stream().map(value -> value).reduce(0, Integer::sum);
    }
}

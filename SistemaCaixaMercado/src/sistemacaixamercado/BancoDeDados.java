package sistemacaixamercado;

import java.util.ArrayList;

public class BancoDeDados {

    public BancoDeDados() {
    }
    
    public ArrayList<Produto> loadProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, 500, "Leite"));
        produtos.add(new Produto(2, 5000, "Carne"));
        return produtos;
    }
}

package sistemacaixamercado;

import java.util.ArrayList;

public class SistemaCaixaMercado {
    BancoDeDados bd;
    ArrayList<Produto> produtos;

    public SistemaCaixaMercado() {
        bd = new BancoDeDados();
        produtos = bd.loadProdutos();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}

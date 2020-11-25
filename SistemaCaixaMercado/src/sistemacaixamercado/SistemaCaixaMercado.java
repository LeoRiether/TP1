package sistemacaixamercado;

import java.util.ArrayList;

public class SistemaCaixaMercado {

    BancoDeDados bd;
    ArrayList<Produto> produtos;

    public SistemaCaixaMercado() {
        bd = new BancoDeDados();
        try {
            produtos = bd.loadProdutos();
        } catch(Exception e) {
            frames.Warning.show("O arquivo de produtos parece ter sido corrompido! Erro: " + e);
            produtos = new ArrayList<>();
        }
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public BancoDeDados getBd() {
        return bd;
    }

}

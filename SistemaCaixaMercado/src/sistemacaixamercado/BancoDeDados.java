package sistemacaixamercado;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class BancoDeDados {

    private static final String dataDir = "bd";
    private static final String produtosFile = dataDir + "/produtos";
    private static final String clientesFile = dataDir + "/clientes";

    public BancoDeDados() {
    }

    /**
     * Lê um objeto de um arquivo `file`
     *
     * @param file o nome do arquivo a ser lido
     * @return
     */
    private Object loadFromFile(String file) throws IOException, ClassNotFoundException {
        Object result;
        try ( var fileStream = new FileInputStream(file);  var objStream = new ObjectInputStream(fileStream)) {
            result = objStream.readObject();
        }
        return result;
    }

    /**
     * Carrega os produtos do arquivo correspondente.
     *
     * @return Produtos cadastrados
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Produto> loadProdutos() throws IOException, ClassNotFoundException {
        try {
           return (ArrayList<Produto>) loadFromFile(produtosFile);
        } catch (java.io.FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    /**
     * Carrega os clientes cadastrados
     *
     * @return Clientes cadastrados
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public ArrayList<Cliente> loadClientes() throws IOException, ClassNotFoundException {
        return (ArrayList<Cliente>) loadFromFile(clientesFile);
    }

    private void createDataDir() throws IOException {
        Files.createDirectories(Paths.get(dataDir));
    }

    /**
     * Serializa e salva um objeto em um arquivo
     *
     * @param file o arquivo em que queremos escrever o objeto
     * @param obj o objeto a ser salvo
     */
    private void saveToFile(String file, Object obj) throws IOException {
        createDataDir();

        try ( var fileStream = new FileOutputStream(file);  var objStream = new ObjectOutputStream(fileStream)) {
            objStream.writeObject(obj);
        }
    }

    /**
     * Salva os produtos cadastrados no banco de dados
     *
     * @param produtos lista de produtos a serem salvos
     * @throws IOException
     */
    public void saveProdutos(ArrayList<Produto> produtos) throws IOException {
        saveToFile(produtosFile, produtos);
    }

    /**
     * Salva os clientes cadastrados no banco de dados
     *
     * @param clientes lista de clientes a serem salvos
     * @throws IOException
     */
    public void saveClientes(ArrayList<Cliente> clientes) throws IOException {
        saveToFile(clientesFile, clientes);
    }
}

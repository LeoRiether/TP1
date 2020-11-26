/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacaixamercado;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Leonardo
 */
public class ProdutoTest {
    
    public ProdutoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of strPreco method, of class Produto.
     */
    @Test
    public void testStrPreco() {
        System.out.println("strPreco");
        Produto instance = new Produto(0, 1000, "A", "");
        assertEquals("R$10,00", instance.strPreco());
        
        instance = new Produto(1, 50, "B", "");
        assertEquals("RS0,50", instance.strPreco());
        
        instance = new Produto(1, 5, "C", "");
        assertEquals("RS0,05", instance.strPreco());
    }
    
}

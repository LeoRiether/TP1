package frames;

import javax.swing.JOptionPane;

/**
 * Classe utilitária para criar JOptionPanes de alerta
 *
 * @author Leonardo
 */
public class Warning {

    public static void show(String message) {
        Warning.show(message, "Alerta");
    }

    public static void show(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}

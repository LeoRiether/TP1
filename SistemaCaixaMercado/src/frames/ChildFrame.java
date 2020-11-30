package frames;

import javax.swing.JFrame;

/**
 * Representa um JFrame que é "filho" de um `parent`. Ao chamar
 * `setVisible(true)` o pai é escondido, e `setVisible(false)` volta a mostrar o
 * pai.
 *
 * @author Leonardo
 */
public abstract class ChildFrame extends JFrame {

    private final JFrame parent;

    public ChildFrame(JFrame parent) {
        this.parent = parent;
    }

    @Override
    public void setVisible(boolean visibility) {
        super.setVisible(visibility);
        parent.setVisible(!visibility);
    }
    
    @Override
    public void dispose() {
        parent.setVisible(true);
        super.dispose();
    }
}

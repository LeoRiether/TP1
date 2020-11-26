/*
 * Copyright (C) 2020 Leonardo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package frames;

import javax.swing.JFrame;

/**
 * Representa um JFrame que é "filho" de um `parent`. 
 * Ao chamar `setVisible(true)` o pai é escondido, e `setVisible(false)` volta a
 * mostrar o pai.
 * @author Leonardo
 */
public class ChildFrame extends JFrame {
    private JFrame parent;
    
    public ChildFrame(JFrame parent) {
        this.parent = parent;
    }
    
    @Override
    public void setVisible(boolean visibility) {
        super.setVisible(visibility);
        parent.setVisible(!visibility);
    }
}
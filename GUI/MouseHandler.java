package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler  implements MouseListener{

    public boolean mouseClicked = false;
    public int[] mouseLocation = new int[2];

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseClicked = true;
        mouseLocation[0] = e.getX();
        mouseLocation[1] = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClicked = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

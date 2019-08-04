import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener {
    Conductor[][] Board;
    Board()
    {
        Board=new Conductor[8][8];
        setBackground(Color.gray);
        setPreferredSize(new Dimension(600, 600));
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++) {
               Board[x][y]=new Conductor(x,y);
               add(Board[x][y]).addMouseListener(this);
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
      //How i can move?
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++)
                if(Board[x][y]==e.getComponent())
                    Board=Board[x][y].myPawnSelected(Board);
                UpdateScreen();
    }
    private void UpdateScreen()
    {    removeAll();
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++) {
                add(Board[x][y]).addMouseListener(this);
            }
        updateUI();
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

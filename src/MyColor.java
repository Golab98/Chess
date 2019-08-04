import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyColor extends JPanel {
    private int possitionX,possitionY;
    private BufferedImage fieldImage;
    public void FieldImage(String path) {
        //setting image of our field with Pawn
        File imageFile;
            imageFile = new File( path);
            try {
                fieldImage = ImageIO.read(imageFile);
            } catch (IOException e) {
                System.err.println("Blad odczytu obrazka");
                e.printStackTrace();
            }
            Dimension dimension = new Dimension(fieldImage.getWidth()-30, fieldImage.getHeight()-30);
            setPreferredSize(dimension);
        }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(0.60,0.60);
        g2d.drawImage(fieldImage, 0, 0, this);
    }

    public String setFieldColor()
    {
        if(possitionX%2==0)
            return possitionY%2==0? "White":"Black";
        else return possitionY%2==1?"White":"Black";
        //setting color of field at board
    }

    public int getPossitionX() {
        return possitionX;
    }

    public void setPossitionX(int possitionX) {
        this.possitionX = possitionX;
    }

    public int getPossitionY() {
        return possitionY;
    }

    public void setPossitionY(int possitionY) {
        this.possitionY = possitionY;
    }
    public JPanel getPanel()
    {
        return this;
    }
}

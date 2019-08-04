import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Painter extends JPanel {
    private BufferedImage fieldImage;
    private String colorOfPawn;
    private String typeOfPawn;
    private int positionX,positionY;

    Painter(int positionX,int positionY) {
        this.positionX=positionX;
        this.positionY=positionY;
        if(positionX==1||positionX==6)
            typeOfPawn="Pawn";
        else
        if(positionX==0||positionX==7)
        {
            if(positionY==0||positionY==7)
                typeOfPawn="Rook";
            else
            if(positionY==1||positionY==6)
                typeOfPawn="Knight";
            else
            if(positionY==2||positionY==5)
                typeOfPawn="Bishop";
            else
                typeOfPawn=positionY==3? "Queen":"King";
        }
        else typeOfPawn=null;
        colorOfPawn=positionX<2? "Black": "White";
        DrawField();
    }
    public void setMoveAble()
    {
        StringBuilder stringBuilder = new StringBuilder("PngPawns/");
        stringBuilder.append(setFieldColor());
        stringBuilder.append("Field");
        if(typeOfPawn!=null)
        {stringBuilder.append(colorOfPawn);
            stringBuilder.append(typeOfPawn);}
        stringBuilder.append("X.png");
        FieldImage(stringBuilder.toString());

    }
    public void DrawField() {
        StringBuilder stringBuilder = new StringBuilder("PngPawns/");
        stringBuilder.append(setFieldColor());
        stringBuilder.append("Field");
        if(typeOfPawn!=null)
        {stringBuilder.append(colorOfPawn);
        stringBuilder.append(typeOfPawn);}
        stringBuilder.append(".png");
        FieldImage(stringBuilder.toString());
    }

    private String setFieldColor()
    {
        if(positionX%2==0)
            return positionY%2==0? "White":"Black";
        else return positionY%2==1?"White":"Black";
        //setting color of field at board
    }


    private void FieldImage(String path) {
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
        updateUI();
    }
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(0.60,0.60);
        g2d.drawImage(fieldImage, 0, 0, this);
    }

    public String getColorOfPawn() {
        return colorOfPawn;
    }

    public void setColorOfPawn(String colorOfPawn) {
        this.colorOfPawn = colorOfPawn;
    }

    public String getTypeOfPawn() {
        return typeOfPawn;
    }

    public void setTypeOfPawn(String typeOfPawn) {
        this.typeOfPawn = typeOfPawn;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}

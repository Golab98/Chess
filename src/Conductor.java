
public class Conductor extends Painter {
    public Conductor(int positionX, int positionY) {
        super(positionX, positionY);
    }

    public Conductor[][] myPawnSelected(Conductor[][] Board)
    {
        if(getTypeOfPawn()!=null)
        switch(getTypeOfPawn())
        {
            case "Pawn":{ return Pawn.moveMyPawn(getPositionX(),getPositionX(),Board);}
            case "Rook":{break;}
            case "king":{break;}
            case "Queen":{break;}
            case "Bishop":{break;}
            case "Knight":{break;}
        }

        return Board;
    }

}



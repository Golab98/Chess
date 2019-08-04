
public class Pawn{

    protected static Conductor[][] moveMyPawn(int x,int y, Conductor[][] Board) {
        if(Board[x][y].getColorOfPawn().equals("Black"))
        {   if(trythis(x,y,+1,0,Board))
            if(Board[x][y].getTypeOfPawn()==null)
                Board[x + 1][y].setMoveAble();
            if(x==1)
                if(trythis(x,y,+2,0,Board))
                    Board[x + 2][y].setMoveAble();
            if(trythis(x,y,1,0,Board))
              Board[x + 1][y].setMoveAble();
            if (trythis(x, y, 1, 1, Board))
                 Board[x + 1][y + 1].setMoveAble();
            if (trythis(x, y, 1, -1, Board))
                Board[x + 1][y - 1].setMoveAble();
        }
        else
            {   if(trythis(x,y,-1,0,Board))
                        if(Board[x][y].getTypeOfPawn()==null)
                        Board[x - 1][y].setMoveAble();
                if(x==6)
                    if(trythis(x,y,-2,0,Board))
                        Board[x - 2][y].setMoveAble();
                if(trythis(x,y,-1,-1,Board))
                     Board[x-1][y-1].setMoveAble();
                if(trythis(x,y,-1,1,Board))
                    Board[x-1][y+1].setMoveAble();
            }
        return Board;
    }
    private static boolean trythis(int x, int y, int tmpX, int tmpY, Conductor[][] Board)
    {   if(!Board[x][y].getColorOfPawn().equals(Board[x+tmpX][y+tmpY].getColorOfPawn())&& x+tmpX<8 &&x+tmpX>=0 && y+tmpY<8 && y+tmpY>=0)
             return true;
    return false;
    }

}

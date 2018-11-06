package ba.unsa.etf.rpr;

public class Queen extends ChessPiece{
    public String position;
    public ChessPiece.Color color;

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public ChessPiece.Color getColor() {
        return color;
    }

    @Override
    public void move(String position) {

    }
}

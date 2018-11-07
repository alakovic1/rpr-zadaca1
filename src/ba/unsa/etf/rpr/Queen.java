package ba.unsa.etf.rpr;

public class Queen extends ChessPiece{
    public String position;
    public ChessPiece.Color color;

    public Queen(String position, ChessPiece.Color color) {
        this.position = position;
        this.color = color;
    }

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

package ba.unsa.etf.rpr;

public abstract class ChessPiece {

    public enum Color {BLACK, WHITE}

    public abstract String getPosition();

    public abstract Color getColor();

    public abstract void move(String position) throws IllegalChessMoveException;

}

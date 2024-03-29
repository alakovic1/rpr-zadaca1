package ba.unsa.etf.rpr;

public class Rook extends ChessPiece {
    public String position;
    public ChessPiece.Color color;

    public Rook(String position, ChessPiece.Color color) {
        if (position.length() != 2) throw new IllegalArgumentException(); //da li je dobra duzina stringa
        if (position.charAt(0) > 'a' || position.charAt(0) < 'h') { //ako su mala slova pretvaramo u velika pa poredimo
            Character novi = position.charAt(0);
            String manji = Character.toString(novi);
            manji = manji.toUpperCase();
            position = manji + position.charAt(1);
            if (position.charAt(0) < 'A' || position.charAt(0) > 'H') throw new IllegalArgumentException();
            else {
                if (position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
            }
        } else if (position.charAt(0) > 'A' || position.charAt(0) < 'H') {
            if (position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();
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
    public void move(String position) throws IllegalChessMoveException {
        if (position.length() != 2) throw new IllegalArgumentException(); //da li je dobra duzina stringa
        if (position.charAt(0) > 'a' || position.charAt(0) < 'h') { //ako su mala slova pretvaramo u velika pa poredimo
            Character novi = position.charAt(0);
            String manji = Character.toString(novi);
            manji = manji.toUpperCase();
            position = manji + position.charAt(1);
            if (position.charAt(0) < 'A' || position.charAt(0) > 'H') throw new IllegalArgumentException();
            else {
                if (position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
            }
        } else if (position.charAt(0) > 'A' || position.charAt(0) < 'H') {
            if (position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();

        //Rook se moze kretati ravno samo
        if (this.position.charAt(0) == position.charAt(0)) this.position = position;
        else if (this.position.charAt(1) == position.charAt(1)) this.position = position;
        else throw new IllegalChessMoveException();
    }
}

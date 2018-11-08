package ba.unsa.etf.rpr;

public class Pawn extends ChessPiece {
    public String position;
    public ChessPiece.Color color;

    public Pawn(String position, ChessPiece.Color color) {
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
        //na pocetku su crne figure su na pozicijama 7 i 8, a bijele na 1 i 2
        if (this.position.charAt(0) != position.charAt(0))
            throw new IllegalChessMoveException();
        else if ((this.position.charAt(1) == '1' && getColor() == Color.WHITE) || (this.position.charAt(1) == '8' && getColor() == Color.BLACK))
            throw new IllegalChessMoveException();
        else if (position.charAt(1) - this.position.charAt(1) == 2 && this.position.charAt(1) == '2' && getColor() == Color.WHITE)
            this.position = position;
        else if (position.charAt(1) - this.position.charAt(1) == 1 && getColor() == Color.WHITE)
            this.position = position;
        else if (position.charAt(1) - this.position.charAt(1) == -2 && this.position.charAt(1) == '7' && getColor() == Color.BLACK)
            this.position = position;
        else if (position.charAt(1) - this.position.charAt(1) == -1 && getColor() == Color.BLACK)
            this.position = position;
        else throw new IllegalChessMoveException();
    }
}

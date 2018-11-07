package ba.unsa.etf.rpr;

public class King extends ChessPiece {
    public String position;
    public ChessPiece.Color color;

    public King(String position, ChessPiece.Color color) {
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
        if ((this.position.charAt(0) == position.charAt(0))) {
            if ((this.position.charAt(0) - position.charAt(0)) != 0) throw new IllegalChessMoveException();
            this.position = position;
        }
        if (this.position.charAt(0) - position.charAt(0) > 0) {
            if ((this.position.charAt(0) - position.charAt(0)) != 1) throw new IllegalChessMoveException();
            else this.position = position;
        }
        if (this.position.charAt(0) - position.charAt(0) < 0) {
            if ((this.position.charAt(0) - position.charAt(0)) != -1) throw new IllegalChessMoveException();
            else this.position = position;
        }
        if (this.position.charAt(1) - position.charAt(1) > 0) {
            if ((this.position.charAt(1) - position.charAt(1)) != 1) throw new IllegalChessMoveException();
            else this.position = position;
        }
        if (this.position.charAt(1) - position.charAt(1) < 0) {
            if ((this.position.charAt(1) - position.charAt(1)) != -1) throw new IllegalChessMoveException();
            else this.position = position;
        }
        this.position = position;
    }
}

package ba.unsa.etf.rpr;

public class Bishop extends ChessPiece {
    public String position;
    public ChessPiece.Color color;

    public Bishop(String position, ChessPiece.Color color) {
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

        //Bishop se krece samo dijagonalno
        if (this.position.charAt(0) == position.charAt(0)) throw new IllegalChessMoveException(); //slova i brojevi nikad ne mogu biti isti
        else if (this.position.charAt(1) == position.charAt(1)) throw new IllegalChessMoveException();
        else if ((this.position.charAt(0) != position.charAt(0) && (this.position.charAt(1) != position.charAt(1)))) {
            int razlika1 = Math.abs(this.position.charAt(0) - position.charAt(0)); //apsolutna vrijednost razlike slova pozicije
            int razlika2 = Math.abs(this.position.charAt(1) - position.charAt(1)); //apsolutna vrijednost razlike brojeva pozicije
            if (razlika1 != razlika2) throw new IllegalChessMoveException(); //razlika aps vrijednosti mora biti jednaka da bi bio potez validan
            else this.position = position;
        } else throw new IllegalChessMoveException();
    }
}

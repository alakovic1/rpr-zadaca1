package ba.unsa.etf.rpr;

public class Queen extends ChessPiece {
    public String position;
    public ChessPiece.Color color;

    public Queen(String position, ChessPiece.Color color) {
        if (position.length() != 2) throw new IllegalArgumentException();
        if (position.charAt(0) > 'a' || position.charAt(0) < 'h') {
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
        if (position.length() != 2) throw new IllegalArgumentException();
        if (position.charAt(0) > 'a' || position.charAt(0) < 'h') {
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
        if(this.position.charAt(0) == position.charAt(0)) this.position=position;
        else if(this.position.charAt(1) == position.charAt(1)) this.position=position;
        else{
            int razlika1 = Math.abs(this.position.charAt(0) - position.charAt(0));
            int razlika2 = Math.abs(this.position.charAt(1) - position.charAt(1));
            if(razlika1 != razlika2) throw new IllegalChessMoveException();
            else this.position=position;
        }
    }

}

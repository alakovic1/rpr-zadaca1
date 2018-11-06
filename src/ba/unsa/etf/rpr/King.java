package ba.unsa.etf.rpr;

public class King extends ChessPiece {
    public String position;
    public ChessPiece.Color color;

    public King(String position, ChessPiece.Color color) {
        if(position.length()!=2) throw new IllegalArgumentException();
        if (position.charAt(0) > 'a' || position.charAt(0) < 'h') {
            Character novi = position.charAt(0);
            String manji = Character.toString(novi);
            manji = manji.toUpperCase();
            position = manji + position.charAt(1);
            if (position.charAt(0) < 'A' || position.charAt(0) > 'H') throw new IllegalArgumentException();
            else{
                if(position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
            }
        } else if (position.charAt(0) > 'A' || position.charAt(0) < 'H'){
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
    public void move(String position) throws IllegalArgumentException {
        if(position.length()!=2) throw new IllegalArgumentException();
        if (position.charAt(0) > 'a' || position.charAt(0) < 'h') {
            Character novi = position.charAt(0);
            String manji = Character.toString(novi);
            manji = manji.toUpperCase();
            position = manji + position.charAt(1);
            if (position.charAt(0) < 'A' || position.charAt(0) > 'H') throw new IllegalArgumentException();
            else{
                if(position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
            }
        } else if (position.charAt(0) > 'A' || position.charAt(0) < 'H'){
            if (position.charAt(1) < '1' || position.charAt(1) > '8') throw new IllegalArgumentException();
        } else throw new IllegalArgumentException();

    }

}

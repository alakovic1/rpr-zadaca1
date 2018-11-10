package ba.unsa.etf.rpr;

import com.sun.source.tree.WhileLoopTree;

public class Pawn extends ChessPiece {
    public static String pozicijaPawn;
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
        pozicijaPawn = position;
        this.color = color;
    }

    @Override
    public String getPosition() {
        return pozicijaPawn;
    }

    @Override
    public ChessPiece.Color getColor() {
        return color;
    }

    //pijun se pomjera dijagonalno ako je pozicija zauzeta za figurum suprotne boje
    public static void PawnDiagonal(ChessPiece[][] board, String position, ChessPiece.Color color){
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
        if(color == Color.WHITE){
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if(board[i][j]!=null) {
                        if ((pozicijaPawn.charAt(0) - position.charAt(0) == -1 && pozicijaPawn.charAt(1) - position.charAt(1) == 1) || (pozicijaPawn.charAt(0) - position.charAt(0) == 1 && pozicijaPawn.charAt(1) - position.charAt(1) == 1)){
                            if(board[i][j].getPosition().equals(position) && board[i][j].getColor().equals(Color.BLACK)) {
                                String pamtiPoziciju = pozicijaPawn;
                                pozicijaPawn = position;
                                pamtiPoziciju = null;
                            }
                        }
                    }
                }
            }
        }else if(color == Color.BLACK){
            for(int i=1;i<=8;i++){
                for(int j=1;j<=8;j++){
                    if(board[i][j]!=null) {
                        if ((pozicijaPawn.charAt(0) - position.charAt(0) == -1 && pozicijaPawn.charAt(1) - position.charAt(1) == 1) || (pozicijaPawn.charAt(0) - position.charAt(0) == 1 && pozicijaPawn.charAt(1) - position.charAt(1) == 1)){
                            if(board[i][j].getPosition().equals(position) && board[i][j].getColor().equals(Color.WHITE)) {
                                String pamtiPoziciju = pozicijaPawn;
                                pozicijaPawn = position;
                                pamtiPoziciju = null;
                            }
                        }
                    }
                }
            }
        }
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

        //Pawn se moze kretati po jedan potez naprijed, osim ako se nalazi u pocetnom polozaju kada moze dva
        //na pocetku su crne figure na pozicijama 7 i 8, a bijele na 1 i 2
        /*if (this.position.charAt(0) != position.charAt(0)) //ne treba ovaj slucaj jer treba da se pozove funkcija PawnDiagonal u Boardu
            throw new IllegalChessMoveException();*/
        if ((pozicijaPawn.charAt(1) == '1' && getColor() == Color.WHITE) || (pozicijaPawn.charAt(1) == '8' && getColor() == Color.BLACK))
            throw new IllegalChessMoveException(); //ne moze se nalaziti na 1 ili 8 (na pocetku) pijun jer mu je pocetna pozicija 2 ili 7
        else if (position.charAt(1) - pozicijaPawn.charAt(1) == 2 && pozicijaPawn.charAt(1) == '2' && getColor() == Color.WHITE)
            pozicijaPawn = position;
        else if (position.charAt(1) - pozicijaPawn.charAt(1) == 1 && getColor() == Color.WHITE)
            pozicijaPawn = position;
        else if (position.charAt(1) - pozicijaPawn.charAt(1) == -2 && pozicijaPawn.charAt(1) == '7' && getColor() == Color.BLACK)
            pozicijaPawn = position;
        else if (position.charAt(1) - pozicijaPawn.charAt(1) == -1 && getColor() == Color.BLACK)
            pozicijaPawn = position;
        else throw new IllegalChessMoveException();
    }
}

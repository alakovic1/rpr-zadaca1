package ba.unsa.etf.rpr;

import java.util.concurrent.BlockingDeque;

public class Board {
    public ChessPiece[][] board;

    public Board() {
        ChessPiece[][] b = new ChessPiece[10][10];
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                b[i][j] = null;
            }
        }
        //Pawn
        b[2][1] = new Pawn("A2", ChessPiece.Color.WHITE);
        b[2][2] = new Pawn("B2", ChessPiece.Color.WHITE);
        b[2][3] = new Pawn("C2", ChessPiece.Color.WHITE);
        b[2][4] = new Pawn("D2", ChessPiece.Color.WHITE);
        b[2][5] = new Pawn("E2", ChessPiece.Color.WHITE);
        b[2][6] = new Pawn("F2", ChessPiece.Color.WHITE);
        b[2][7] = new Pawn("G2", ChessPiece.Color.WHITE);
        b[2][8] = new Pawn("H2", ChessPiece.Color.WHITE);
        b[7][1] = new Pawn("A7", ChessPiece.Color.BLACK);
        b[7][2] = new Pawn("B7", ChessPiece.Color.BLACK);
        b[7][3] = new Pawn("C7", ChessPiece.Color.BLACK);
        b[7][4] = new Pawn("D7", ChessPiece.Color.BLACK);
        b[7][5] = new Pawn("E7", ChessPiece.Color.BLACK);
        b[7][6] = new Pawn("F7", ChessPiece.Color.BLACK);
        b[7][7] = new Pawn("G7", ChessPiece.Color.BLACK);
        b[7][8] = new Pawn("H7", ChessPiece.Color.BLACK);
        //King
        b[1][5] = new King("E1", ChessPiece.Color.WHITE);
        b[8][5] = new King("E8", ChessPiece.Color.BLACK);
        //Queen
        b[1][4] = new Queen("D1", ChessPiece.Color.WHITE);
        b[8][4] = new Queen("D8", ChessPiece.Color.BLACK);
        //Rook
        b[1][1] = new Rook("A1", ChessPiece.Color.WHITE);
        b[1][8] = new Rook("H1", ChessPiece.Color.WHITE);
        b[8][8] = new Rook("H8", ChessPiece.Color.BLACK);
        b[8][1] = new Rook("A8", ChessPiece.Color.BLACK);
        //Knight
        b[1][2] = new Knight("B1", ChessPiece.Color.WHITE);
        b[1][7] = new Knight("G1", ChessPiece.Color.WHITE);
        b[8][7] = new Knight("G8", ChessPiece.Color.BLACK);
        b[8][2] = new Knight("B8", ChessPiece.Color.BLACK);
        //Bishop
        b[1][3] = new Bishop("C1", ChessPiece.Color.WHITE);
        b[1][6] = new Bishop("F1", ChessPiece.Color.WHITE);
        b[8][3] = new Bishop("C8", ChessPiece.Color.BLACK);
        b[8][6] = new Bishop("F8", ChessPiece.Color.BLACK);

        this.board = b;
    }

    public boolean jesteZauzeta(String position) {
        boolean zauzeta = false;
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                if (this.board[i][j].getPosition().equals(position)) zauzeta = true;
            }
        }
        return zauzeta;
    }

    public void move(Class type, ChessPiece.Color color, String position) throws IllegalChessMoveException {
        try {
            int br = 0;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    try {
                        if (this.board[i][j].getClass() == type && this.board[i][j].getColor() == color) {
                            if (jesteZauzeta(position) && this.board[i][j].getColor() == color)
                                throw new IllegalChessMoveException();
                                //if(jesteZauzeta(position) && this.board[i][j].getColor()!=color) this.board[i][j].move(position);
                            else this.board[i][j].move(position);
                            br++;
                            break;
                        }
                    } catch (Exception izuzetak) {

                    }
                }
            }
            if (br == 0) throw new IllegalChessMoveException();
        }catch(Exception izuzetak){

        }
    }

    public void move(String oldPosition, String newPosition) {

    }

    public boolean isCheck(ChessPiece.Color color) {
        boolean jeste = false;
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                if(this.board[i][j]!=null) {
                    if (this.board[i][j].getColor().equals(color)) jeste = true;
                }
            }
        }
        return jeste;
    }
}

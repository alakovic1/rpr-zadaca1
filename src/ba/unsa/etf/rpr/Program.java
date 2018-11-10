package ba.unsa.etf.rpr;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner ulaz = new Scanner(System.in);
        for (; ; ) {

            System.out.println("White move: ");
            String unos = ulaz.nextLine();

            if (unos.charAt(0) == 'K') {
                board.move(King.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos.charAt(0) == 'Q') {
                board.move(Queen.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos.charAt(0) == 'R') {
                board.move(Rook.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos.charAt(0) == 'B') {
                board.move(Bishop.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos.charAt(0) == 'N') {
                board.move(Pawn.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos.charAt(0) == 'X') break;

            System.out.println("Black move: ");
            String unos2 = ulaz.nextLine();

            if (unos2.charAt(0) == 'K') {
                board.move(King.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos2.charAt(0) == 'Q') {
                board.move(Queen.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos2.charAt(0) == 'R') {
                board.move(Rook.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos2.charAt(0) == 'B') {
                board.move(Bishop.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos2.charAt(0) == 'N') {
                board.move(Pawn.class, ChessPiece.Color.WHITE, unos.substring(1));
            }
            if (unos2.charAt(0) == 'X') break;
            if (!board.isCheck(ChessPiece.Color.BLACK) || !board.isCheck(ChessPiece.Color.WHITE)) {
                System.out.println("CHECK!!!");
                break;
            }
        }
    }
}

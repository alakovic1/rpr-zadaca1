package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Queen q = new Queen("E1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("D2")
        );
    }

    @org.junit.jupiter.api.Test
    void move() {
        Queen q = new Queen("C2", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> q.move("H7")
        );
    }

    @org.junit.jupiter.api.Test
    void move2() {
        Queen q = new Queen("F1", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> q.move("C4")
        );
    }

    @org.junit.jupiter.api.Test
    void move4() {
        Queen q = new Queen("E5", ChessPiece.Color.BLACK);
        assertDoesNotThrow(
                () -> q.move("A1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Queen q = new Queen("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> q.move("E1")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Queen("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Queen q = new Queen("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> q.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Queen q = new Queen("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> q.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Queen q = new Queen("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> q.move("")
        );
    }
}
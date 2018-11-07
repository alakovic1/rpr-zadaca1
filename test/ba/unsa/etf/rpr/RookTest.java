package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {
    @Test
    void move() {
        Rook r = new Rook("D1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("D6")
        );

    }

    @Test
    void move2() {
        Rook r = new Rook("H4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("C4")
        );

    }

    @Test
    void move3() {
        Rook r = new Rook("D4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> r.move("D1")
        );

    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Rook r = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> r.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Rook r = new Rook("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> r.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Rook r = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> r.move("")
        );
    }

}
package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void move() {
        Knight k = new Knight("B1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("C3")
        );

    }

    @Test
    void move2() {
        Knight k = new Knight("D4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E6")
        );

    }

    @Test
    void move3() {
        Knight k = new Knight("G4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("E3")
        );

    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Knight("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Knight("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Knight("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Knight k = new Knight("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Knight k = new Knight("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Knight k = new Knight("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Knight k = new Knight("A2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("E2")
        );
    }
}
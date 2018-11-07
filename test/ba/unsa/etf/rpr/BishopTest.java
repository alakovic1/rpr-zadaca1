package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    @Test
    void move() {
        Bishop b = new Bishop("C2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("G6")
        );

    }

    @Test
    void move2() {
        Bishop b = new Bishop("B6", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("E3")
        );

    }

    @Test
    void move3() {
        Bishop b = new Bishop("F5", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("D3")
        );

    }

    @Test
    void move4() {
        Bishop b = new Bishop("G1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> b.move("A7")
        );

    }

    @Test
    void move5() {
        Bishop b = new Bishop("F3", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> b.move("A4")
        );

    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Bishop b = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Bishop b = new Bishop("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Bishop b = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> b.move("")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Bishop b = new Bishop("A2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> b.move("E2")
        );
    }
}
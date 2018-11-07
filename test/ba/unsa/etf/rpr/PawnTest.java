package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }

    @Test
    void move() {
        Pawn p = new Pawn("C2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("C3")
        );

    }

    @Test
    void move2() {
        Pawn p = new Pawn("H2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("H3")
        );

    }

    @Test
    void move3() {
        Pawn p = new Pawn("F5", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("F6")
        );

    }

    @Test
    void move4() {
        Pawn p = new Pawn("G2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("G4")
        );

    }

    @Test
    void move5() {
        Pawn p = new Pawn("F3", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("A4")
        );

    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructorMalim() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Pawn("k1", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Pawn p = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Pawn p = new Pawn("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Pawn p = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegalMalim() {
        Pawn p = new Pawn("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> p.move("a9")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Pawn p = new Pawn("A2", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("E2")
        );
    }
}
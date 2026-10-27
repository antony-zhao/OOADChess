package board;

import org.junit.jupiter.api.Test;
import piece.Piece;
import strategy.KnightStrategy;
import strategy.QueenStrategy;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

public class BoardTest {
    @Test
    public void testMoveKnightToValidSquare() {
        Board board = new Board();
        Piece knight = new Piece(new KnightStrategy(), true);
        board.place("a1", knight);

        board.move("a1", "b3");

        assertNull(board.at(Board.convertFromMoveStr("a1")));
        assertSame(knight, board.at(Board.convertFromMoveStr("b3")));
    }

    @Test
    public void testInvalidKnightMoveLeavesPieceInPlace() {
        Board board = new Board();
        Piece knight = new Piece(new KnightStrategy(), true);
        board.place("a1", knight);

        board.move("a1", "a2");

        assertSame(knight, board.at(Board.convertFromMoveStr("a1")));
        assertNull(board.at(Board.convertFromMoveStr("a2")));
    }

    @Test
    public void testMoveQueenToValidSquare() {
        Board board = new Board();
        Piece queen = new Piece(new QueenStrategy(), true);
        board.place("a1", queen);

        board.move("a1", "a8");

        assertNull(board.at(Board.convertFromMoveStr("a1")));
        assertSame(queen, board.at(Board.convertFromMoveStr("a8")));
    }

    @Test
    public void testInvalidQueenMoveLeavesPieceInPlace() {
        Board board = new Board();
        Piece queen = new Piece(new QueenStrategy(), true);
        board.place("a1", queen);

        board.move("a1", "b3");

        assertSame(queen, board.at(Board.convertFromMoveStr("a1")));
        assertNull(board.at(Board.convertFromMoveStr("b3")));
    }
}
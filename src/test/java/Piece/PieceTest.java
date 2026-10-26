package Piece;

import org.junit.jupiter.api.Test;
import piece.Piece;
import strategy.QueenStrategy;

public class PieceTest {
    @Test
    public void testBasicPieces() {
        Piece piece = new Piece(new QueenStrategy(), true);
        System.out.println(piece.strategy.validMoves("a8", true));
    }
}

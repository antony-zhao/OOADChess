package piece;

import org.junit.jupiter.api.Test;
import strategy.KnightStrategy;
import strategy.QueenStrategy;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PieceTest {
    @Test
    public void testQueenMovesFromCorner() {
        var validMoves = new QueenStrategy().validMoves("a8", true);

        assertEquals(Set.of(
                "a1", "a2", "a3", "a4", "a5", "a6", "a7",
                "b8", "c8", "d8", "e8", "f8", "g8", "h8",
                "b7", "c6", "d5", "e4", "f3", "g2", "h1"
        ), Set.copyOf(validMoves));
        assertEquals(21, validMoves.size());
        assertFalse(validMoves.contains("a8"));
        assertFalse(validMoves.contains("i8"));
    }

    @Test
    public void testKnightMovesFromCorner() {
        var validMoves = new KnightStrategy().validMoves("a8", true);
        assertEquals(Set.of("b6", "c7"), Set.copyOf(validMoves));
    }

    @Test
    public void testKnightMovesFromCenter() {
        assertEquals(Set.of("b3", "b5", "c2", "c6", "e2", "e6", "f3", "f5"),
                Set.copyOf(new KnightStrategy().validMoves("d4", true)));
    }
}

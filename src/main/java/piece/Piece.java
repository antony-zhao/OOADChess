package piece;

import strategy.Strategy;

public class Piece {
    private final boolean isWhite;
    public Strategy strategy;

    public Piece(Strategy strategy, boolean isWhite) {
        this.isWhite = isWhite;
        this.strategy = strategy;
    }

    public boolean getSide() {
        return isWhite;
    }
}

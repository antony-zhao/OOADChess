package strategy;

import java.util.List;

public class KnightStrategy extends Strategy {
    @Override
    public List<String> validMoves(String startLocation, boolean isWhite) {
        return super.knightMoves(startLocation);
    }

    @Override
    public boolean isKnight() {
        return true;
    }
}

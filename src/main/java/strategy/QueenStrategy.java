package strategy;

import java.util.List;

public class QueenStrategy extends Strategy {
    @Override
    public List<String> validMoves(String startLocation, boolean isWhite) {
        List<String> valid = super.rookMoves(startLocation);
        valid.addAll(super.bishopMoves(startLocation));
        return valid;
    }
}

package strategy;

import board.Board;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public abstract class Strategy {
    private final List<List<Integer>> knightOffsets = List.of(
            List.of(2, 1),
            List.of(2, -1),
            List.of(-2, 1),
            List.of(-2, -1),
            List.of(1, 2),
            List.of(1, -2),
            List.of(-1, 2),
            List.of(-1, -2)
    );
    public abstract List<String> validMoves(String startLocation, boolean isWhite);

    public static String offset(String startLocation, int colOffset, int rowOffset) {
        return "" + (startLocation.charAt(0) + colOffset) + (startLocation.charAt(1) + rowOffset);
    }

    List<String> rookMoves(String startLocation) {
        List<String> possibleMoves = new ArrayList<>();
        for(int i = 0; i < Board.BOARD_SIZE; i++) {
            possibleMoves.add(offset("" + 'a' + startLocation.charAt(1), i, 0));
        }
        for(int i = 0; i < Board.BOARD_SIZE; i++) {
            possibleMoves.add(offset("" + startLocation.charAt(0) + '1', 0, i));
        }
        possibleMoves.remove(startLocation);
        return possibleMoves;
    }

    List<String> bishopMoves(String startLocation) {
        List<String> possibleMoves = new ArrayList<>();
        for(int i = 1; i < Board.BOARD_SIZE; i++) {
            String upRight = offset(startLocation, i, i);
            String upLeft = offset(startLocation, i, -i);
            String downRight = offset(startLocation, -i, i);
            String downLeft = offset(startLocation, -i, -i);
            possibleMoves.addAll(List.of(upRight, upLeft, downRight, downLeft));
        }
        return possibleMoves.stream()
                .filter(Board::isValidSquare)
                .toList();
    }

    List<String> knightMoves(String startLocation) {
        List<String> possibleMoves = new ArrayList<>();
        for (List<Integer> knightOffset : knightOffsets) {
            possibleMoves.add(offset(startLocation, knightOffset.get(0), knightOffset.get(1)));
        }
        return possibleMoves.stream()
                .filter(Board::isValidSquare)
                .toList();
    }

    public boolean isKnight() {
        return false; // For jumping over pieces
    }

    public boolean isPawn() {
        return false; // Uses bishop and rook moves but very limited range, also promotion
    }

    public boolean isRook() {
        return false; // Needed for castling
    }

    public boolean isKing() {
        return false; // For different things like castling, game end/check, and limited movement
    }
}

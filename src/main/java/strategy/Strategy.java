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
        char file = (char) (startLocation.charAt(0) + colOffset);
        char rank = (char) (startLocation.charAt(1) + rowOffset);
        return "" + file + rank;
    }

    List<String> rookMoves(String startLocation) {
        List<String> possibleMoves = new ArrayList<>();
        for (int i = 1; i < Board.BOARD_SIZE; i++) {
            possibleMoves.add(offset(startLocation, i, 0));
            possibleMoves.add(offset(startLocation, -i, 0));
            possibleMoves.add(offset(startLocation, 0, i));
            possibleMoves.add(offset(startLocation, 0, -i));
        }
        possibleMoves.removeIf(move -> !Board.isValidSquare(move));
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
        possibleMoves.removeIf(move -> !Board.isValidSquare(move));
        return possibleMoves;
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

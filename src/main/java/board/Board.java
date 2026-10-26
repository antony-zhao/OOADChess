package board;

import piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Piece>> board = new ArrayList<>();
    public final static int BOARD_SIZE = 8;
    private boolean whiteTurn = true;

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < BOARD_SIZE; j++) {
                board.get(i).add(null);
            }
        }
    }

    // TODO INSERT PIECE SOMEWHERE

    public static List<Integer> convertFromMoveStr(String location) {
        int col = location.charAt(0) - 'a';
        int row = location.charAt(1) - '1';
        return List.of(col, row);
    }

    public static boolean isValidSquare(String location) {
        return (location.charAt(0) >= 'a' && location.charAt(0) <= 'h') &&
            (location.charAt(1) >= '1' && location.charAt(1) <= '8');
    }

    public Piece at(List<Integer> location) {
        return board.get(location.getFirst()).get(location.getLast());
    }

    public void move(String startLocation, String endLocation) {
        Piece startingPiece = at(convertFromMoveStr(startLocation));
        // Check if endLocation is a valid move for this piece
        // Insert into observer if end location has a piece that is captured

        // if isValid
        this.whiteTurn = !this.whiteTurn;
    }
}

package janggi.domain.board;

import janggi.domain.game.Side;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardInitializer {

    public static Board initialize() {
        Map<Position, Piece> pieces = new HashMap<>();
        setupSide(pieces, InitialBoardInfo.CHO);
        setupSide(pieces, InitialBoardInfo.HAN);
        return new Board(pieces);
    }

    private static void setupSide(Map<Position, Piece> pieces, InitialBoardInfo info) {
        Side side = info.getSide();
        putFixedPieces(pieces, info, side);
        putDynamicPieces(pieces, info, side);
    }

    private static void putFixedPieces(Map<Position, Piece> pieces, InitialBoardInfo info, Side side) {
        put(pieces, info.getSoldierRow(), List.of(0, 2, 4, 6, 8), PieceType.SOLDIER, side);
        put(pieces, info.getCannonRow(), List.of(1, 7), PieceType.CANNON, side);
        put(pieces, info.getPalaceRow(), List.of(4), PieceType.PALACE, side);
        put(pieces, info.getBottomRow(), List.of(0, 8), PieceType.CHARIOT, side);
        put(pieces, info.getBottomRow(), List.of(3, 5), PieceType.GUARD, side);
    }

    private static void putDynamicPieces(Map<Position, Piece> pieces, InitialBoardInfo info, Side side) {
        put(pieces, info.getBottomRow(), List.of(1, 7), PieceType.ELEPHANT, side);
        put(pieces, info.getBottomRow(), List.of(2, 6), PieceType.HORSE, side);
    }

    private static void put(Map<Position, Piece> pieces, int row, List<Integer> cols, PieceType type, Side side) {
        for (int index = 0; index < cols.size(); index++) {
            Position position = new Position(row, cols.get(index));
            Piece piece = new Piece(side, type, String.valueOf(index));
            pieces.put(position, piece);
        }
    }
}

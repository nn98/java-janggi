package janggi.domain.board;

import janggi.domain.game.Side;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardInitializer {

    public static Board initialize(SangcharimType choType, SangcharimType hanType) {
        Map<Position, Piece> pieces = new HashMap<>();
        setupSide(pieces, InitialBoardInfo.CHO, choType);
        setupSide(pieces, InitialBoardInfo.HAN, hanType);
        return new Board(pieces);
    }

    private static void setupSide(Map<Position, Piece> pieces, InitialBoardInfo info, SangcharimType type) {
        Side side = info.getSide();
        putFixedPieces(pieces, info, side);
        putDynamicPieces(pieces, info, side, type);
    }

    private static void putDynamicPieces(Map<Position, Piece> pieces, InitialBoardInfo info, Side side,
                                         SangcharimType type) {
        int row = info.getBottomRow();
        put(pieces, row, type.getHorseColumns(), PieceType.HORSE, side);
        put(pieces, row, type.getElephantColumns(), PieceType.ELEPHANT, side);
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

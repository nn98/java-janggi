package janggi.domain.board;

import janggi.domain.game.Side;
import janggi.domain.piece.Piece;
import janggi.domain.piece.PieceType;
import java.util.List;
import java.util.Map;

public enum SangcharimType {
    MA_SANG_MA_SANG(List.of(1, 6), List.of(2, 7)),
    SANG_MA_SANG_MA(List.of(2, 7), List.of(1, 6)),
    MA_SANG_SANG_MA(List.of(1, 7), List.of(2, 6)),
    SANG_MA_MA_SANG(List.of(2, 6), List.of(1, 7));

    private final List<Integer> horseColumns;
    private final List<Integer> elephantColumns;

    SangcharimType(List<Integer> horseColumns, List<Integer> elephantColumns) {
        this.horseColumns = horseColumns;
        this.elephantColumns = elephantColumns;
    }

    public void putDynamicPieces(Map<Position, Piece> board, int row, Side side) {
        putPieces(board, row, horseColumns, PieceType.HORSE, side);
        putPieces(board, row, elephantColumns, PieceType.ELEPHANT, side);
    }

    private void putPieces(Map<Position, Piece> board, int row, List<Integer> columns, PieceType type, Side side) {
        for (int index = 0; index < columns.size(); index++) {
            int column = columns.get(index);
            String pieceNumber = String.valueOf(index);
            board.put(new Position(row, column), new Piece(side, type, pieceNumber));
        }
    }
}

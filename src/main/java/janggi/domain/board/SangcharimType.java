package janggi.domain.board;

import java.util.List;

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

    public List<Integer> getHorseColumns() {
        return horseColumns;
    }

    public List<Integer> getElephantColumns() {
        return elephantColumns;
    }
}

package janggi.domain.board;

import janggi.domain.game.Side;

public enum InitialBoardInfo {
    HAN(Side.HAN, 0, 1, 2, 3),
    CHO(Side.CHO, 9, 8, 7, 6);

    private final Side side;
    private final int bottomRow;
    private final int palaceRow;
    private final int cannonRow;
    private final int soldierRow;

    InitialBoardInfo(Side side, int bottomRow, int palaceRow, int cannonRow, int soldierRow) {
        this.side = side;
        this.bottomRow = bottomRow;
        this.palaceRow = palaceRow;
        this.cannonRow = cannonRow;
        this.soldierRow = soldierRow;
    }

    public Side getSide() {
        return side;
    }

    public int getBottomRow() {
        return bottomRow;
    }

    public int getPalaceRow() {
        return palaceRow;
    }

    public int getCannonRow() {
        return cannonRow;
    }

    public int getSoldierRow() {
        return soldierRow;
    }
}

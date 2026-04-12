package janggi.domain.game;

import janggi.domain.board.Direction;

public enum Side {
    CHO(Direction.N, 1.5),
    HAN(Direction.S, 0.0),
    ;

    private final Direction forwardDirection;
    private final double advantageScore;

    Side(Direction forwardDirection, double advantage) {
        this.forwardDirection = forwardDirection;
        this.advantageScore = advantage;
    }

    public Side opposite() {
        if (this.equals(CHO)) {
            return HAN;
        }
        return CHO;
    }

    public Direction forwardDirection() {
        return forwardDirection;
    }

    public double advantage() {
        return advantageScore;
    }
}

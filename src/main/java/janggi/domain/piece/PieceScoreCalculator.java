package janggi.domain.piece;

import janggi.domain.game.GameManager;
import janggi.domain.game.Side;

public class PieceScoreCalculator {

    public static double calculateCurrentPlayerScore(GameManager gameManager) {
        Side currentSide = gameManager.currentPlayer().side();
        double totalScore = extractAdvantageScore(currentSide);
        return totalScore + sumRawPieceScores(gameManager, currentSide);
    }

    private static double extractAdvantageScore(Side currentSide) {
        if (currentSide.hasAdvantage()) {
            return 2.5;
        }
        return 0.0;
    }

    private static double sumRawPieceScores(GameManager gameManager, Side currentSide) {
        return gameManager.getBoard().piecePosition().values().stream()
                .filter(piece -> piece.side() == currentSide)
                .mapToDouble(PieceScoreCalculator::getScoreByType)
                .sum();
    }

    private static double getScoreByType(Piece piece) {
        return switch (piece.type()) {
            case CHARIOT -> 13.0;
            case CANNON -> 7.0;
            case HORSE -> 5.0;
            case ELEPHANT -> 3.0;
            case GUARD, SOLDIER -> 3.0;
            case PALACE -> 0.0;
        };
    }
}

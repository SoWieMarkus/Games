package markus.wieland.games.ai.moverater;

import java.util.List;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.ai.AIMoveRater;
import markus.wieland.games.game.Difficulty;

public class HighValueMoveRater<M extends AIMove> implements AIMoveRater<M> {

    @Override
    public M getBestMove(List<M> moves, Difficulty difficulty) {
        M bestMove = null;
        for (M m : moves) {
            if (bestMove == null) bestMove = m;
            if (m.getRating() > bestMove.getRating()) {
                bestMove = m;
            }
        }
        return bestMove;
    }
}

package markus.wieland.games.ai.moverater;

import java.util.List;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.ai.AIMoveRater;
import markus.wieland.games.game.Difficulty;

public class HighValueMoveRater implements AIMoveRater {

    @Override
    public AIMove getBestMove(List<AIMove> moves, Difficulty difficulty) {
        AIMove bestMove = null;
        for (AIMove m : moves) {
            if (bestMove == null) bestMove = m;
            if (m.getRating() > bestMove.getRating()) {
                bestMove = m;
            }
        }
        return bestMove;
    }
}

package markus.wieland.games.ai;

import java.io.Serializable;
import java.util.List;

import markus.wieland.games.game.Difficulty;

public interface AIMoveRater extends Serializable {
    AIMove getBestMove(List<AIMove> moves, Difficulty difficulty);
}

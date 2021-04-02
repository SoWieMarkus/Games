package markus.wieland.games.ai;

import java.util.List;

import markus.wieland.games.game.Difficulty;

public interface AIMoveRater<M extends AIMove> {

    M getBestMove(List<M> moves, Difficulty difficulty);
}

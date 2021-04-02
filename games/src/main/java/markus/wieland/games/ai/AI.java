package markus.wieland.games.ai;

import java.util.List;
import java.util.Random;

import markus.wieland.games.game.Difficulty;
import markus.wieland.games.persistence.GameState;

public abstract class AI<S extends GameState, M extends AIMove> {

    protected final Difficulty difficulty;
    protected final Random random;
    protected final int player;
    protected final AIMoveRater<M> aiMoveRater;

    public AI(AIMoveRater<M> aiMoveRater, int player, Random random, Difficulty difficulty) {
        this.player = player;
        this.random = random;
        this.difficulty = difficulty;
        this.aiMoveRater = aiMoveRater;
    }

    public M calculateMove(S s) {
        List<M> moves = getPossibleMoves(s);
        return aiMoveRater.getBestMove(moves, difficulty);
    }

    protected abstract List<M> getPossibleMoves(S s);

}

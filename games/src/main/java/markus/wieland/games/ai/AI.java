package markus.wieland.games.ai;

import java.util.List;
import java.util.Random;

import markus.wieland.games.game.Difficulty;
import markus.wieland.games.persistence.GameState;

public abstract class AI {

    protected final Difficulty difficulty;
    protected final Random random;
    protected final int player;
    protected final AIMoveRater aiMoveRater;

    public AI(AIMoveRater aiMoveRater, int player, Random random, Difficulty difficulty) {
        this.player = player;
        this.random = random;
        this.difficulty = difficulty;
        this.aiMoveRater = aiMoveRater;
    }

    public AIMove calculateMove(GameState gameState) {
        List<AIMove> moves = getPossibleMoves(gameState);
        return aiMoveRater.getBestMove(moves, difficulty);
    }

    protected abstract List<AIMove> getPossibleMoves(GameState gameState);

}

package markus.wieland.games.ai;

import java.io.Serializable;
import java.util.List;

import markus.wieland.games.game.Difficulty;
import markus.wieland.games.persistence.GameState;

public abstract class AI implements Serializable {

    protected final Difficulty difficulty;
    protected final int player;
    protected final AIMoveRater aiMoveRater;

    public AI(AIMoveRater aiMoveRater, int player, Difficulty difficulty) {
        this.player = player;
        this.difficulty = difficulty;
        this.aiMoveRater = aiMoveRater;
    }

    public AIMove calculateMove(GameState gameState) {
        List<AIMove> moves = getPossibleMoves(gameState);
        return aiMoveRater.getBestMove(moves, difficulty);
    }

    protected abstract List<AIMove> getPossibleMoves(GameState gameState);

}

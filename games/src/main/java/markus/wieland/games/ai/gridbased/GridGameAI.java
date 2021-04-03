package markus.wieland.games.ai.gridbased;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import markus.wieland.games.ai.AI;
import markus.wieland.games.ai.AIMove;
import markus.wieland.games.ai.AIMoveRater;
import markus.wieland.games.game.Difficulty;
import markus.wieland.games.persistence.GameState;

public abstract class GridGameAI extends AI {

    protected int[][] currentGameBoard;

    public GridGameAI(AIMoveRater aiMoveRater, int player, Difficulty difficulty) {
        super(aiMoveRater, player, difficulty);
    }

    protected abstract int[][] getCurrentGameState(GameState s);

    @Override
    protected List<AIMove> getPossibleMoves(GameState s) {
        int[][] currentGrid = getCurrentGameState(s);
        List<AIMove> moves = new ArrayList<>();
        for (int y = 0; y < currentGrid.length; y++) {
            for (int x = 0; x < currentGrid[y].length; x++) {
                AIMove m = buildMove(x, y, currentGrid);
                if (m.isLegal())
                    moves.add(m);
            }
        }
        return moves;
    }

    protected abstract AIMove buildMove(int x, int y, int[][] grid);

}

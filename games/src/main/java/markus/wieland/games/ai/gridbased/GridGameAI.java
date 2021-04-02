package markus.wieland.games.ai.gridbased;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import markus.wieland.games.ai.AI;
import markus.wieland.games.ai.AIMoveRater;
import markus.wieland.games.game.Difficulty;
import markus.wieland.games.game.GameBoardField;
import markus.wieland.games.persistence.GameState;

public abstract class GridGameAI<S extends GameState, M extends GridGameAIMove> extends AI<S, M> {

    protected int[][] currentGameBoard;

    public GridGameAI(AIMoveRater<M> aiMoveRater, int player, Random random, Difficulty difficulty) {
        super(aiMoveRater, player, random, difficulty);
    }

    protected abstract int[][] getCurrentGameState(S s);

    @Override
    protected List<M> getPossibleMoves(S s) {
        int[][] currentGrid = getCurrentGameState(s);
        List<M> moves = new ArrayList<>();
        for (int y = 0; y < currentGrid.length; y++) {
            for (int x = 0; x < currentGrid[y].length; x++) {
                if (currentGrid[y][x] == GameBoardField.FREE) {
                    M m = buildMove(x,y,currentGrid);
                    if (m.isLegal())
                        moves.add(m);
                }
            }
        }
        return moves;
    }

    protected abstract M buildMove(int x, int y, int[][] grid);

}

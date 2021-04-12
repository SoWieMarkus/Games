package markus.wieland.games.ai.gridbased;

import java.util.ArrayList;
import java.util.List;

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
        currentGameBoard = getCurrentGameState(s);
        List<AIMove> moves = new ArrayList<>();
        for (int y = 0; y < currentGameBoard.length; y++) {
            for (int x = 0; x < currentGameBoard[y].length; x++) {
                AIMove m = buildMove(x, y, cloneGrid());
                if (m.isLegal()) {
                    m.executeMove();
                    moves.add(m);
                }
            }
        }
        return moves;
    }

    protected int[][] cloneGrid() {
        int[][] clonedGrid = new int[currentGameBoard.length][currentGameBoard[0].length];
        for (int i = 0; i < currentGameBoard.length; i++) {
            System.arraycopy(currentGameBoard[i], 0, clonedGrid[i], 0, currentGameBoard[0].length);
        }
        return clonedGrid;
    }

    protected abstract AIMove buildMove(int x, int y, int[][] grid);

}

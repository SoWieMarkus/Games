package markus.wieland.games.ai.gridbased;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.game.Difficulty;

public abstract class GridGameAIMove extends AIMove {

    protected final int x;
    protected final int y;

    protected final int[][] grid;

    public GridGameAIMove(int x, int y, int[][] grid, Difficulty difficulty, int player) {
        super(difficulty, player);
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

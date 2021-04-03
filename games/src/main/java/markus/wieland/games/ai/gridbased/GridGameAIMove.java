package markus.wieland.games.ai.gridbased;

import java.util.List;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.elements.Line;
import markus.wieland.games.game.Difficulty;

public abstract class GridGameAIMove extends AIMove {

    protected final int x;
    protected final int y;

    protected final List<Line> lines;

    protected final int[][] grid;

    public GridGameAIMove(Difficulty difficulty, int player, int x, int y, List<Line> lines, int[][] grid) {
        super(difficulty, player);
        this.x = x;
        this.y = y;
        this.lines = lines;
        this.grid = grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

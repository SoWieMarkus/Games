package markus.wieland.games.ai.gridbased;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.ai.pattern.PatternMatcher;
import markus.wieland.games.ai.pattern.PatternMatchingLine;
import markus.wieland.games.elements.Line;
import markus.wieland.games.game.Difficulty;

public abstract class GridGameAIMove extends AIMove {

    protected final int x;
    protected final int y;

    protected final int[][] grid;

    public GridGameAIMove(Difficulty difficulty, int player, int x, int y, int[][] grid) {
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

    protected List<PatternMatchingLine> getPatternMatchingLines() {
        List<PatternMatchingLine> patternMatchingLines = new ArrayList<>();
        for (Line line : PatternMatcher.getInstance().getLines()) {
            patternMatchingLines.add(getPatternMatchingLine(line));
        }
        return patternMatchingLines;
    }

    protected PatternMatchingLine getPatternMatchingLine(@NonNull Line line) {
        int size = line.size();
        int[] value = new int[size];
        for (int i = 0; i < line.size(); i++) {
            value[i] = grid[line.getCoordinate(i).getY()][line.getCoordinate(i).getX()];
        }
        return new PatternMatchingLine(value);
    }
}

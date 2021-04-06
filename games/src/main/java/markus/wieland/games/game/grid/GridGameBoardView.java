package markus.wieland.games.game.grid;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.elements.Matrix;
import markus.wieland.games.game.view.GameBoardView;
import markus.wieland.games.persistence.GameState;

public abstract class GridGameBoardView<F extends GridGameBoardFieldView> extends GameBoardView {

    protected final Matrix<F> matrix;

    public GridGameBoardView(@NonNull Context context) {
        this(context, null);
    }

    public GridGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        matrix = new Matrix<>(getSizeX(), getSizeY());
        initializeLines();
    }

    protected void initializeLines() {}

    @Override
    protected void loadGameState(GameState gameState) {
        if (!(gameState instanceof GridGameState))
            throw new IllegalArgumentException("You can't use " + gameState.getClass()
                    + " inside a grid based game board view. Override to method to get rid of this error message.");
        GridGameState gridGameState = (GridGameState) gameState;
        for (GridGameStateField gameStateField : gridGameState) {
            matrix.get(gameStateField.getCoordinate()).load(gameStateField);
        }
    }

    protected abstract int getSizeX();

    protected abstract int getSizeY();
}

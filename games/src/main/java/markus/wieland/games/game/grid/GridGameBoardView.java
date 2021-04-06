package markus.wieland.games.game.grid;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.elements.Matrix;
import markus.wieland.games.game.view.GameBoardView;
import markus.wieland.games.persistence.GameState;

public abstract class GridGameBoardView<F extends GridGameBoardFieldView> extends GameBoardView {

    protected Matrix<F> matrix;

    public GridGameBoardView(@NonNull Context context) {
        this(context, null);
    }

    public GridGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GridGameBoardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        load();
    }

    protected void load(){
        matrix = new Matrix<>(getSizeX(), getSizeY());
        initializeLines();
    }

    protected void initializeLines() {}

    protected abstract int getSizeX();

    protected abstract int getSizeY();
}

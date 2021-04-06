package markus.wieland.games.game.grid;

import androidx.annotation.NonNull;

import java.util.Iterator;

import markus.wieland.games.elements.SerializableMatrix;
import markus.wieland.games.persistence.GameState;

public abstract class GridGameState<F extends GridGameStateField> implements GameState, Iterable<F> {

    protected final SerializableMatrix<F> matrix;

    public GridGameState(SerializableMatrix<F> matrix) {
        this.matrix = matrix;
    }

    public SerializableMatrix<F> getMatrix() {
        return matrix;
    }

    @NonNull
    @Override
    public Iterator<F> iterator() {
        return matrix.iterator();
    }
}

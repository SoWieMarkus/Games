package markus.wieland.games.game.grid;

import androidx.annotation.NonNull;

import java.util.Iterator;

import markus.wieland.games.elements.SerializableMatrix;
import markus.wieland.games.persistence.GameState;

public class GridGameState implements GameState, Iterable<GridGameStateField> {

    protected final SerializableMatrix<GridGameStateField> matrix;

    public GridGameState(SerializableMatrix<GridGameStateField> matrix) {
        this.matrix = matrix;
    }

    public SerializableMatrix<GridGameStateField> getMatrix() {
        return matrix;
    }

    @NonNull
    @Override
    public Iterator<GridGameStateField> iterator() {
        return matrix.iterator();
    }
}

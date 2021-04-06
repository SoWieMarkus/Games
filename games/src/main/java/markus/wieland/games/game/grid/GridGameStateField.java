package markus.wieland.games.game.grid;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.game.view.GameStateField;

public abstract class GridGameStateField implements GameStateField {

    protected final Coordinate coordinate;

    public GridGameStateField(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}

package markus.wieland.games.game.grid;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.game.view.GameStateField;

public interface GridGameStateField extends GameStateField {

    Coordinate getCoordinate();

}

package markus.wieland.games.game.grid;

import markus.wieland.games.elements.Coordinate;
import markus.wieland.games.game.view.GameBoardFieldView;

public interface GridGameBoardFieldView extends GameBoardFieldView {

    Coordinate getCoordinate();

}

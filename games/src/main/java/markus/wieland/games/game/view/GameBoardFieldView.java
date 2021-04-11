package markus.wieland.games.game.view;

public interface GameBoardFieldView {

    void load(GameStateField stateField);
    GameStateField getGameStateField();
    void update();

}

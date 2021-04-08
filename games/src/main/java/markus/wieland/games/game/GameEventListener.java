package markus.wieland.games.game;

import markus.wieland.games.ConfirmDialog;

public interface GameEventListener<R extends GameResult> {

    void onGameStart();

    void onGamePause();

    void onGameFinish(R r);

    void onAbort(ConfirmDialog confirmDialog);

}

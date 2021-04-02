package markus.wieland.games.game;

public interface GameEventListener<R extends GameResult> {

    void onGameStart();

    void onGamePause();

    void onGameFinish(R r);

}

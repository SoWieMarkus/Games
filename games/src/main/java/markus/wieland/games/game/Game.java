package markus.wieland.games.game;

import markus.wieland.games.persistence.GameState;

public abstract class Game<S extends GameState, R extends GameResult> {

    protected boolean isRunning;
    protected GameEventListener<R> gameEventListener;

    public Game(GameEventListener<R> gameEventListener) {
        isRunning = false;
        this.gameEventListener = gameEventListener;
    }

    public void start() {
        isRunning = true;
        this.gameEventListener.onGameStart();
    }

    public void resume(){
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
        this.gameEventListener.onGamePause();
    }

    public void finish() {
        isRunning = false;
    }

    public abstract S getGameState();

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}

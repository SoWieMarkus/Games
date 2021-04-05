package markus.wieland.games.game;

import markus.wieland.games.persistence.GameState;

/**
 * Represents the class of the actual game. The activity uses this class to interact with the game
 * @author Markus Wieland
 * @since 03.04.2021
 *
 * @param <S> {@link GameState} which is used to load the game
 * @param <R> {@link GameResult} which will be posted {@link GameEventListener#onGameFinish(GameResult)}
 */
public abstract class Game<S extends GameState, R extends GameResult> {

    /**
     * Represents if the game is running or not (no information if its over or hasn't started yet)
     */
    protected boolean isRunning;
    /**
     * Triggers events to notify the {@link markus.wieland.games.GameActivity} on game events
     */
    protected GameEventListener<R> gameEventListener;

    public Game(GameEventListener<R> gameEventListener) {
        isRunning = false;
        this.gameEventListener = gameEventListener;
    }

    /**
     * {@link #isRunning} will be set to true.
     * The {@link #gameEventListener} calls {@link GameEventListener#onGameStart()}
     */
    public void start() {
        isRunning = true;
        this.gameEventListener.onGameStart();
    }

    /**
     * {@link #isRunning} will be set to true.
     */
    public void resume() {
        isRunning = true;
    }

    /**
     * {@link #isRunning} will be set to true.
     * The {@link #gameEventListener} calls {@link GameEventListener#onGamePause()}
     */
    public void pause() {
        isRunning = false;
        this.gameEventListener.onGamePause();
    }

    /**
     * {@link #isRunning} will be set to false.
     * The {@link #gameEventListener} calls {@link GameEventListener#onGameFinish(GameResult)} ()}
     */
    public void finish(R r) {
        isRunning = false;
        this.gameEventListener.onGameFinish(r);
    }

    /**
     * Get the current {@link GameState} of the game.
     * @return current state of the game represented by {@link GameState}
     */
    public abstract S getGameState();

    /**
     * Get the {@link GameResult} of the game. This method can be called after every move to check if
     * the game is over or not. This could be implemented by returning null, if the game is still running.
     * @return current {@link GameResult}
     */
    public abstract R getResult();

    /**
     * Get the current value of {@link #isRunning}
     * @return {@link #isRunning}
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Set the value of {@link #isRunning}
     * @param running new value of {@link #isRunning}
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }
}

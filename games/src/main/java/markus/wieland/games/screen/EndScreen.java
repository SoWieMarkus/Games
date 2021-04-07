package markus.wieland.games.screen;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.games.GameActivity;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.screen.interact_listener.EndScreenInteractListener;

/**
 * @author Markus Wieland
 * @since 03.04.2021
 * Child class of {@link Screen}. This class implements a end screen for the games. This screen will
 * be shown when the {@link markus.wieland.games.game.GameEventListener#onGameFinish(GameResult)} is called.
 * This screen will show the result of the game (who won? how much time did it take ...)
 */
public abstract class EndScreen extends Screen {

    /**
     * Result of the game which shall be displayed on the end screen
     */
    protected GameResult gameResult;

    /**
     * @param background base view of the screen
     */
    public EndScreen(@NonNull ViewGroup background) {
        super(background);
    }

    /**
     * After a game ends and a new game result is available the {@link GameActivity} will call
     * this method to update the game result. Afterwards this method calls {@link #update()}
     *
     * @param gameResult Result of the finished game
     */
    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
        update();
    }

    /**
     * This method will be called inside the {@link #setGameResult(GameResult)}. After the screen received
     * a new game result, this method should update the views and apply the results.
     */
    protected abstract void update();

    /**
     * This method hides the screen. At the same time the {@link EndScreenInteractListener#onClose(boolean)} will be called.
     * In default implementation of the {@link GameActivity} the activity will be restarted.
     */
    @Override
    public void close(boolean withConfiguration) {
        super.close();
        ((EndScreenInteractListener) screenInteractListener).onClose(withConfiguration);
    }
}

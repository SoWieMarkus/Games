package markus.wieland.games.screen;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.games.screen.interact_listener.ScreenInteractListener;

/**
 * @author Markus Wieland
 * @since 03.04.2021
 * <p>
 * Base class for screens. Screens containing custom views and implement a logic to interact with them.
 */
public abstract class Screen {

    /**
     * The view of the screen (Could possibly be everything, I often use {@link androidx.constraintlayout.widget.ConstraintLayout}'s)
     */
    protected final View background;

    /**
     * Interface to trigger events while interacting with the screen
     */
    protected ScreenInteractListener screenInteractListener;

    /**
     * @param background base view of the screen {@link #background}
     */
    public Screen(@NonNull ViewGroup background) {
        this.background = background;
    }

    /**
     * Add a interact listener to the screen
     *
     * @param screenInteractListener interact listener which shall be applied
     */
    public void setScreenInteractListener(ScreenInteractListener screenInteractListener) {
        this.screenInteractListener = screenInteractListener;
    }

    /**
     * Get the base view of the screen {@link #background}
     *
     * @return {@link #background} of the screen
     */
    public View getBackground() {
        return background;
    }

    /**
     * Represents {@link View#setVisibility(int)} of the {@link #background}
     *
     * @param visibility Visibility the {@link #background} will get.
     */
    public void setVisibility(int visibility) {
        background.setVisibility(visibility);
    }

    /**
     * This difference between {@link #setVisibility(int)} and this method is, that here an alpha
     * animation is applied
     */
    public void show() {
        background.setAlpha(0f);
        setVisibility(View.VISIBLE);
        background.animate().alpha(0f).setStartDelay(100).setDuration(700);
    }

    /**
     * Hides the screen. You can basically achieve the with calling {@link #setVisibility(int)} but this
     * method will be interesting for child classes
     */
    public void close() {
        setVisibility(View.GONE);
    }
}

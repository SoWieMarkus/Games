package markus.wieland.games.game;

import android.view.View;

import markus.wieland.games.game.view.GameStateField;
import markus.wieland.games.player.Player;

/**
 * A field inside the {@link GameBoard}
 */
public abstract class GameBoardField {

    /**
     * Value of a field without any value
     */
    public static final int FREE = -1;

    /**
     * Value of the field (e.g. {@link Player#getValue()}
     */
    protected int value;

    /**
     * View of the field
     */
    protected final View view;

    /**
     * @param view View of the field
     */
    public GameBoardField(View view) {
        this.view = view;
        this.value = FREE;
    }

    public abstract void apply(GameStateField field);

    /**
     * Check if the field is empty which means is {@link #value} equal to {@link #FREE}
     *
     * @return is the field empty?
     */
    public boolean isEmpty() {
        return value == FREE;
    }

    /**
     * Update the view of the field (e.g. after calling {@link #setValue(int)}
     */
    public abstract void update();

    /**
     * Set the value of the field
     *
     * @param value new value of the field (e.g. {@link Player#getValue()}
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Get the current value of the field
     *
     * @return {@link #value}
     */
    public int getValue() {
        return value;
    }
}

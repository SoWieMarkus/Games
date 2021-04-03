package markus.wieland.games.player;

import java.io.Serializable;

import markus.wieland.games.ai.AI;
import markus.wieland.games.ai.AIMove;
import markus.wieland.games.persistence.GameState;

/**
 * @author Markus Wieland
 * @since 03.04.2021
 *
 * Represents a player of a {@link markus.wieland.games.game.MultiPlayerGame} game.
 */

public class Player implements Serializable {

    /**
     * AI to play against a computer
     */
    protected final AI computer;
    /**
     * Value of the player. This will for example be used as {@link markus.wieland.games.game.GameBoardField#setValue(int)}
     * to place a player to a certain field
     */
    protected final int value;
    /**
     * Name of the player
     */
    protected final String playerName;

    /**
     *
     * @param computer AI of the player, pass null if you want to create an actual player
     * @param value Value of the player
     * @param playerName Username of the player
     */
    public Player(AI computer, int value, String playerName) {
        this.computer = computer;
        this.value = value;
        this.playerName = playerName;
    }

    /**
     * Get the move the bot wants to perform
     * @param gameState Current {@link GameState} of the game
     * @return {@link AIMove} which the bot wants to do
     */
    public AIMove move(GameState gameState) {
        if (computer == null) throw new IllegalStateException("This player doesn't have an AI.");
        return computer.calculateMove(gameState);
    }

    /**
     * Check if a player is a bot or a real player
     * @return Does this player has an AI?
     */
    public boolean hasAI() {
        return computer != null;
    }

    /**
     * Get the AI of this player
     * @return AI of the player
     */
    public AI getComputer() {
        return computer;
    }

    /**
     * Get the value of this player
     * @return value of the player
     */
    public int getValue() {
        return value;
    }

    /**
     * Get name of this player
     * @return name of the player
     */
    public String getPlayerName() {
        return playerName;
    }
}

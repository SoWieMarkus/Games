package markus.wieland.games.player;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * @author Markus Wieland
 * @since 03.04.2021
 * <p>
 * Manage players of a {@link markus.wieland.games.game.MultiPlayerGame}
 */
public class PlayerManager implements Iterable<Player>, Serializable {

    /**
     * List of all players participating
     */
    protected final List<Player> players;
    /**
     * Index of the current player inside the {@link #players} list
     */
    protected int currentPlayerIndex;

    /**
     * @param players            List of all players (this can be expanded with {@link #register(Player)}
     * @param currentPlayerIndex Index of the current player inside the {@link #players}
     */
    public PlayerManager(List<Player> players, int currentPlayerIndex) {
        this.players = players;
        this.currentPlayerIndex = currentPlayerIndex;
    }

    /**
     * Will create an empty player list. The currentPlayerIndex will be 0.
     */
    public PlayerManager() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    /**
     * Register a new player to the game
     *
     * @param player The player which shall be registered
     */
    public void register(Player player) {
        this.players.add(player);
    }

    /**
     * Shuffle the order of the player. With that you can achieve a random player to start
     * Be careful! If you are using this method inside the game the same player could be the current player again!
     */
    public void shuffleOrder() {
        Collections.shuffle(players);
    }

    /**
     * Set the current player by the index of this player inside the {@link #players}
     *
     * @param index Index of the player
     * @throws IllegalArgumentException if the index those not point to an element inside the {@link #players}
     */
    public void setCurrentPlayer(int index) {
        if (index >= players.size() || index < 0)
            throw new IllegalArgumentException("This player is not registered. (Index " + index + ")");
        this.currentPlayerIndex = index;
    }

    /**
     * Set the current player
     *
     * @param player This player shall be the new current player
     * @throws IllegalArgumentException if the player is not registered
     */
    public void setCurrentPlayer(Player player) {
        if (players.contains(player)) {
            setCurrentPlayer(players.indexOf(player));
            return;
        }
        throw new IllegalArgumentException("This player is not registered. (Name: " + player.getPlayerName() + ")");
    }

    /**
     * Get the current player
     *
     * @return player inside the {@link #players} on index {@link #currentPlayerIndex}
     */
    public Player getCurrentPlayer() {
        if (players.isEmpty())
            throw new IllegalStateException("There isn't any registered player.");
        return players.get(currentPlayerIndex);
    }

    /**
     * Player inside the {@link #players} on index {@link #currentPlayerIndex} + 1.
     * If the {@link #currentPlayerIndex} is bigger than the {@link List#size()}} the {@link #currentPlayerIndex} will be 0.
     *
     * @return next player
     */
    public Player next() {
        if (players.isEmpty())
            throw new IllegalStateException("There isn't any registered player.");
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size())
            currentPlayerIndex = 0;
        return getCurrentPlayer();
    }

    /**
     * Get the amount registered players
     *
     * @return {@link #players} size
     */
    public int getAmountOfPlayers() {
        return players.size();
    }

    /**
     * Iterator to iterate over all registered player
     *
     * @return Iterator over all registered player
     */
    @NonNull
    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}

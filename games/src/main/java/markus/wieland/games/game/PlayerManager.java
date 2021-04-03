package markus.wieland.games.game;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerManager implements Iterable<Player>, Serializable {

    protected final List<Player> players;
    protected int currentPlayerIndex;

    public PlayerManager(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public PlayerManager() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void register(Player player) {
        this.players.add(player);
    }

    public void setCurrentPlayer(int index) {
        this.currentPlayerIndex = index;
    }

    public void setCurrentPlayer(Player player) {
        if (players.contains(player)) {
            setCurrentPlayer(players.indexOf(player));
            return;
        }
        throw new IllegalArgumentException("This player is not registered.");
    }

    public Player getCurrentPlayer() {
        if (players.isEmpty())
            throw new IllegalStateException("There isn't any registered player.");
        return players.get(currentPlayerIndex);
    }

    public Player next() {
        if (players.isEmpty())
            throw new IllegalStateException("There isn't any registered player.");
        currentPlayerIndex++;
        if (currentPlayerIndex >= players.size())
            currentPlayerIndex = 0;
        return getCurrentPlayer();
    }

    public int getAmountOfPlayers() {
        return players.size();
    }

    @NonNull
    @Override
    public Iterator<Player> iterator() {
        return new Iterator<Player>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                return (index < players.size() - 1);
            }

            @Override
            public Player next() {
                index++;
                return players.get(index);
            }
        };
    }
}

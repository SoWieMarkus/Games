package markus.wieland.games.player;

import java.io.Serializable;

import markus.wieland.games.ai.AI;
import markus.wieland.games.ai.AIMove;
import markus.wieland.games.persistence.GameState;

public class Player implements Serializable {

    protected final AI computer;
    protected final int value;
    protected final String playerName;

    public Player(AI computer, int value, String playerName) {
        this.computer = computer;
        this.value = value;
        this.playerName = playerName;
    }

    public AIMove move(GameState gameState) {
        if (computer == null) throw new IllegalStateException("This player doesn't have an AI.");
        return computer.calculateMove(gameState);
    }

    public boolean hasAI() {
        return computer != null;
    }

    public AI getComputer() {
        return computer;
    }

    public int getValue() {
        return value;
    }

    public String getPlayerName() {
        return playerName;
    }
}

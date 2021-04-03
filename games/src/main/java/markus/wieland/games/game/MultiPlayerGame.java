package markus.wieland.games.game;

import markus.wieland.games.ai.AIMove;
import markus.wieland.games.persistence.GameState;
import markus.wieland.games.player.Player;
import markus.wieland.games.player.PlayerManager;

public abstract class MultiPlayerGame<S extends GameState, R extends GameResult> extends Game<S, R> {

    protected PlayerManager playerManager;

    public MultiPlayerGame(GameEventListener<R> gameEventListener) {
        super(gameEventListener);
        this.playerManager = new PlayerManager();
    }

    public void registerPlayer(Player player) {
        this.playerManager.register(player);
    }

    public void nextPlayer(){
        Player player = playerManager.next();
        if (player.hasAI())
            performAIMove(player.move(getGameState()));
    }

    protected abstract void performAIMove(AIMove aiMove);


}

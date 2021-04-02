package markus.wieland.games.game;

import markus.wieland.games.persistence.GameState;

public abstract class MultiPlayerGame<S extends GameState, R extends GameResult> extends Game<S,R> {

    public MultiPlayerGame(GameEventListener<R> gameEventListener) {
        super(gameEventListener);
    }
}

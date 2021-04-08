package markus.wieland.games.game.level;

import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.persistence.GameState;

public abstract class LevelGame<L extends Level, S extends GameState, R extends GameResult> extends Game<S,R> {

    protected LevelManager<L> levelManager;

    public LevelGame(GameEventListener<R> gameEventListener) {
        super(gameEventListener);
    }


}

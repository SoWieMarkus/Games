package markus.wieland.games.game.level;

import markus.wieland.games.GameActivity;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameState;

public abstract class LevelActivity<L extends Level, C extends GameConfiguration, H extends Highscore, S extends GameState, GR extends GameResult, G extends LevelGame<L, S, GR>> extends GameActivity<C, H, S, GR, G> {

    public LevelActivity(int layoutId) {
        super(layoutId);
    }
}

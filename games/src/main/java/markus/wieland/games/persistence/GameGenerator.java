package markus.wieland.games.persistence;

import markus.wieland.games.game.GameConfiguration;

/**
 * Class to generate a {@link GameState} for a {@link markus.wieland.games.game.Game}
 *
 * @author Markus Wieland
 * @since 03.04.2021
 * @param <S> {@link GameState} which is going to be generated
 */
public abstract class GameGenerator<S extends GameState> {

    protected final GameConfiguration configuration;

    public GameGenerator(GameConfiguration configuration) {
        this.configuration = configuration;
    }

    public GameConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Generate a {@link GameState}
     * @return generated {@link GameState}
     */
    public abstract S generate();

}

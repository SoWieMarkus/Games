package markus.wieland.games.persistence;

/**
 * Class to generate a {@link GameState} for a {@link markus.wieland.games.game.Game}
 *
 * @author Markus Wieland
 * @since 03.04.2021
 * @param <S> {@link GameState} which is going to be generated
 */
public interface GameGenerator<S extends GameState> {

    /**
     * Generate a {@link GameState}
     * @return generated {@link GameState}
     */
    S generate();

}

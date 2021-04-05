package markus.wieland.games.screen.interact_listener;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.screen.StartScreen;

/**
 * @author Markus Wieland
 * @since 03.04.2021
 * <p>
 * Extended version of the {@link ScreenInteractListener} to specify events of the {@link markus.wieland.games.screen.StartScreen}
 */
public interface StartScreenInteractListener extends ScreenInteractListener {

    /**
     * Will be called inside the {@link StartScreen#close()}
     *
     * @param configuration {@link GameConfiguration} build from the {@link StartScreen}
     */
    void onClose(GameConfiguration configuration);
}

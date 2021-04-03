package markus.wieland.games.screen.interact_listener;

import markus.wieland.games.game.GameConfiguration;

public interface StartScreenInteractListener extends ScreenInteractListener {
    void onClose(GameConfiguration configuration);
}

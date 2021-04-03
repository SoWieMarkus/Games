package markus.wieland.games.screen;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.screen.interact_listener.StartScreenInteractListener;

public abstract class StartScreen extends Screen {

    public StartScreen(@NonNull ViewGroup background) {
        super(background);
    }

    protected abstract GameConfiguration getConfiguration();

    @Override
    public void close(){
        super.close();
        ((StartScreenInteractListener)screenInteractListener).onClose(getConfiguration());
    }
}

package markus.wieland.games.screen;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.games.game.GameConfiguration;

public abstract class StartScreen extends Screen {

    protected ScreenInteractListener screenInteractListener;

    public StartScreen(@NonNull ViewGroup background) {
        super(background);
    }

    public void setScreenInteractListener(ScreenInteractListener screenInteractListener) {
        this.screenInteractListener = screenInteractListener;
    }

    protected abstract GameConfiguration getConfiguration();

    @Override
    public void close(){
        super.close();
        screenInteractListener.onClose(getConfiguration());
    }
}

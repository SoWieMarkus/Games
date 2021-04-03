package markus.wieland.games.screen;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.games.screen.interact_listener.ScreenInteractListener;

public abstract class Screen {

    protected final View background;

    protected ScreenInteractListener screenInteractListener;

    public Screen(@NonNull ViewGroup background) {
        this.background = background;
    }

    public void setScreenInteractListener(ScreenInteractListener screenInteractListener) {
        this.screenInteractListener = screenInteractListener;
    }

    public View getBackground() {
        return background;
    }

    public void setVisibility(int visibility) {
        background.setVisibility(visibility);
    }

    public void show(){
        setVisibility(View.VISIBLE);
    }

    public void close(){
        setVisibility(View.GONE);
    }
}

package markus.wieland.games.screen;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class Screen {

    protected final ViewGroup background;

    public Screen(@NonNull ViewGroup background) {
        this.background = background;
    }

    public ViewGroup getBackground() {
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

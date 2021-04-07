package markus.wieland.games.screen.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.screen.interact_listener.StartScreenInteractListener;

public abstract class StartScreenView extends ScreenView {

    public StartScreenView(@NonNull Context context) {
        super(context);
    }

    public StartScreenView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StartScreenView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScreenInteractListener(StartScreenInteractListener screenInteractListener) {
        this.screenInteractListener = screenInteractListener;
    }

    protected abstract GameConfiguration getConfiguration();

    @Override
    protected void onShow() {
    }

    @Override
    protected void onClose() {
        ((StartScreenInteractListener) screenInteractListener).onClose(getConfiguration());
    }

    @Override
    protected void onClose(boolean withConfiguration) {}
}

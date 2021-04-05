package markus.wieland.games.screen.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import markus.wieland.games.game.GameResult;
import markus.wieland.games.screen.interact_listener.EndScreenInteractListener;

public abstract class EndScreenView extends ScreenView {

    protected GameResult gameResult;

    public EndScreenView(@NonNull Context context) {
        super(context);
    }

    public EndScreenView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EndScreenView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScreenInteractListener(EndScreenInteractListener screenInteractListener) {
        this.screenInteractListener = screenInteractListener;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
        onNewGameResult();
    }

    protected abstract void onNewGameResult();

    @Override
    protected void onClose() {
        ((EndScreenInteractListener) screenInteractListener).onClose();
    }
}

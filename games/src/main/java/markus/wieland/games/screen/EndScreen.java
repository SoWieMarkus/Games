package markus.wieland.games.screen;

import android.view.ViewGroup;

import androidx.annotation.NonNull;

import markus.wieland.games.game.GameResult;
import markus.wieland.games.screen.interact_listener.EndScreenInteractListener;

public abstract class EndScreen extends Screen {

    protected GameResult gameResult;

    public EndScreen(@NonNull ViewGroup background) {
        super(background);
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
        update();
    }

    protected abstract void update();

    @Override
    public void close(){
        super.close();
        ((EndScreenInteractListener)screenInteractListener).onClose();
    }
}

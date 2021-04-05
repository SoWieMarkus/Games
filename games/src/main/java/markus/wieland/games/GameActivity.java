package markus.wieland.games;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.persistence.GameState;
import markus.wieland.games.screen.interact_listener.EndScreenInteractListener;
import markus.wieland.games.screen.interact_listener.StartScreenInteractListener;
import markus.wieland.games.screen.view.EndScreenView;
import markus.wieland.games.screen.view.StartScreenView;

public abstract class GameActivity<H extends Highscore, S extends GameState, GR extends GameResult, G extends Game<S, GR>> extends AppCompatActivity implements GameEventListener<GR> {

    protected GameSaver<S, H> gameSaver;
    protected GameGenerator<S> generator;

    protected StartScreenView startScreen;
    protected EndScreenView endScreen;

    protected G game;

    @LayoutRes
    protected final int layoutId;

    public GameActivity(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);

        gameSaver = initializeGameSaver();
        startScreen = initializeStartScreen();
        endScreen = initializeEndScreen();

        if (startScreen != null)
            startScreen.setScreenInteractListener((StartScreenInteractListener) this::load);
        if (endScreen != null) {
            endScreen.setScreenInteractListener((EndScreenInteractListener) this::restartGame);
            endScreen.setVisibility(View.GONE);
        }

        if (gameSaver != null) {
            loadGameStateFromGameSaver();
            if (startScreen != null) startScreen.setVisibility(View.GONE);
            return;
        }

        if (startScreen != null) startScreen.show();
    }

    protected abstract StartScreenView initializeStartScreen();

    protected abstract EndScreenView initializeEndScreen();

    protected void load(GameConfiguration configuration) {
        generator = initializeGenerator(configuration);
        if (generator == null) return;
        S s = generator.generate();
        initializeGame(s);
    }

    protected void restartGame() {
        recreate();
    }

    private void loadGameStateFromGameSaver() {
        S s = gameSaver.getGameState();
        if (s != null) {
            initializeGame(s);
        }
    }

    @Override
    public void onGameFinish(GR gameResult) {
        if (endScreen == null) return;
        endScreen.setGameResult(gameResult);
        endScreen.show();
    }

    @Override
    public void onGameStart() {

    }

    @Override
    public void onGamePause() {

    }

    protected abstract GameGenerator<S> initializeGenerator(GameConfiguration configuration);

    protected abstract GameSaver<S, H> initializeGameSaver();

    protected abstract void initializeGame(S s);
}

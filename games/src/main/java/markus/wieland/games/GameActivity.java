package markus.wieland.games;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.persistence.GameState;
import markus.wieland.games.screen.EndScreen;
import markus.wieland.games.screen.StartScreen;

public abstract class GameActivity<H extends Highscore, S extends GameState, GR extends GameResult, G extends Game<S, GR>> extends AppCompatActivity implements GameEventListener<GR> {

    protected GameSaver<S, H> gameSaver;
    protected GameGenerator<S> generator;

    protected StartScreen startScreen;
    protected EndScreen endScreen;

    protected G game;

    @LayoutRes
    protected final int layoutId;

    public GameActivity(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(layoutId);

        gameSaver = initializeGameSaver();
        startScreen = initializeStartScreen();
        endScreen = initializeEndScreen();
        startScreen.setScreenInteractListener(this::load);

        if (gameSaver != null) {
            loadGameStateFromGameSaver();
            startScreen.setVisibility(View.GONE);
            return;
        }

        startScreen.show();
    }

    protected abstract StartScreen initializeStartScreen();

    protected abstract EndScreen initializeEndScreen();

    protected void load(GameConfiguration configuration) {
        generator = initializeGenerator(configuration);
        S s = generator.generate();
        initializeGame(s);
    }

    private void loadGameStateFromGameSaver() {
        S s = gameSaver.getGameState();
        if (s != null) {
            initializeGame(s);
        }
    }

    @Override
    public void onGameFinish(GR gameResult) {
        endScreen.setGameResult(gameResult);
        endScreen.show();
    }

    protected abstract GameGenerator<S> initializeGenerator(GameConfiguration configuration);

    protected abstract GameSaver<S, H> initializeGameSaver();

    protected abstract void initializeGame(S s);
}

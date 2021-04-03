package markus.wieland.games;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameEventListener;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.persistence.GameState;

public abstract class GameActivity<H extends Highscore, S extends GameState, R extends GameResult, G extends Game<S, R>> extends AppCompatActivity implements GameEventListener {

    protected GameSaver<S, H> gameSaver;
    protected GameGenerator<S> generator;

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
        generator = initializeGameGenerator();

        S s = gameSaver.getGameState();
        if (s == null)
            s = generator.generate();
        initializeGame(s);
    }

    protected abstract GameSaver<S,H> initializeGameSaver();

    protected abstract GameGenerator<S> initializeGameGenerator();

    protected abstract void initializeGame(S s);
}

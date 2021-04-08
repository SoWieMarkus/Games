package markus.wieland.games;

import android.content.Intent;
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
import markus.wieland.games.screen.view.EndScreenView;
import markus.wieland.games.screen.view.StartScreenView;

public abstract class GameActivity<C extends GameConfiguration, H extends Highscore, S extends GameState, GR extends GameResult, G extends Game<S, GR>> extends AppCompatActivity implements GameEventListener<GR> {

    protected static final String KEY_CONFIGURATION = "markus.wieland.games.CONFIGURATION";

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
            startScreen.setScreenInteractListener(this::load);
        if (endScreen != null) {
            endScreen.setScreenInteractListener(this::restartActivity);
            endScreen.setVisibility(View.GONE);
        }

        C configuration = (C) getIntent().getSerializableExtra(KEY_CONFIGURATION);
        if (configuration != null) {
            load(configuration);
            if (startScreen != null) startScreen.setVisibility(View.GONE);
            return;
        }

        if (gameSaver != null && gameSaver.getGameState() != null) {
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

    @Override
    public void onAbort(ConfirmDialog confirmDialog) {
        if (confirmDialog != null) {
            if (game != null) game.setRunning(false);
            if (gameSaver != null) gameSaver.delete();
            confirmDialog.setConfirmClickListener((dialog, which) -> restartActivity(false));
            confirmDialog.getDialog(this).show();
        }
    }

    protected abstract GameGenerator<S> initializeGenerator(GameConfiguration configuration);

    protected abstract GameSaver<S, H> initializeGameSaver();

    protected abstract void initializeGame(S s);

    protected void restartActivity(boolean withConfiguration) {
        Intent intent = new Intent(this, getClass());
        if (withConfiguration && generator != null && generator.getConfiguration() != null) {
            intent.putExtra(KEY_CONFIGURATION, generator.getConfiguration());
        }
        startActivity(intent);
        finish();
    }
}

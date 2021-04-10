package markus.wieland.game;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import markus.wieland.games.GameActivity;
import markus.wieland.games.ai.pattern.Pattern;
import markus.wieland.games.ai.pattern.PatternMatcher;
import markus.wieland.games.game.Game;
import markus.wieland.games.game.GameConfiguration;
import markus.wieland.games.game.GameResult;
import markus.wieland.games.game.Highscore;
import markus.wieland.games.persistence.GameGenerator;
import markus.wieland.games.persistence.GameSaver;
import markus.wieland.games.persistence.GameState;
import markus.wieland.games.screen.view.EndScreenView;
import markus.wieland.games.screen.view.StartScreenView;

public class MainActivity extends GameActivity<GameConfiguration, Highscore, GameState, GameResult, Game<GameState, GameResult>> {


    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button2).setOnClickListener(view -> restartActivity(true));

        //PatternMatcher.getInstance().initialize(4, new ArrayList<>());
        //HashMap<Integer, List<Pattern>> patterns = (HashMap<Integer, List<Pattern>>)PatternMatcher.getInstance().getPatterns();
        //patterns.get(0);
    }

    @Override
    protected StartScreenView initializeStartScreen() {
        return null;
    }

    @Override
    protected EndScreenView initializeEndScreen() {
        return null;
    }

    @Override
    protected GameGenerator<GameState> initializeGenerator(GameConfiguration configuration) {
        return null;
    }

    @Override
    protected GameSaver<GameState, Highscore> initializeGameSaver() {
        return null;
    }

    @Override
    protected void initializeGame(GameState gameState) {

    }
}
package markus.wieland.games.game.level;

public interface LevelEventListener<L extends Level> {

    void onLevelCompleted(L l, LevelResult levelResult);


}

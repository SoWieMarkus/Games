package markus.wieland.games.game.level;

import java.util.List;

public class LevelManager<L extends Level> {

    protected final List<L> levels;
    protected int currentLevelIndex;

    public LevelManager(List<L> levels) {
        this.levels = levels;
        this.currentLevelIndex = 0;
    }

    public L getCurrentLevel(){
        return levels.get(currentLevelIndex);
    }

    public L getNextLevel(){
        currentLevelIndex++;
        if (currentLevelIndex < levels.size()) {
            return getCurrentLevel();
        }
        return null;
    }

    public int getAmountOfLevel(){
        return levels.size();
    }

    public int getCurrentLevelIndex(){
        return currentLevelIndex;
    }

    public List<L> getLevels() {
        return levels;
    }

}

package markus.wieland.games.ai;

import java.io.Serializable;
import java.util.Random;

import markus.wieland.games.game.Difficulty;

public abstract class AIMove implements Serializable {

    protected final Difficulty difficulty;
    protected final int player;
    protected Long rating;
    protected final Random random;

    public AIMove(Difficulty difficulty, int player) {
        this.difficulty = difficulty;
        this.player = player;
        this.rating = null;
        this.random = new Random();
    }

    public abstract boolean isLegal();

    protected long rate(){
        switch (difficulty){
            case MEDIUM:
                return mediumMove();
            case EASY:
                return easyMove();
            default:
                return hardMove();
        }
    }

    public long getRating() {
        if (rating == null)
            rating = rate();
        return rating;
    }

    protected abstract long easyMove();

    protected abstract long mediumMove();

    protected abstract long hardMove();

}

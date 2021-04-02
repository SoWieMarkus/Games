package markus.wieland.games.ai;

import markus.wieland.games.game.Difficulty;

public abstract class AIMove {

    protected final Difficulty difficulty;
    protected final int player;
    protected Long rating;

    public AIMove(Difficulty difficulty, int player) {
        this.difficulty = difficulty;
        this.player = player;
        this.rating = null;
    }

    public abstract boolean isLegal();

    public abstract long rate();

    public long getRating() {
        if (rating == null)
            rating = rate();
        return rating;
    }

}

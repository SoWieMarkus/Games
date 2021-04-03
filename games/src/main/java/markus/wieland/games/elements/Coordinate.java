package markus.wieland.games.elements;

/**
 * Coordinates to address a {@link markus.wieland.games.game.GameBoardField} inside a {@link markus.wieland.games.game.GameBoard}
 *
 * @author Markus Wieland
 * @since 03.04.2021
 */
public class Coordinate {

    /**
     * x-Coordinate
     */
    private final int x;

    /**
     * y-Coordinate
     *
     */
    private final int y;

    /**
     * @param x {@link #x}
     * @param y{@link #y}
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x-Coordinate
     * @return {@link #x}
     */
    public int getX() {
        return x;
    }

    /**
     *  Get y-Coordinate
     * @return {@link #y}
     */

    public int getY() {
        return y;
    }
}

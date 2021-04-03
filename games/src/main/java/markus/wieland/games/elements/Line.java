package markus.wieland.games.elements;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Markus Wieland
 * @since 03.04.2021
 * <p>
 * Class to manage a list of {@link Coordinate}
 */
public class Line implements Iterable<Coordinate> {

    /**
     * List of {@link Coordinate}
     */
    private final List<Coordinate> coordinates;

    public Line() {
        this.coordinates = new ArrayList<>();
    }

    /**
     * Add a coordinate to {@link #coordinates}
     * @param coordinate Coordinate which shall be add to {@link #coordinates}
     */
    public void add(Coordinate coordinate) {
        this.coordinates.add(coordinate);
    }

    /**
     * Get {@link Coordinate} by index inside the {@link #coordinates}
     * @param index Index of the coordinate inside the list
     * @return Coordinate at index
     */
    public Coordinate getCoordinate(int index) {
        if (index < 0 || index >= coordinates.size()) throw new ArrayIndexOutOfBoundsException("List size: " + coordinates.size() + ", Index: " + index);
        return coordinates.get(index);
    }

    /**
     * Get amount of {@link Coordinate} inside the {@link #coordinates}
     * @return {@link List#size()} of {@link #coordinates}
     */
    public int size() {
        return coordinates.size();
    }

    /**
     * Iterator to iterate over all {@link Coordinate}'s inside {@link #coordinates}
     * @return Iterator from {@link List#iterator()}
     */
    @NonNull
    @Override
    public Iterator<Coordinate> iterator() {
        return coordinates.iterator();
    }
}

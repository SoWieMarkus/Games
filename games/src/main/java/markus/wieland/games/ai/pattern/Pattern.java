package markus.wieland.games.ai.pattern;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    private final List<Boolean> patternToCheck;

    public Pattern(String pattern) {
        this.patternToCheck = new ArrayList<>();
        char[] chars = pattern.toCharArray();

        for (Character character : chars) {
            patternToCheck.add(character.equals('1'));
        }
    }

    public void append(boolean value, int amount) {
        for (int i = 0; i < amount; i++) {
            patternToCheck.add(value);
        }
    }

    public List<Boolean> getPatternToCheck() {
        return patternToCheck;
    }
}

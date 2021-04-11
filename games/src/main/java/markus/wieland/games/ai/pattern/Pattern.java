package markus.wieland.games.ai.pattern;

import java.util.ArrayList;
import java.util.List;

public class Pattern {

    private final List<PatternType> patternToCheck;

    public Pattern(String pattern) {
        this.patternToCheck = new ArrayList<>();
        char[] chars = pattern.toCharArray();

        for (Character character : chars) {
            patternToCheck.add(character.equals('1') ? PatternType.BLOCKED_BY_VALUE : PatternType.FREE);
        }
    }

    public void append(PatternType value, int amount) {
        for (int i = 0; i < amount; i++) {
            patternToCheck.add(value);
        }
    }

    public List<PatternType> getPatternToCheck() {
        return patternToCheck;
    }
}

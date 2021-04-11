package markus.wieland.games.ai.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import markus.wieland.games.elements.Line;

public class PatternMatcher {

    private static final PatternMatcher instance = new PatternMatcher();

    protected int amountOfBits;
    protected List<Line> lines;
    protected HashMap<Integer, List<Pattern>> patterns;

    protected int emptyValue;

    public static PatternMatcher getInstance() {
        return instance;
    }

    private PatternMatcher() {
    }

    public void initialize(int amountOfBits, List<Line> lines, int emptyValue) {

        this.patterns = new HashMap<>();
        this.lines = lines;
        this.amountOfBits = amountOfBits;
        this.emptyValue = emptyValue;

        generatePatterns();
    }

    private void generatePatterns() {
        List<String> possibleCombinations = getAllPossibleCombinations();
        for (int i = 0; i <= amountOfBits; i++) {
            patterns.put(i, new ArrayList<>());
        }

        for (String combination : possibleCombinations) {
            int amountOfTrueBits = getAmountOfTrueBits(combination);
            if (patterns.get(amountOfTrueBits) == null) {
                throw new IllegalArgumentException("Can't find patterns with " + amountOfTrueBits + " bits.");
            }
            patterns.get(amountOfTrueBits).add(new Pattern(combination));
        }
    }

    public void append(int amountOfBits, PatternType value) {
        for (Map.Entry<Integer, List<Pattern>> entry : patterns.entrySet()) {
            for (Pattern pattern : entry.getValue()) {
                pattern.append(value, amountOfBits);
            }
        }
    }

    public int getAmountOfBits() {
        return amountOfBits;
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getAmountOfMatchingPatterns(int amountBlockedFields, int valueOfBlockedFields, List<PatternMatchingLine> patternMatchingLines) {
        List<Pattern> patternsWithNBlockedFields = patterns.get(amountBlockedFields);
        if (patternsWithNBlockedFields == null)
            throw new IllegalArgumentException("Can't find any patterns with " + amountBlockedFields + " blocked fields.");

        int amountOfMatchingLines = 0;
        for (PatternMatchingLine line : patternMatchingLines) {
            for (Pattern pattern : patternsWithNBlockedFields) {
                if (checkMatch(pattern, line, valueOfBlockedFields)) amountOfMatchingLines++;
            }
        }

        return amountOfMatchingLines;
    }

    private boolean checkMatch(Pattern pattern, PatternMatchingLine line, int valueOfBlockedFields) {
        int[] values = line.getValues();
        List<PatternType> patternOfBlockedFields = pattern.getPatternToCheck();
        for (int i = 0; i < values.length; i++) {
            PatternType patternField = patternOfBlockedFields.get(i);
            int value = values[i];

            if ((patternField == PatternType.BLOCKED_BY_VALUE && value != valueOfBlockedFields) ||
                    (patternField == PatternType.BLOCKED && value == emptyValue) ||
                    (patternField == PatternType.FREE && value != emptyValue)){
                return false;
            }
        }
        return true;
    }

    private List<String> getAllPossibleCombinations() {
        int min = (int) Math.pow(2, amountOfBits);
        int max = (int) Math.pow(2, (double) amountOfBits + 1);

        List<String> possibleCombinations = new ArrayList<>();

        for (int k = min; k < max; k++) {
            StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(k));
            stringBuilder.deleteCharAt(0);
            possibleCombinations.add(stringBuilder.toString());
        }

        return possibleCombinations;
    }

    private int getAmountOfTrueBits(String combination) {
        char[] chars = combination.toCharArray();
        int amountOfTrueBits = 0;
        for (Character character : chars) {
            if (character.equals('1')) amountOfTrueBits++;
        }
        return amountOfTrueBits;
    }

    public Map<Integer, List<Pattern>> getPatterns() {
        return patterns;
    }

}

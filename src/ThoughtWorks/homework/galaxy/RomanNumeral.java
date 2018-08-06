package ThoughtWorks.homework.galaxy;

import java.util.List;

public class RomanNumeral {

    private String symbol;
    private int value;
    private boolean repeated;
    private int repeatedTimes;
    private boolean subtracted;
    private String subtractedPattern;

    public RomanNumeral(String symbol, int value, boolean repeated, int repeatedTimes, boolean subtracted, String subtractedPattern) {
        this.symbol = symbol;
        this.value = value;
        this.repeated = repeated;
        this.repeatedTimes = repeatedTimes;
        this.subtracted = subtracted;
        this.subtractedPattern = subtractedPattern;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRepeated() {
        return repeated;
    }

    public void setRepeated(boolean repeated) {
        this.repeated = repeated;
    }

    public int getRepeatedTimes() {
        return repeatedTimes;
    }

    public void setRepeatedTimes(int repeatedTimes) {
        this.repeatedTimes = repeatedTimes;
    }

    public boolean isSubtracted() {
        return subtracted;
    }

    public void setSubtracted(boolean subtracted) {
        this.subtracted = subtracted;
    }

    public String getSubtractedPattern() {
        return subtractedPattern;
    }

    public void setSubtractedPattern(String subtractedPattern) {
        this.subtractedPattern = subtractedPattern;
    }
}

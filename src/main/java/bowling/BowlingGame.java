package bowling;

public class BowlingGame {

    private int score = 0;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int firstInFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[firstInFrame])) {
                score += 10 + strikeBonus(firstInFrame);
                firstInFrame++;
            } else if (isSpare(firstInFrame)) {
                score += 10 + spareBonus(firstInFrame);
                firstInFrame += 2;
            } else {
                score += twoBallsInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }
        return score;
    }

    public int twoBallsInFrame(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1];
    }

    public int spareBonus(int firstInFrame) {
        return rolls[firstInFrame + 2];
    }

    private int strikeBonus(int firstInFrame) {
        return rolls[firstInFrame + 1] + rolls[firstInFrame + 2];
    }

    public boolean isStrike(int roll) {
        return roll == 10;
    }

    public boolean isSpare(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame + 1] == 10;
    }
}

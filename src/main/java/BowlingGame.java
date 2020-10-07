public class BowlingGame {
  private int currentRoundScore = 0;

  public void throwBall(int fallNumber) {
    currentRoundScore += fallNumber;
  }

  public int getCurrentRoundScore() {
    return currentRoundScore;
  }
}

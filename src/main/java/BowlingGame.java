public class BowlingGame {
  private int currentRoundScore = 0;

  public void throwBall(int fallNumber) throws Exception {
    if (currentRoundScore == 10){
      throw new RuntimeException("no chance to throw");
    }
    currentRoundScore += fallNumber;
  }

  public int getCurrentRoundScore() {
    return currentRoundScore;
  }
}

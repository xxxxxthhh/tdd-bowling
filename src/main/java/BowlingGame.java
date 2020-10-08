public class BowlingGame {
  private int [][] throwScore = new int[10][2];
  private int [] roundScore = new int[10];


  public void throwBall(int roundNum, int throwNum,int fallNumber)  {
    if (roundNum==10){
      roundScore[(roundNum-1)] += fallNumber;
      return;
    }
    if (throwScore[roundNum][0] == 10 && throwNum == 1){
      throw new RuntimeException("no chance to throw");
    }
    throwScore[roundNum][throwNum] += fallNumber;
  }

  public void calculateRoundScore() {
    for (int i = 0; i < 10; i++){
      roundScore[i] += throwScore[i][0] + throwScore[i][1];
    }

    for (int i = 0; i < 9; i++){
      if (throwScore[i][0] == 10){
        roundScore[i] += throwScore[i+1][0] + throwScore[i+1][1];
      } else if (throwScore[i][1]==10){
        roundScore[i] += throwScore[i+1][0];
      }
    }
  }

  public int[][] getThrowScore(){
    return throwScore;
  }

  public int[] getRoundScore(){
    return roundScore;
  }
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void before() {
        this.bowlingGame = new BowlingGame();
    }

    @Test
    public void throw_twice_less_than_ten_Score_is_sum() {
      int firstThrow = 4;
      int secondThrow = 5;
      bowlingGame.throwBall(firstThrow);
      bowlingGame.throwBall(secondThrow);
      assertEquals(9, bowlingGame.getCurrentRoundScore());
    }
}

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {
    private BowlingGame bowlingGame;

    @Before
    public void before() {
        this.bowlingGame = new BowlingGame();
    }

    @Test
    public void throw_twice_less_than_ten_Score_is_sum() throws Exception {
      int firstThrow = 4;
      int secondThrow = 5;
      bowlingGame.throwBall(firstThrow);
      bowlingGame.throwBall(secondThrow);
      assertEquals(9, bowlingGame.getCurrentRoundScore());
    }

    @Test
    public void cant_throw_if_first_throw_beat_all() throws Exception {
      int beatAll = 10;
      this.bowlingGame.throwBall(beatAll);
      try {
        bowlingGame.throwBall(2);
      }catch (RuntimeException runtimeException){
        assertThat(runtimeException.getMessage(), is("no chance to throw"));
      }
    }
}

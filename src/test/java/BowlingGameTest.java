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
    bowlingGame.throwBall(0, 0, firstThrow);
    bowlingGame.throwBall(0, 1, secondThrow);
    bowlingGame.calculateRoundScore();
    assertEquals(9, bowlingGame.getRoundScore()[0]);
  }

  @Test
  public void cant_throw_if_first_throw_beat_all() throws Exception {
    int beatAll = 10;
    this.bowlingGame.throwBall(0, 0, beatAll);
    try {
      bowlingGame.throwBall(0, 1, 2);
    } catch (RuntimeException runtimeException) {
      assertThat(runtimeException.getMessage(), is("no chance to throw"));
    }
  }

  @Test
  public void first_throw_beatALL_have_other_two_throws() throws Exception {
    bowlingGame.throwBall(0, 0, 10);
    bowlingGame.throwBall(1, 0, 3);
    bowlingGame.throwBall(1, 1, 2);
    bowlingGame.calculateRoundScore();
    assertEquals(15, bowlingGame.getRoundScore()[0]);
    assertEquals(5, bowlingGame.getRoundScore()[1]);
  }

  @Test
  public void if_first_bonus_throw_beatALL_have_other_one_throw() {
    bowlingGame.throwBall(0, 0, 5);
    bowlingGame.throwBall(0, 1, 10);
    bowlingGame.throwBall(1, 0, 5);
    bowlingGame.calculateRoundScore();
    assertEquals(20, bowlingGame.getRoundScore()[0]);
    assertEquals(5, bowlingGame.getRoundScore()[1]);
  }

  @Test
  public void tenth_strike_need_two_more_throw_to_get_score() {
    bowlingGame.throwBall(9, 0, 10);
    bowlingGame.throwBall(10, 0, 9);
    bowlingGame.throwBall(10, 1, 9);
    bowlingGame.calculateRoundScore();
    assertEquals(28, bowlingGame.getRoundScore()[9]);
  }

  @Test
  public void tenth_strike_first_bonus_beatAll() {
    bowlingGame.throwBall(9, 0, 5);
    bowlingGame.throwBall(9, 1, 10);
    bowlingGame.throwBall(10, 0, 10);
    bowlingGame.calculateRoundScore();
    assertEquals(25, bowlingGame.getRoundScore()[9]);
  }

  @Test
  public void tenth_strike_two_throws_and_no_beatALL() {
    bowlingGame.throwBall(9, 0, 5);
    bowlingGame.throwBall(9, 1, 6);
    bowlingGame.calculateRoundScore();
    assertEquals(11, bowlingGame.getRoundScore()[9]);
  }

  @Test
  public void tenth_strike_beatAll_twice() {
    bowlingGame.throwBall(9, 0, 10);
    bowlingGame.throwBall(10, 0, 10);
    bowlingGame.calculateRoundScore();
    assertEquals(20,bowlingGame.getRoundScore()[9]);
  }
}

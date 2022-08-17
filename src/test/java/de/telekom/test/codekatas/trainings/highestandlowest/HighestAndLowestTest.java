package de.telekom.test.codekatas.trainings.highestandlowest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * <p>In this little assignment you are given a string of space separated numbers, and have to
 * return the highest and lowest number.
 *
 * <p><i>Example</i>
 *
 * <pre>{@code highAndLow("1 2 3 4 5") // return "5 1"
 * highAndLow("1 2 -3 4 5") // return "5 -3"
 * highAndLow("1 9 3 4 -5") // return "9 -5"}</pre>
 *
 * <p>Notes:
 *
 * <p>All numbers are valid Int32, no need to validate them. There will always be at least one
 * number in the input string. Output string must be two numbers separated by a single space, and
 * highest number is first.
 */
class HighestAndLowestTest {

  @Test
  void test1() {
    assertEquals("42 -9", HighestAndLowestSolution.highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4"));
  }

  @Test
  public void someTest() {
    assertEquals(
        HighestAndLowestSolution.highAndLow("4 5 29 54 4 0 -214 542 -64 1 -3 6 -6"), "542 -214");
  }

  @Test
  public void sortTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("10 2 -2 -10"), "10 -10");
  }

  @Test
  public void plusMinusTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("1 -1"), "1 -1");
  }

  @Test
  public void plusPlusTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("1 1"), "1 1");
  }

  @Test
  public void minusMinusTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("-1 -1"), "-1 -1");
  }

  @Test
  public void plusMinusZeroTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("1 -1 0"), "1 -1");
  }

  @Test
  public void plusPlusZeroTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("1 1 0"), "1 0");
  }

  @Test
  public void minusMinusZeroTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("-1 -1 0"), "0 -1");
  }

  @Test
  public void singleTest() {
    assertEquals(HighestAndLowestSolution.highAndLow("42"), "42 42");
  }

  private static final int NUM_RANDOM_TESTS = 10;
  private static final int MAX_X = 1000;

  @Test
  public void randomTest() {
    Random r = new Random();

    for (int i = 0; i < NUM_RANDOM_TESTS; i++) {
      ArrayList<Integer> numbers = new ArrayList<Integer>();

      for (int o = 0; o < r.nextInt(10) + 5; o++) numbers.add(r.nextInt(MAX_X * 2) - MAX_X);

      String s = numbers.get(0).toString();
      for (int o = 1; o < numbers.size(); o++) s += " " + numbers.get(o).toString();

      assertEquals(
          HighestAndLowestSolution.highAndLow(s),
          Collections.max(numbers) + " " + Collections.min(numbers));
    }
  }
}

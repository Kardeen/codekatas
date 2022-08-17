package de.telekom.test.codekatas.trainings.sorttheodd;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * <p>You have an array of numbers. Your task is to sort ascending odd numbers but even numbers must
 * be on their places.
 *
 * <p>Zero isn't an odd number and you don't need to move it. If you have an empty array, you need
 * to return it.
 *
 * <p><i>Example</i>
 *
 * <pre>{@code sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]}</pre>
 */
class SortTheOddTest {

  @Test
  public void exampleTest1() {
    assertArrayEquals(
        new int[] {1, 3, 2, 8, 5, 4}, SortTheOddSolution.sortArray(new int[] {5, 3, 2, 8, 1, 4}));
  }

  @Test
  public void exampleTest2() {
    assertArrayEquals(
        new int[] {1, 3, 5, 8, 0}, SortTheOddSolution.sortArray(new int[] {5, 3, 1, 8, 0}));
  }

  @Test
  public void exampleTest3() {
    assertArrayEquals(new int[] {}, SortTheOddSolution.sortArray(new int[] {}));
  }

  @Test
  public void extendedTest1() {
    assertArrayEquals(
        new int[] {1, 3, 2, 8, 5, 4, 11},
        SortTheOddSolution.sortArray(new int[] {5, 3, 2, 8, 1, 4, 11}));
  }

  @Test
  public void extendedTest2() {
    assertArrayEquals(
        new int[] {2, 22, 1, 5, 4, 11, 37, 0},
        SortTheOddSolution.sortArray(new int[] {2, 22, 37, 11, 4, 1, 5, 0}));
  }

  @Test
  public void extendedTest3() {
    assertArrayEquals(
        new int[] {1, 1, 5, 11, 2, 11, 111, 0},
        SortTheOddSolution.sortArray(new int[] {1, 111, 11, 11, 2, 1, 5, 0}));
  }

  @Test
  public void extendedTest4() {
    assertArrayEquals(
        new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
        SortTheOddSolution.sortArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
  }

  @Test
  public void extendedTest5() {
    assertArrayEquals(
        new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        SortTheOddSolution.sortArray(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
  }

  @Test
  public void extendedTest6() {
    assertArrayEquals(
        new int[] {0, 1, 2, 3, 4, 5, 8, 7, 6, 9},
        SortTheOddSolution.sortArray(new int[] {0, 1, 2, 3, 4, 9, 8, 7, 6, 5}));
  }

  @Test
  public void randomTests() {
    Random random = new Random();
    for (int t = 0; t < 10; ++t) {
      int oddCount = random.nextInt(20);
      int minInputSize = oddCount + random.nextInt(20);

      List<Integer> odds = new ArrayList<>(oddCount);
      for (int i = 0; i < oddCount; ++i) {
        odds.add(random.nextInt(100) / 2 * 2 + 1); // odd
      }

      List<Integer> sortedOdds = new ArrayList<>(odds);
      Collections.sort(sortedOdds);

      List<Integer> input = new ArrayList<>(minInputSize);
      List<Integer> solution = new ArrayList<>(minInputSize);

      while (!odds.isEmpty()) {
        if (random.nextBoolean()) {
          input.add(odds.remove(0));
          solution.add(sortedOdds.remove(0));
        } else {
          int even = random.nextInt(50) * 2;
          input.add(even);
          solution.add(even);
        }
      }

      while (input.size() < minInputSize) {
        int even = random.nextInt(50) * 2;
        input.add(even);
        solution.add(even);
      }

      int[] expected = solution.stream().mapToInt(Integer::intValue).toArray();
      int[] actual =
          SortTheOddSolution.sortArray(input.stream().mapToInt(Integer::intValue).toArray());

      assertArrayEquals(expected, actual);
    }
  }
}

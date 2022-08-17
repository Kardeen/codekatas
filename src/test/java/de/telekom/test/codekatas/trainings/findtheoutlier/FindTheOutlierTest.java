package de.telekom.test.codekatas.trainings.findtheoutlier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * <p>You are given an array (which will have a length of at least 3, but could be very large)
 * containing integers. The array is either entirely comprised of odd integers or entirely comprised
 * of even integers except for a single integer N. Write a method that takes the array as an
 * argument and returns this "outlier" N.
 *
 * <p><i>Examples:</i>
 *
 * <pre>{@code [2, 4, 0, 100, 4, 11, 2602, 36] Should return: 11 (the only odd number)
 * [160, 3, 1719, 19, 11, 13, -21] Should return: 160 (the only even number)}</pre>
 */
class FindTheOutlierTest {

  @Test
  void outlierTest() {
    int[] exampleTest1 = {2, 6, 8, -10, 3};
    int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
    int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
    assertEquals(3, FindTheOutlierSolution.find(exampleTest1));
    assertEquals(206847684, FindTheOutlierSolution.find(exampleTest2));
    assertEquals(0, FindTheOutlierSolution.find(exampleTest3));
  }

  @Test
  void moreOutlierTests() {
    int[] ints1 = {2, 6, 8, 10, 3}; // odd at the back
    int[] ints2 = {2, 6, 8, 200, 700, 1, 84, 10, 4}; // odd in the middle
    int[] ints3 = {17, 6, 8, 10, 6, 12, 24, 36}; // odd in the front
    int[] ints4 = {2, 1, 7, 17, 19, 211, 7}; // even in the front
    int[] ints5 = {1, 1, 1, 1, 1, 44, 7, 7, 7, 7, 7, 7, 7, 7}; // even in the middle
    int[] ints6 = {
      3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 35, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7, 7, 7, 7, 1000
    }; // even at the end
    int[] ints7 = {2, -6, 8, -10, -3}; // odd at the back, negative
    int[] ints8 = {
      2, 6, 8, 2, -66, 34, -35, 66, 700, 1002, -84, 10, 4
    }; // odd in the middle, negative
    int[] ints9 = {
      -1 * Integer.MAX_VALUE, -18, 6, -8, -10, 6, 12, -24, 36
    }; // odd in the front, negative
    int[] ints10 = {-20, 1, 7, 17, 19, 211, 7}; // even in the front, negative
    int[] ints11 = {1, 1, -1, 1, 1, -44, 7, 7, 7, 7, 7, 7, 7, 7}; // even in the middle, negative
    int[] ints12 = {1, 0, 0}; // odd answer, zeroes
    int[] ints13 = {3, 7, -99, 81, 90211, 0, 7}; // even in the middle, zero

    assertEquals(3, FindTheOutlierSolution.find(ints1));
    assertEquals(1, FindTheOutlierSolution.find(ints2));
    assertEquals(17, FindTheOutlierSolution.find(ints3));
    assertEquals(2, FindTheOutlierSolution.find(ints4));
    assertEquals(44, FindTheOutlierSolution.find(ints5));
    assertEquals(1000, FindTheOutlierSolution.find(ints6));
    assertEquals(-3, FindTheOutlierSolution.find(ints7));
    assertEquals(-35, FindTheOutlierSolution.find(ints8));
    assertEquals(-1 * Integer.MAX_VALUE, FindTheOutlierSolution.find(ints9));
    assertEquals(-20, FindTheOutlierSolution.find(ints10));
    assertEquals(-44, FindTheOutlierSolution.find(ints11));
    assertEquals(1, FindTheOutlierSolution.find(ints12));
    assertEquals(0, FindTheOutlierSolution.find(ints13));
    // Random tests
    Random r = new Random();
    int positionA = r.nextInt(400);
    int positionB = r.nextInt(400);
    int[] randomOdds = new int[400];
    int[] randomEvens = new int[400];
    int evenSample = r.nextInt(3000) * 2;
    int oddSample = r.nextInt(3000) * 2 + 1;
    for (int i = 0; i < 400; i++) {
      randomOdds[i] = r.nextInt(3000) * 2 + 1;
    }
    for (int i = 0; i < 400; i++) {
      randomEvens[i] = r.nextInt(3000) * 2;
    }
    randomOdds[positionA] = evenSample;
    randomEvens[positionB] = oddSample;

    assertEquals(evenSample, FindTheOutlierSolution.find(randomOdds));
    assertEquals(oddSample, FindTheOutlierSolution.find(randomEvens));
    // large array test
    int positionC = r.nextInt(10000000);
    int positionD = r.nextInt(10000000);
    int[] bigOddArray = new int[10000000];
    int[] bigEvenArray = new int[10000000];
    for (int i = 0; i < 10000000; i++) {
      bigOddArray[i] = r.nextInt(100000) * 2 + 1;
      bigEvenArray[i] = r.nextInt(100000) * 2;
    }
    bigOddArray[positionC] = evenSample;
    bigEvenArray[positionD] = oddSample;
    assertEquals(evenSample, FindTheOutlierSolution.find(bigOddArray));
    assertEquals(oddSample, FindTheOutlierSolution.find(bigEvenArray));
  }
}

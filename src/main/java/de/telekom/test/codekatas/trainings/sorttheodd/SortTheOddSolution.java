package de.telekom.test.codekatas.trainings.sorttheodd;

import java.util.Arrays;

public class SortTheOddSolution {

  public static int[] sortArray(int[] ints) {
    var oddInts = Arrays.stream(ints).filter(n -> n % 2 != 0).sorted().toArray();
    int j = 0;
    for (int i = 0; i < ints.length; i++) {
      if (ints[i] % 2 != 0) {
        ints[i] = oddInts[j];
        j++;
      }
    }
    return ints;
  }
}

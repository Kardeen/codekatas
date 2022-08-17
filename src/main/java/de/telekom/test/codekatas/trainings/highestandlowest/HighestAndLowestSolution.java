package de.telekom.test.codekatas.trainings.highestandlowest;

import java.util.Arrays;

public class HighestAndLowestSolution {

  public static String highAndLow(String numbers) {
    int min = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).min(Integer::compare).get();
    int max = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).max(Integer::compare).get();

    return max + " " + min;
  }

  public static String HighAndLow(String numbers) {

    int min = Arrays.stream(numbers.split(" ")).mapToInt(i -> Integer.parseInt(i)).min().getAsInt();

    int max = Arrays.stream(numbers.split(" ")).mapToInt(i -> Integer.parseInt(i)).max().getAsInt();

    return String.format("%d %d", max, min);
  }
}

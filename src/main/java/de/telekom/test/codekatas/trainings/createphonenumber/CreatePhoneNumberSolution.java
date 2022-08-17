package de.telekom.test.codekatas.trainings.createphonenumber;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CreatePhoneNumberSolution {

  public static String createPhoneNumber(int[] numbers) {
    String numberString =
        Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining());
    return String.format(
        "(%s) %s-%s",
        numberString.substring(0, 3), numberString.substring(3, 6), numberString.substring(6, 10));
  }

  public static String createPhoneNumberAlternative(int[] numbers) {
    return String.format(
        "(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
  }
}

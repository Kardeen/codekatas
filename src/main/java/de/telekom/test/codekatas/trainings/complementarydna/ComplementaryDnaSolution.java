package de.telekom.test.codekatas.trainings.complementarydna;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ComplementaryDnaSolution {

  public static String makeComplement(String dna) {
    return Arrays.stream(dna.split("(?!^)"))
        .map(ComplementaryDnaSolution::getCorrespondingString)
        .collect(Collectors.joining(""));
  }

  public static String getCorrespondingString(String s) {
    switch (s) {
      case "A":
        return "T";
      case "T":
        return "A";
      case "G":
        return "C";
      default:
        return "G";
    }
  }
}

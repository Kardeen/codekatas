package de.telekom.test.codekatas.trainings.fibonacciproducts;

import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

public class FibonacciProductsSolution {

  public static long[] productFib(long prod) {

    // If the product gets to big you need to switch to BigInteger
    var fibonacciNumbers =
        Stream.iterate(new long[] {0, 1}, t -> new long[] {t[1], t[0] + t[1]})
            .limit(50)
            .map(n -> n[0])
            .collect(toList());

    for (int i = 0; i < fibonacciNumbers.size() - 1; i++) {
      if ((fibonacciNumbers.get(i) * fibonacciNumbers.get(i + 1)) == prod) {
        return new long[] {fibonacciNumbers.get(i), fibonacciNumbers.get(i + 1), 1};
      } else if ((fibonacciNumbers.get(i) * fibonacciNumbers.get(i + 1)) > prod) {
        return new long[] {fibonacciNumbers.get(i), fibonacciNumbers.get(i + 1), 0};
      }
    }

    return null;
  }

  public static long[] productFibWithoutLimit(long prod) {
    long a = 0L;
    long b = 1L;
    while (a * b < prod) {
      long tmp = a;
      a = b;
      b = tmp + b;
    }
    return new long[] {a, b, a * b == prod ? 1 : 0};
  }
}

package de.telekom.test.codekatas.trainings.complementarydna;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Description:
 *
 * <p>Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the
 * "instructions" for the development and functioning of living organisms.
 *
 * <p>If you want to know more <a
 * href="http://en.wikipedia.org/wiki/DNA">http://en.wikipedia.org/wiki/DNA</a>
 *
 * <p>In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have
 * function with one side of the DNA (string, except for Haskell); you need to get the other
 * complementary side. DNA strand is never empty or there is no DNA at all (again, except for
 * Haskell).
 *
 * <p>More similar exercise are found here <a
 * href="http://rosalind.info/problems/list-view/">http://rosalind.info/problems/list-view/</a>
 * (source)
 *
 * <pre>{@code
 * ComplementaryDna.makeComplement("ATTGC") // return "TAACG"
 *
 * ComplementaryDna.makeComplement("GTAT") // return "CATA"
 * }</pre>
 */
class ComplementaryDnaTest {

  @Test
  public void testEx01() {
    assertEquals("TTTT", ComplementaryDnaSolution.makeComplement("AAAA"));
  }

  @Test
  public void testEx02() {
    assertEquals("TAACG", ComplementaryDnaSolution.makeComplement("ATTGC"));
  }

  @Test
  public void testEx03() {
    assertEquals("CATA", ComplementaryDnaSolution.makeComplement("GTAT"));
  }

  @Test
  public void test01() {
    assertEquals("TTTT", ComplementaryDnaSolution.makeComplement("AAAA"));
  }

  @Test
  public void test02() {
    assertEquals("TAACG", ComplementaryDnaSolution.makeComplement("ATTGC"));
  }

  @Test
  public void test03() {
    assertEquals("CATA", ComplementaryDnaSolution.makeComplement("GTAT"));
  }

  @Test
  public void test04() {
    assertEquals("TTCC", ComplementaryDnaSolution.makeComplement("AAGG"));
  }

  @Test
  public void test05() {
    assertEquals("GCGC", ComplementaryDnaSolution.makeComplement("CGCG"));
  }

  @Test
  public void test06() {
    assertEquals("TAACG", ComplementaryDnaSolution.makeComplement("ATTGC"));
  }

  @Test
  public void test07() {
    assertEquals(
        "CATAGCTAGCTAGCTAGCTAATATAAAAGCTGCTCTAAATTTATATATATATATGCTCTCTTATGTCTATCTGTCTAAT",
        ComplementaryDnaSolution.makeComplement(
            "GTATCGATCGATCGATCGATTATATTTTCGACGAGATTTAAATATATATATATACGAGAGAATACAGATAGACAGATTA"));
  }
}

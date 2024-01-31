import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
  @Test
  public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[] { 3 }, input1);

    int[] input2 = { 1, 2, 3 };
    ArrayExamples.reverseInPlace(input2);
    assertArrayEquals(new int[] { 3, 2, 1 }, input2);

    int[] input3 = { 1, 2, 3, 4 };
    ArrayExamples.reverseInPlace(input3);
    assertArrayEquals(new int[] { 4, 3, 2, 1 }, input3);

    int[] input4 = {};
    ArrayExamples.reverseInPlace(input4);
    assertArrayEquals(new int[] {}, input4);
  }

  @Test
  public void testReversed() {
    int[] input1 = {};
    assertArrayEquals(new int[] {}, ArrayExamples.reversed(input1));

    int[] input2 = { 1, 2, 3 };
    assertArrayEquals(new int[] { 3, 2, 1 }, ArrayExamples.reversed(input2));

    int[] input3 = { 1, 2, 3, 4 };
    assertArrayEquals(new int[] { 4, 3, 2, 1 }, ArrayExamples.reversed(input3));

    int[] input4 = { 3 };
    assertArrayEquals(new int[] { 3 }, ArrayExamples.reversed(input4));
  }

  @Test
  public void testAverageWithoutLowest() {
    double[] input1 = { 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 5 };
    assertEquals(Double.valueOf(3.0), Double.valueOf(ArrayExamples.averageWithoutLowest(input1)));
  }
}

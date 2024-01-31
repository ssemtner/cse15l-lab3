import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

class CheckContains implements StringChecker {
  private String contains;

  CheckContains(String contains) {
    this.contains = contains;
  }

  @Override
  public boolean checkString(String s) {
    return s.contains(contains);
  }
}

public class ListTests {
  @Test
  public void testFilter() {
    ArrayList<String> input1 = new ArrayList<>();
    input1.add("a");
    input1.add("b");
    input1.add("ab");
    input1.add("bc");
    input1.add("abc");

    assertArrayEquals(new String[] { "a", "ab", "abc" },
        ListExamples.filter(input1, new CheckContains("a")).toArray());

    ArrayList<String> input2 = new ArrayList<>();
    input2.add("no");
    input2.add("yes");
    input2.add("help");
    input2.add("ahhhh");
    input2.add("hello");

    assertArrayEquals(new String[] { "help", "hello" },
        ListExamples.filter(input2, new CheckContains("he")).toArray());
  }

  @Test
  public void testSort() {
    ArrayList<String> input1 = new ArrayList<>();
    input1.add("apple");
    input1.add("orange");
    input1.add("strawberry");

    ArrayList<String> input2 = new ArrayList<>();
    input2.add("attack");
    input2.add("battle");
    input2.add("locate");
    input2.add("yonder");

    assertArrayEquals(new String[] { "apple", "attack", "battle", "locate", "orange", "strawberry", "yonder" },
        ListExamples.merge(input1, input2).toArray());
  }

}

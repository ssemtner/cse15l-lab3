import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
  LinkedList emptyList;
  LinkedList oneElementList;
  LinkedList threeElementList;

  @Before
  public void setup() {
    emptyList = new LinkedList();

    oneElementList = new LinkedList();
    Node node = new Node(1, null);
    oneElementList.root = node;

    threeElementList = new LinkedList();
    Node node3 = new Node(3, null);
    Node node2 = new Node(2, node3);
    Node node1 = new Node(1, node2);
    threeElementList.root = node1;
  }

  private Node getTail(LinkedList list) {
    Node ref = list.root;
    while (ref.next != null) {
      ref = ref.next;
    }
    return ref;
  }

  @Test
  public void testPrependEmptyList() {
    emptyList.prepend(-1);
    assertEquals(-1, emptyList.root.value);
    assertNull(emptyList.root.next);
  }

  @Test
  public void testPrependOneElementList() {
    Node prevHead = oneElementList.root;
    oneElementList.prepend(-1);
    assertEquals(-1, oneElementList.root.value);
    assertSame(prevHead, oneElementList.root.next);
    assertEquals(2, oneElementList.length());
  }

  @Test
  public void testPrependThreeElementList() {
    Node prevHead = threeElementList.root;
    threeElementList.prepend(-1);
    assertEquals(-1, threeElementList.root.value);
    assertSame(prevHead, threeElementList.root.next);
    assertNotNull(threeElementList.root.next.next);
    assertNull(threeElementList.root.next.next.next.next);
    assertEquals(4, threeElementList.length());
  }

  @Test
  public void testAppendEmpty() {
    emptyList.append(10);
    assertEquals(10, emptyList.root.value);
    assertNull(emptyList.root.next);
  }

  @Test
  public void testAppendOneElementList() {
    Node prevTail = getTail(oneElementList);
    oneElementList.append(10);
    assertEquals(1, oneElementList.root.value);
    assertEquals(10, oneElementList.root.next.value);
    assertSame(prevTail, oneElementList.root);
    assertNull(oneElementList.root.next.next);
    assertEquals(2, oneElementList.length());
  }

  @Test
  public void testAppendThreeElementList() {
    Node prevTail = getTail(threeElementList);
    threeElementList.append(10);
    assertEquals(1, threeElementList.root.value);
    assertEquals(10, getTail(threeElementList).value);
    assertNull(getTail(threeElementList).next);
    assertSame(prevTail, threeElementList.root.next.next);
    assertEquals(4, threeElementList.length());
  }
}

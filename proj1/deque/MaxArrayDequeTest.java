package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {
    @Test
    public void maxStringTest() {
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(String::compareTo);
        lld1.addFirst("a");
        lld1.addLast("b");
        lld1.addLast("c");
        assertEquals("c", lld1.max());
    }

    @Test
    public void maxIntegerTest() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(Integer::compareTo);
        lld1.addFirst(1);
        lld1.addLast(2);
        lld1.addLast(3);
        assertEquals(3, (int) lld1.max());
    }

    @Test
    public void multipleMaxTest() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(Integer::compareTo);
        lld1.addFirst(3);
        lld1.addLast(2);
        lld1.addLast(2);
        lld1.addLast(3);
        assertEquals(3, (int) lld1.max());
    }

    @Test
    public void minIntegerTest() {
        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(Integer::compareTo);
        lld1.addFirst(1);
        lld1.addLast(2);
        lld1.addLast(3);
        assertEquals(1, (int) lld1.max(Comparator.reverseOrder()));
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        MaxArrayDeque<Integer> lld1 = new MaxArrayDeque<Integer>(Integer::compareTo);
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (int i = 0; i < 500000; i++) {
            lld1.removeFirst();
        }
        assertEquals(999999, (int) lld1.max());

        for (int i = 999999; i > 500000; i--) {
            lld1.removeLast();
        }
        assertEquals(500000, (int) lld1.max());
    }

    @Test
    public void maxEmptyTest() {
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(String::compareTo);
        assertEquals(null, lld1.max());
    }

    @Test
    public void maxEmptyTest2() {
        MaxArrayDeque<String> lld1 = new MaxArrayDeque<String>(String::compareTo);
        assertEquals(null, lld1.max(String::compareTo));
    }
}

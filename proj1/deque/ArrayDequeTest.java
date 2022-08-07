package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Tests get from an deque */
    public void getTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);
        lld1.addLast(4);
        lld1.addLast(5);

        assertEquals("first element should be 3", 3, (long) lld1.get(0));
        assertEquals("second element should be 4", 4, (long) lld1.get(1));
        assertEquals("last element should be 3", 5, (long) lld1.get(2));

        assertNull("fourth element should be null", lld1.get(3));

    }

    @Test
    /* Check if you can create ArrayDeques with different parameterized types*/
    public void multipleParamTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<Double> lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* fill up, empty, fill up again. */
    public void fillThenEmptyThenFillAgainTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);
        lld1.addLast(5);
        lld1.addLast(6);
        lld1.addLast(7);
        lld1.addLast(8);

        assertEquals(8, lld1.size);
        lld1.printDeque();

        assertEquals(4, (long) lld1.removeFirst());
        assertEquals(3, (long) lld1.removeFirst());
        assertEquals(2, (long) lld1.removeFirst());
        assertEquals(1, (long) lld1.removeFirst());
        assertEquals(8, (long) lld1.removeLast());
        assertEquals(7, (long) lld1.removeLast());
        assertEquals(6, (long) lld1.removeLast());
        assertEquals(5, (long) lld1.removeLast());

        assertEquals(0, lld1.size);
        lld1.printDeque();

        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);
        lld1.addLast(5);
        lld1.addLast(6);
        lld1.addLast(7);
        lld1.addLast(8);

        assertEquals(8, lld1.size);
        lld1.printDeque();
    }

    @Test
    public void twoArrayDequesTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        ArrayDeque<Integer> lld2 = new ArrayDeque<Integer>();
        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);
        lld1.addLast(5);
        lld1.addLast(6);
        lld1.addLast(7);
        lld1.addLast(8);

        lld2.addFirst(8);
        lld2.addFirst(7);
        lld2.addFirst(6);
        lld2.addFirst(5);
        lld2.addLast(4);
        lld2.addLast(3);
        lld2.addLast(2);
        lld2.addLast(1);

        assertEquals(8, lld1.size);
        assertEquals(8, lld2.size);

        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();

        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();
        lld2.removeLast();
        lld2.removeFirst();
        lld2.removeFirst();
        lld2.removeFirst();
        lld2.removeFirst();

        assertEquals(0, lld1.size);
        assertEquals(0, lld2.size);

        lld1.addFirst(1);
        lld1.addFirst(2);
        lld1.addFirst(3);
        lld1.addFirst(4);
        lld1.addLast(5);
        lld1.addLast(6);
        lld1.addLast(7);
        lld1.addLast(8);

        lld2.addFirst(8);
        lld2.addFirst(7);
        lld2.addFirst(6);
        lld2.addFirst(5);
        lld2.addLast(4);
        lld2.addLast(3);
        lld2.addLast(2);
        lld2.addLast(1);

        assertEquals(8, lld1.size);
        assertEquals(8, lld2.size);
    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    /* Adds a few things to the list, checking iterator() is correct */
    public void iteratorTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        assertEquals(3, lld1.size());

        Iterator<String> iterator = lld1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("front", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("middle", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("back", iterator.next());

        assertFalse(iterator.hasNext());
        assertEquals(3, lld1.size());
    }

    @Test
    /* Tests iterate from an empty deque */
    public void emptyIteratorTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        assertEquals(0, lld1.size());

        Iterator<String> iterator = lld1.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    /* Test equals true when two list are same */
    public void equalsTrueTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        ArrayDeque<String> lld2 = new ArrayDeque<String>();
        lld2.addFirst("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertTrue(lld1.equals(lld2));
        assertTrue(lld2.equals(lld1));
    }

    @Test
    /* Test equals false when different size */
    public void equalsDifferentSizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("front");
        lld1.addLast("back");

        ArrayDeque<String> lld2 = new ArrayDeque<String>();
        lld2.addFirst("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    /* Test equals false when same size but different order */
    public void equalsSameSizeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("1");
        lld1.addLast("2");

        ArrayDeque<String> lld2 = new ArrayDeque<String>();
        lld2.addFirst("2");
        lld2.addLast("1");

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    /* Test equals false when same "value" but different type */
    public void equalsDifferentTypeTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("1");
        lld1.addLast("2");

        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        lld2.addFirst(1);
        lld2.addLast(2);

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    /* Test equals true when two are both empty */
    public void equalsEmptyTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        ArrayDeque<String> lld2 = new ArrayDeque<String>();

        assertTrue(lld1.equals(lld2));
        assertTrue(lld2.equals(lld1));
    }
}

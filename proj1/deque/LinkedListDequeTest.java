package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

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

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
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
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
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

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        assertEquals(0, lld1.size());

        Iterator<String> iterator = lld1.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    /* Test equals true when two list are same */
    public void equalsTrueTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");

        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
        lld2.addFirst("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertTrue(lld1.equals(lld2));
        assertTrue(lld2.equals(lld1));
    }

    @Test
    /* Test equals false when different size */
    public void equalsDifferentSizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("front");
        lld1.addLast("back");

        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
        lld2.addFirst("front");
        lld2.addLast("middle");
        lld2.addLast("back");

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    /* Test equals false when same size but different order */
    public void equalsSameSizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("1");
        lld1.addLast("2");

        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
        lld2.addFirst("2");
        lld2.addLast("1");

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    /* Test equals false when same "value" but different type */
    public void equalsDifferentTypeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("1");
        lld1.addLast("2");

        LinkedListDeque<Integer> lld2 = new LinkedListDeque<>();
        lld2.addFirst(1);
        lld2.addLast(2);

        assertFalse(lld1.equals(lld2));
        assertFalse(lld2.equals(lld1));
    }

    @Test
    /* Test equals true when two are both empty */
    public void equalsEmptyTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();

        assertTrue(lld1.equals(lld2));
        assertTrue(lld2.equals(lld1));
    }

    @Test
    /* Tests get recursive from deque */
    public void getRecursiveTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("front");
        lld1.addLast("middle");
        lld1.addLast("back");
        assertEquals("front", lld1.getRecursive(0));
        assertEquals("middle", lld1.getRecursive(1));
        assertEquals("back", lld1.getRecursive(2));
        assertEquals(null, lld1.getRecursive(-1));
        assertEquals(null, lld1.getRecursive(3));
    }

    @Test
    /* Tests get recursive from an empty deque */
    public void getRecursiveEmptyTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        assertEquals(null, lld1.getRecursive(0));
        assertEquals(null, lld1.getRecursive(1));
        assertEquals(null, lld1.getRecursive(-1));
    }

    @Test
    /* Test equals true when same size and order with different implementation */
    public void equalsSameSizeDifferentImplementationTest() {

        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("1");
        lld1.addLast("2");

        LinkedListDeque<String> lld2 = new LinkedListDeque<String>();
        lld2.addFirst("1");
        lld2.addLast("2");

        assertTrue(lld1.equals(lld2));
        assertTrue(lld2.equals(lld1));
    }
}

package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    private static final int INITIAL_CAPACITY = 8;


    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        resize();
        items[nextFirst] = item;
        nextFirst = leftNeighbor(nextFirst);
        size++;
    }

    private int leftNeighbor(int curr) {
        return indexOf(curr, -1);
    }

    @Override
    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        nextLast = rightNeighbor(nextLast);
        size++;
    }

    private int rightNeighbor(int curr) {
        return indexOf(curr, 1);
    }

    @Override
    public int size() {
        return size;

    }

    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        resize();
        int firstIndex = rightNeighbor(nextFirst);
        T first = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size--;
        return first;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        resize();
        int lastIndex = leftNeighbor(nextLast);
        T last = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;
        size--;
        return last;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = indexOf(nextFirst, 1 + index);
        return items[i];
    }

    // index > 0 means moving to right, otherwise left.
    private int indexOf(int curr, int stepsOfMovingToRight) {
        int i = curr + stepsOfMovingToRight;
        if (i >= items.length) {
            return i % items.length;
        }
        if (i < 0) {
            return items.length + (i % items.length);
        }
        return i;
    }

    private void resize() {
        int capacity = items.length;
        if (size * 4 <= capacity && capacity / 2 >= INITIAL_CAPACITY) {
            // shrink
            T[] newItems = (T[]) new Object[capacity / 2];
            Iterator<T> iterator = iterator();
            int i = 0;
            while (iterator.hasNext()) {
                newItems[i++] = iterator.next();
            }
            items = newItems;
            nextFirst = indexOf(0, -1);
            nextLast = size;
        } else if (size >= capacity * 3 / 4) {
            // expand
            T[] newItems = (T[]) new Object[capacity * 2];
            Iterator<T> iterator = iterator();
            int i = 0;
            while (iterator.hasNext()) {
                newItems[i++] = iterator.next();
            }
            items = newItems;
            nextFirst = indexOf(0, -1);
            nextLast = size;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        T curr;
        int index;
        ArrayDequeIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return get(index++);
        }
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque<?>)) {
            return false;
        }
        if (this.size != ((Deque<?>) o).size()) {
            return false;
        }

        for (int i = 0; i < this.size; i++) {
            if (!this.get(i).equals(((Deque<?>) o).get(i))) {
                return false;
            }
        }
        return true;
    }
}

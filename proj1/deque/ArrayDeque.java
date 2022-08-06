package deque;

import java.util.Iterator;

public class ArrayDeque<T> {
    T[] items;
    int size;
    int nextFirst;
    int nextLast;

    private static final int INITIAL_CAPACITY = 8;


    public ArrayDeque() {
        items = (T[]) new Object[INITIAL_CAPACITY];
        nextFirst = items.length / 2;
        nextLast = nextFirst + 1;
        size = 0;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        nextFirst = prev(nextFirst);
        size++;
    }

    private int prev(int curr) {
        return (curr - 1) % items.length;
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = next(nextLast);
        size++;
    }

    private int next(int curr) {
        return (curr + 1) % items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;

    }

    public void printDeque() {
        int i = next(nextFirst);
        while (i != nextLast) {
            System.out.print(items[i] + " ");
            i = next(i);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        int firstIndex = next(nextFirst);
        T first = items[firstIndex];
        nextFirst = firstIndex;
        size--;
        return first;
    }

    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        int lastIndex = prev(nextLast);
        T last = items[lastIndex];
        nextLast = lastIndex;
        size--;
        return last;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int i = (next(nextFirst) + index) % items.length;
        return items[i];
    }

//    public Iterator<T> iterator() {
//        LinkedListDeque.Node<T> p = sentinel;
//        return new LinkedListDeque.LinkedListDequeIterator<>(p);
//    }
//
//    private static class ArrayDequeIterator<T> implements Iterator<T> {
//        LinkedListDeque.Node<T> last;
//        LinkedListDeque.Node<T> curr;
//        public ArrayDequeIterator(LinkedListDeque.Node<T> sentinel) {
//            this.curr = sentinel;
//            this.last = sentinel.prev;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return curr != last;
//        }
//
//        @Override
//        public T next() {
//            curr = curr.next;
//            return curr.obj;
//        }
//    }
//
//    public boolean equals(Object o) {
//        if (!(o instanceof ArrayDeque<?>)) {
//            return false;
//        }
//        if (this.size != ((ArrayDeque<?>) o).size) {
//            return false;
//        }
//        Iterator<?> iteratorO = ((ArrayDeque<?>) o).iterator();
//        Iterator<?> iteratorT = this.iterator();
//        while (iteratorO.hasNext()) {
//            if (!iteratorO.next().equals(iteratorT.next())) {
//                return false;
//            }
//        }
//        return true;
//    }
}

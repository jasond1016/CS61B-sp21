package deque;

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
        nextFirst = leftNeighbor(nextFirst);
        size++;
    }

    private int leftNeighbor(int curr) {
        return indexOf(curr, -1);
    }

    public void addLast(T item) {
        items[nextLast] = item;
        nextLast = rightNeighbor(nextLast);
        size++;
    }

    private int rightNeighbor(int curr) {
        return indexOf(curr, 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;

    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        int firstIndex = rightNeighbor(nextFirst);
        T first = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size--;
        return first;
    }

    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        int lastIndex = leftNeighbor(nextLast);
        T last = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;
        size--;
        return last;
    }

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

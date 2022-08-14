package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>((T) new Object());
        Node<T> temp = sentinel;
        sentinel.prev = temp;
        sentinel.next = temp;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        Node<T> temp = sentinel.next;
        Node<T> curr = new Node<>(item, sentinel, temp);
        sentinel.next.prev = curr;
        sentinel.next = curr;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> temp = sentinel.prev;
        Node<T> curr = new Node<>(item, temp, sentinel);
        sentinel.prev.next = curr;
        sentinel.prev = curr;
        size++;
    }

    @Override
    public int size() {
        return size;
                
    }

    @Override
    public void printDeque() {
        Node<T> p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.obj + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        Node<T> first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size--;
        return first.obj;
    }

    @Override
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        Node<T> last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size--;
        return last.obj;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node<T> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.obj;
    }

    public Iterator<T> iterator() {
        Node<T> p = sentinel;
        return new LinkedListDequeIterator(p);
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        Node last;
        Node curr;
        LinkedListDequeIterator(Node sentinel) {
            this.curr = sentinel;
            this.last = sentinel.prev;
        }

        @Override
        public boolean hasNext() {
            return curr != last;
        }

        @Override
        public T next() {
            curr = curr.next;
            return (T) curr.obj;
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

    public T getRecursive(int index) {
        Node<T> p = sentinel.next;
        return getRecursiveHelper(p, index);
    }

    private T getRecursiveHelper(Node<T> curr, int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return curr.obj;
        }
        return getRecursiveHelper(curr.next, index - 1);
    }

    private static class Node<T> {
        T obj;
        Node<T> prev;
        Node<T> next;

        Node() {
        }

        Node(T obj) {
            this.obj = obj;
        }

        Node(T obj, Node<T> prev, Node<T> next) {
            this.obj = obj;
            this.prev = prev;
            this.next = next;
        }
    }
}

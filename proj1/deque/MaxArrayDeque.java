package deque;

import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;
    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
    }

    public T max() {
        return this.max(this.c);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        Iterator<T> it = iterator();
        T max = it.next();
        while (it.hasNext()) {
            T element = it.next();
            max = c.compare(max, element) >= 0 ? max : element;
        }
        return max;
    }
}

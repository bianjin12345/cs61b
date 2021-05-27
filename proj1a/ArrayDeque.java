public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty ArrayDeque of size 8 */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private int addOne(int a) {
        return (a + 1) % items.length;
    }

    private int subOne(int a) {
        return (a - 1 + items.length) % items.length;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
      */
    public T get(int x) {
        if (x >= size) {
            return null;
        }
        int start = 0;
        if (nextFirst == items.length-1) {
            start = 0;
        }else {
            start = nextFirst + 1;
        }
        System.out.println(items[(start + x) % items.length]);
        return items[(start + x) % items.length];
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int length) {
        T[] a = (T[]) new Object[length];
        int start = 0;
        if (nextFirst == items.length-1) {
            start = 0;
        }else {
            start = nextFirst + 1;
        }
        for (int i = 0; i < size; i++){
            a[i] = items[start];
            if (start == items.length-1) {
                start = 0;
            }else {
                start = start + 1;
            }
        }
        items = a;
        nextFirst = a.length - 1;
        nextLast = size;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T k) {
        if (size == items.length) {
            resize(2*size);
        }
        items[nextFirst] = k;
        size = size + 1;
        moveCounterClockwise();
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T k) {
        if (size == items.length) {
            resize(2*size);
        }
        items[nextLast] = k;
        size = size + 1;
        moveClockwise();
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** move in counter clockwise direction */
    private void moveCounterClockwise() {
        if (nextFirst == 0){
            nextFirst = items.length - 1;
        }
        else {
            nextFirst = nextFirst - 1;
        }
    }

    /** move in clockwise direction */
    private void moveClockwise() {
        if (nextLast == items.length - 1){
            nextLast = 0;
        }
        nextLast = nextLast + 1;
    }

    /**  Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        int next = nextFirst;
        if (next == items.length-1) {
            next = 0;
        }else {
            next = next + 1;
        }
        for (int i=0; i<size; i++) {
            System.out.print(items[next]+" ");
            if (next == items.length-1) {
                next = 0;
            }else{
                next = next + 1;
            }
        System.out.println();
        }
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T a = items[addOne(nextFirst)];
        items[addOne(nextFirst)] = null;
        nextFirst = addOne(nextFirst);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }


    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0){
            return null;
        }

        T a = items[subOne(nextLast)];
        items[subOne(nextLast)] = null;
        nextLast = subOne(nextLast);
        size -= 1;
        if (items.length >= 16 && size < (items.length / 4)) {
            resize(items.length / 2);
        }
        return a;
    }

}





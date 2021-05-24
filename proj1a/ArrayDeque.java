public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty ArrayDeque of size 8 */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
      */
    public T get(int x) {
        return items[x];
    }

    /** Resizes the underlying array to the target capacity. */
    private void resizeIncrease() {
        T[] a = (T[]) new Object[size * 2];
        System.arraycopy(items,0,a,0,size);
        items = a;
        nextFirst = a.length - 1;
        nextLast = size;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resizeDecrease() {
        T[] a;
        if (items.length % 2 == 0) {
            a = (T[]) new Object[items.length / 2];
        } else{
            a = (T[]) new Object[items.length / 2 + 1];
        }
        T[] b = items;
        if (nextFirst == items.length-1) {
            nextFirst = 0;
        }else{
            nextFirst = nextFirst + 1;
        }
        for (int i = 0; i<size; i++) {
            b[i] = items[nextFirst];
            if (nextFirst == items.length-1) {
                nextFirst = 0;
            }else {
                nextFirst = nextFirst + 1;
            }
        }
        System.arraycopy(b,0,a,0,size);
        items = a;
        nextFirst = a.length - 1;
        nextLast = size;
    }

    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T k) {
        if (size == items.length) {
            resizeIncrease();
        }
        items[nextFirst] = k;
        size = size + 1;
        moveCounterClockwise();
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T k) {
        if (size == items.length) {
            resizeIncrease();
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
        if ((size - 1)<items.length * 0.25 && items.length > 16) {
            resizeDecrease();
        }
        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst = nextFirst + 1;
        }
        size = size - 1;
        T firstItem = items[nextFirst];
        items[nextFirst] = null;
        System.out.println(firstItem);
        return firstItem;
    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public T removeLast() {
        if (size == 0){
            return null;
        }
        if (items.length > 16 && (size - 1)<items.length * 0.25) {
            resizeDecrease();
        }
        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast = nextLast - 1;
        }
        size = size - 1;
        T lastItem = items[nextLast];
        items[nextLast] = null;
        return lastItem;
    }




}


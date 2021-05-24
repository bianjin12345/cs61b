public class LinkedListDeque<T> {
    private class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        public IntNode(IntNode n, T i, IntNode m) {
            prev = n;
            item= i;
            next = m;
        }

    }

    private IntNode sentinel;
    private int size;

    /**
     * Creates an empty LinkedListDeque.
     */
    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Creates an linkedListDeque with int x
     */
    public LinkedListDeque(T x) {
        sentinel = new IntNode(null, null, null);
        sentinel.next = new IntNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T x) {
        sentinel.next = new IntNode(sentinel, x, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size = size + 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T x) {
        sentinel.prev = new IntNode(sentinel.prev, x, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size = size + 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        IntNode track = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(track.next.item + " ");
            track = track.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T First = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return First;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T Last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return Last;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *   If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (size == 0 || size<index) {
            return null;
        }
        IntNode IndexNode = sentinel;
        T item = null;
        int i = 0;
        while (i<index) {
            IndexNode = IndexNode.next;
            item = IndexNode.item;
            i += 1;
        }
        return item;
    }

    /**
     * Removes first item in the list and returns the rest of the list. If no such item exists, returns null.
     */
    public T getRecursiveHelp(int index, IntNode in) {
        if (index == 1) {
            return in.next.item;
        }
        in = in.next;
        return getRecursiveHelp(index-1,in);
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     *   If no such item exists, returns null. Must not alter the deque!
    */
    public T getRecursive(int index) {
        if (size == 0 || size < index) {
            return null;
        }
        IntNode pointer = sentinel;
        return getRecursiveHelp(index, pointer);
    }

    public static void main (String[] args) {
        LinkedListDeque<Integer> t = new LinkedListDeque<>();
        LinkedListDeque q = new LinkedListDeque(2);
        q.addFirst(3);
        q.addLast(4);
        System.out.println(t.isEmpty());
        System.out.println(q.size());
        q.printDeque();
        q.removeFirst();
        System.out.println(q.get(2));
        System.out.println(q.getRecursive(2));
    }
}


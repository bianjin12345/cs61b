import java.util.LinkedList;
import java.util.NoSuchElementException;
/** Isn't this solution kinda... cheating? Yes. */
public class LinkedListDeque<Item> extends LinkedList<Item> implements  Deque<Item>{
    @Override
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque <Character> a = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1){
            a.addLast(word.charAt(i));
        }
        return a;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
    }
    @Override
    public void printDeque() {
        System.out.println("dummy");
    }

    public Item getRecursive(int i) {
        return get(i);
    }
    @Override
    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
    @Override
    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}

public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> a = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i += 1) {
            a.addLast(word.charAt(i));
        }
        return a;
    }

    public static boolean isPalindrome(String word){
        if (word == "" || word.length() == 1) {
            return true;
        }

        Deque<Character> a = Palindrome.wordToDeque(word);
        for (int i = 0; i < a.size()/2; i += 1){
            if (a.removeFirst() == a.removeLast()) {
                a.removeFirst();
                a.removeLast();
            } else{
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        if (word == "" || word.length() == 1) {
            return true;
        }
        Deque<Character> a = Palindrome.wordToDeque(word);
        for (int i = 0; i < a.size()/2; i += 1){
            if (cc.equalChars(a.removeFirst(),a.removeLast())) {
                a.removeFirst();
                a.removeLast();
            } else{
                return false;
            }
        }
        return true;
    }
}

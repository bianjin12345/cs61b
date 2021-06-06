public class OffByOne implements CharacterComparator{
    int off;

    public OffByOne(){
        off = 1;
    }
    public OffByOne(int i){
        off = i;
    }
    @Override
    public boolean equalChars(char x, char y){
        if(Math.abs(x - y) == off){
            return true;
        }
        return false;
    }


}

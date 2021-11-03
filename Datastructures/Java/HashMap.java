import java.util.ArrayList;

public class HashMap {

    ArrayList key;
    ArrayList<String> value;

    public HashMap() {
        key = new ArrayList<>();
        value = new ArrayList<String>();
    }

    private int hashStringBad(String k, int N) {

        h = 0;
        for (int i = 0; i < k.length(); i++) {
            char c = k.charAt(i);
            h = h + charToInt(c);
        }

        return h % N;
    }

    private int hashString(String k, int N) {

        h = 0;
        for (int i = 0; i < k.length(); i++) {
            char c = k.charAt(i);
            h = 31 * h + charToInt(c);
        }

        return h % N;

    }

    public void put(String x, String k) {

    }

    public String get(String k) {

    }

    public void remove(String k) {
        
    }
    
}
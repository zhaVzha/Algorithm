package ricky;

import java.util.HashMap;

public class Solution2 {
    public static void main(String[] args) {
        HashMap<Character, Counter> hm = new HashMap<Character, Counter>();

        for (int i = 0; i < args[0].length(); i++) {
            char k = args[0].charAt(i);
            k = Character.toUpperCase(k);
            if (k >= 'A' && k <= 'Z') {
                if (hm.containsKey(k)) {
                    hm.get(k).i++;
                } else {
                    hm.put(k, new Counter());
                }
            }
        }
        System.out.println(hm);
    }
}

class Counter {
    int i = 1;

    public String toString() {
        return Integer.toString(i);
    }
}
package com.coding.t9;

import java.util.HashMap;
import java.util.Map;

/**
 * T9 spelling utility class. Stores internally a map with t9 characters information.
 *
 * @author Pavel Pinegin
 */
public class T9Spelling {

    private static class Pair {
        private Character num;
        private int order;

        public Pair(Character num, int order) {
            this.num = num;
            this.order = order;
        }
    }

    private static Map<Character, Pair> map = new HashMap<>();
    static {
        map.put(' ',new Pair('0', 1));
        map.put('a',new Pair('2', 1));
        map.put('b',new Pair('2', 2));
        map.put('c',new Pair('2', 3));
        map.put('d',new Pair('3', 1));
        map.put('e',new Pair('3', 2));
        map.put('f',new Pair('3', 3));
        map.put('g',new Pair('4', 1));
        map.put('h',new Pair('4', 2));
        map.put('i',new Pair('4', 3));
        map.put('j',new Pair('5', 1));
        map.put('k',new Pair('5', 2));
        map.put('l',new Pair('5', 3));
        map.put('m',new Pair('6', 1));
        map.put('n',new Pair('6', 2));
        map.put('o',new Pair('6', 3));
        map.put('p',new Pair('7', 1));
        map.put('q',new Pair('7', 2));
        map.put('r',new Pair('7', 3));
        map.put('s',new Pair('7', 4));
        map.put('t',new Pair('8', 1));
        map.put('u',new Pair('8', 2));
        map.put('v',new Pair('8', 3));
        map.put('w',new Pair('9', 1));
        map.put('x',new Pair('9', 2));
        map.put('y',new Pair('9', 3));
        map.put('z',new Pair('9', 4));
    }

    /**
     * Method encodes input string to T9 keys combinations pressed to achieve this string.
     * A space character in the result string represents pause between key press.
     * In the case of wrong characters will throw IllegalArgumentException.
     *
     * @param input String with lowercase letters 'a-z' or space characters.
     * @return Encoded string with combination of keys pressed to type original string
     */
    public static String spell(String input) {
        char previousNum = 'Z';
        StringBuilder sb = new StringBuilder();
        if (input == null) return sb.toString();
        for (char ch : input.toCharArray()) {
            Pair pair = map.get(ch);
            if (pair == null) {
                throw new IllegalArgumentException("Each message must consist of only lowercase characters a-z and space characters ' '.");
            }
            if (previousNum == pair.num) {
                sb.append(' ');
            }
            for (int i = 1; i <= pair.order; i++) {
                sb.append(pair.num);
            }

            previousNum = pair.num;
        }
        return sb.toString();
    }



}

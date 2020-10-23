package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一串输入，将其转换成字母和数字间隔的模式
 * @author zengfanyu
 * @date 2020/10/23 14:41
 */
public class Reformat {
    public String format(String s) {
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Queue<Character> number = new LinkedList<>();
        Queue<Character> characters = new LinkedList<>();
        Queue<Character> temp = new LinkedList<>();
        for (char ch : str) {
            if (ch >= 'a' && ch <= 'z') {
                characters.offer(ch);
            } else number.offer(ch);
        }
        if (characters.size() - number.size() > 1 || characters.size() - number.size() < -1)
            return "";
        if (number.size() > characters.size()) {
            temp = number;
            number = characters;
            characters = temp;
        }
        for (; characters.size() > 0; ) {
            sb.append(characters.poll());
            if (number.isEmpty()) {
            } else sb.append(number.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "a0b1c2";
        Reformat reformat = new Reformat();
        System.out.println(reformat.format(s));
    }
}

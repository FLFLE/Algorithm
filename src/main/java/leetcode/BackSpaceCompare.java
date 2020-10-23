package leetcode;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。
 * # 代表退格字符。
 * @author zengfanyu
 * @date 2020/10/23 16:52
 */
public class BackSpaceCompare {
    public boolean solution(String S, String T) {
        return result(S).equals(result(T));
    }

    public String result(String string) {
        StringBuilder sb = new StringBuilder();
        for(char ch : string.toCharArray()) {
            if(ch == '#'){
                if(sb.length() == 0) {continue;}
                sb.deleteCharAt(sb.length()-1);
            }else sb.append(ch);
        }
        return sb.toString();
    }
}
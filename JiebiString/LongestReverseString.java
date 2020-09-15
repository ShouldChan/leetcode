package JiebiString;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/15
 * @description 最长回文字符串
 * 中心扩展法
 */
public class LongestReverseString {
    public String centerExpend(String str) {
        if (str.length() == 0)
            return null;
        if (str.length() == 1)
            return str;
        String longest = str.substring(0, 1);
        for (int i = 0; i < str.length() - 1; i++) {
            String tmp = getLongestString(str, i, i);
            if (tmp.length() > longest.length())
                longest = tmp;
            tmp = getLongestString(str, i, i + 1);
            if (tmp.length() > longest.length())
                longest = tmp;
        }
        return longest;
    }

    public String getLongestString(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        String result = (new LongestReverseString()).centerExpend("12321abc");
        System.out.println(result.length());
    }
}

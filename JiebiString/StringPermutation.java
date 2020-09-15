package JiebiString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/14
 * @description 题目描述 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述: 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result=new ArrayList<>();
        dfs(str.toCharArray(),result,0);
        Collections.sort(result);
        return result;
    }

    public void dfs(char[] charArray, ArrayList<String> list, int pos) {
        if (pos == charArray.length - 1)
            list.add(new String(charArray));
        // for循环和swap的含义：对于“ABC”，
        // 第一次'A' 与 'A'交换，字符串为"ABC", pos为0， 相当于固定'A'
        // 第二次'A' 与 'B'交换，字符串为"BAC", pos为0， 相当于固定'B'
        // 第三次'A' 与 'C'交换，字符串为"CBA", pos为0， 相当于固定'C'
        // 最外层循环代表轮流固定一个字母
        for (int i = pos; i < charArray.length; i++) {
            if (i != pos && charArray[i] == charArray[pos])
                continue;
            else {
                swap(charArray, pos, i);
                System.out.println(pos+" "+Arrays.toString(charArray));
                dfs(charArray, list, pos + 1);
                swap(charArray, pos, i);
                System.out.println("huisu"+pos+" "+Arrays.toString(charArray));
                // 回溯的原因：比如第二次交换后是"BAC"，需要回溯到"ABC"
                // 然后进行第三次交换，才能得到"CBA"
            }
        }
    }

    public void swap(char[] array, int x, int y) {
        char tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    public static void main(String[] args) {
        StringPermutation sp=new StringPermutation();
        ArrayList<String> result= sp.Permutation("ABC");
//        for(String str : result){
//            System.out.println(str);
//        }

    }
}

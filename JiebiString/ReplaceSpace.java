package JiebiString;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/5/18
 * @description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public void replaceSpace(String str) {
        char[] strChar = str.toCharArray();
        int count = 0;
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == ' ') {
                count++;
            }
        }
        int newLength = strChar.length + count * 2;
        char[] strNew=new char[newLength+1];
        int j = strChar.length - 1;
        while (j >= 0) {
            if (strChar[j] != ' ') {
                strNew[newLength] = strChar[j];
                newLength--;
                j--;
            } else {
                strNew[newLength--] = '0';
                strNew[newLength--] = '2';
                strNew[newLength--] = '%';
                j--;
            }
        }
        for (int i = 0; i < strNew.length; i++) {
            System.out.println(strNew[i]);
        }
    }

    public static void main(String[] args) {
        String inputStr = "We are happy.";
        ReplaceSpace rsObj = new ReplaceSpace();
        rsObj.replaceSpace(inputStr);
    }
}

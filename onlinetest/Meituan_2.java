package com.cxj.onlinetest;

/**
 * 问题：求一组由0-9组成的字符串中，能用字符串中字符表示的最小的整数
 * 解法：
 * 1）1-9不全有
 * 最小的整数为没有的那个字符表示的个位数数字
 * 2）1-9全都有，但没有0
 * 则为（10）
 * 3）1-9全都有，并且有0
 *   nx表示个数最少的数字，n0表示0的个数
 *   1.当nx>n0，如1122334455667788990，x为1, 最小整数则为（1）（0）（0）
 *   2.当nx<=n0，如1112234567890,x为3，nx为1,最小整数为（33）
 */

public class Meituan_2 {
    public int smallestNum()
    public int zeroNum(String s){
        int zeroCount=0;
        char[] ss=s.toCharArray();
        for(int i=0;i<ss.length;i++){
            if(ss[i]=='0'){
                zeroCount++;
            }
        }
        return zeroCount;
    }
    public int countSmallestChar(String s){
        int[][] countNum=new int[10][2];
        char[] ss=s.toCharArray();
        for(int i=0;i<ss.length;i++){
            for(int j=0;j<length)

        }
    }
    public int smallestNumber(String s){
        int min;
        char[] ss=s.toCharArray();
        for(int i=0;i<ss.length;i++){
            if(int(ss[i])==1){
                min=1;
                break;
            }else if(int(ss[i])==2){
                min=2;
                break;
            }else if(int(ss[i])==3){
                min=3;break;
            }else if(int(ss[i])==4){
                min=4;break;
            }else if(int(ss[i])==5){
                min=5;break;
            }else if(int(ss[i])==6){
                min=6;break;
            }else if(int(ss[i])==7){
                min=7;break;
            }else if(int(ss[i])==8){
                min=8;break;
            }else if(int(ss[i])==9){
                min=9;break;
            }
        }

    }

    public static void main(String[] args) {

    }
}
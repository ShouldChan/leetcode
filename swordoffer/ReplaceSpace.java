package com.cxj.swordoffer;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str){
        String strr=str.toString();
        char[] strChar=strr.toCharArray();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<strChar.length;i++){
            if(strChar[i]==' ')
                sb.append("%20");
            else
                sb.append(strChar[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ReplaceSpace rs=new ReplaceSpace();
        StringBuffer str=new StringBuffer("We are happy!");
        String result=rs.replaceSpace(str);
        System.out.println(result);
    }
}
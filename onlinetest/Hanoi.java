package com.cxj.onlinetest;

public class Hanoi {
    public static void move(int disk, char from, char inter, char to) {
        if (disk == 1) {
            System.out.println("Disk " + disk + " From " + from + " To " + to);//a把第n个移到c
        } else {
            move(disk - 1, from, to, inter); // a把第n-1个借助c移到b
            System.out.println("Disk " + disk + " From " + from + " To " + to);
            move(disk - 1, inter, from, to); // b把第n-1个借助a移到c
        }
    }

    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        char c = 'C';
        int disk = 3;
        move(3, a, b, c);
    }
}
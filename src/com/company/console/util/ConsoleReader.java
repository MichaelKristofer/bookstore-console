package com.company.console.util;

import com.company.entity.Author;

import java.util.Scanner;

public class ConsoleReader {

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static int readInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static double readDouble(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}

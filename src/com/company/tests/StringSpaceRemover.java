package com.company.tests;

import java.util.Scanner;

public class StringSpaceRemover {
    public static String spaceFixer(String text){
        text = text.replaceAll("\\s","%20");
        return text;
    }

    public static void main(String[] args) {
        System.out.println(spaceFixer("This is a test"));
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();
        System.out.println(test);
        System.out.println(spaceFixer(test));
    }
}

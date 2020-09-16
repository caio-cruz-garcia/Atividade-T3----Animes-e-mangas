package com.company.tests;

import java.util.Scanner;

/**
 * (TEST).
 * Class created to test and understand the issue why the method spaceFixer was not working.
 * Should not be considered in the final product.
 */
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

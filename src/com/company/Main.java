package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SmsManger smsManger = new SmsManger();
        ContactManager contactManager = new ContactManager();

        while (true) {
            int action = showMenuAndGetAction();
            switch (action) {
                case 1:
                    contactManager.start();
                    break;
                case 2:
                    smsManger.start();
                    break;
                case 0:
                    System.exit(0);
            }

        }
    }

    public static int showMenuAndGetAction() {
        System.out.println("\t\t ***Task Manager***");
        System.out.println("-----------------------------");
        System.out.println("|\t\t1-Contact Manager\t|");
        System.out.println("|\t\t2-SMS Manager\t\t|");
        System.out.println("|\t\t0-Exit\t\t\t\t|");
        System.out.println("-----------------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Action: ");
        String s = scanner.next();
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                System.out.println("Enter Number: ");
                return -1;
            }
        }
        return Integer.parseInt(s);
    }



}

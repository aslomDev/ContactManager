package com.company;

import java.util.Scanner;

public class SmsManger {
     SendSms[] smsArray = new SendSms[1];
     int index = 0;

    public void start() {

        while (true) {
            int action = showMenu();
            switch (action) {
                case 1:
                    SendSms sendSms = sendMessage();
                    if (sendSms.getSms() != null){
                        addSmS(sendSms);
                    } else {
                        System.out.println("This phone haven't ContactList");
                    }
                    break;
                case 2:
                    showSmsHistory();
                    break;
                case 3:
                clearHistory();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Again Enter action ! ");
            }
        }


    }

    public  int showMenu() {
        System.out.println("\t\t ***MENU***");
        System.out.println("-------------------------");
        System.out.println("|\t\t1-Send SMS\t\t|");
        System.out.println("|\t\t2-SMS History\t|");
        System.out.println("|\t\t3-Clear History\t|");
        System.out.println("|\t\t0-Back to Menu\t|");
        System.out.println("-------------------------");

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

    public  SendSms sendMessage() {
        SendSms sendSms = new SendSms();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        String number = scanner.next();
        sendSms.setPhone(number);

        ContactManager contactManager = new ContactManager();

        if (contactManager.isHave(number)) {
            System.out.print("Enter SMS: ");
            String sms = scanner.nextLine();
            sendSms.setSms(sms);
        }
        else {
            sendSms.setSms(null);
        }

        return sendSms;
    }

    public  void showSmsHistory() {
        int i = 0;
        while (i < smsArray.length) {
            SendSms sendSms = smsArray[i];
            if (sendSms != null) {
                System.out.println(sendSms);
            }



            i++;
        }
        System.out.println("Have not SMS history ! ");
    }

    public  void addSmS(SendSms sendSms) {
        if (smsArray.length == index) {
            SendSms[] newpArray = new SendSms[smsArray.length + 5];
            int i = 0;
            while (i < smsArray.length) {
                newpArray[i] = smsArray[i];
                i++;
            }
            smsArray = newpArray;
        }
        smsArray[index] = sendSms;
        index++;
    }

    public  void clearHistory() {
        boolean result = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        String deletePhone = scanner.next();
        for (int i = 0; i < smsArray.length; i++) {
            if (smsArray[i] != null && smsArray[i].getPhone().equals(deletePhone)) {
                smsArray[i] = null;
                result = true;
                System.out.println("Clear History");
            }
        }
        if (!result) {
            System.out.println("Not Found ! ");
        }

    }
}

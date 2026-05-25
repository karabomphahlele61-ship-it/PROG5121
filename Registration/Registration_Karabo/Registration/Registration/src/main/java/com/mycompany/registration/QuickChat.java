package com.mycompany.registration;

import java.util.Scanner;

public class QuickChat {

    Scanner input = new Scanner(System.in);

    public void startChat() {

        System.out.println("Welcome to QuickChat.");

        int option = 0;

        // WHILE LOOP
        while (option != 3) {

            // MENU FEATURE
            System.out.println("\n===== MENU =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");

            System.out.print("Choose option: ");
            option = input.nextInt();
            input.nextLine();

            if (option == 1) {

                System.out.print("How many messages do you want to send? ");
                int numberOfMessages = input.nextInt();
                input.nextLine();

                // FOR LOOP
                for (int i = 1; i <= numberOfMessages; i++) {

                    System.out.println("\nMessage " + i);

                    System.out.print("Enter recipient number: ");
                    String recipient = input.nextLine();

                    System.out.print("Enter your message: ");
                    String text = input.nextLine();

                    Message msg = new Message(i, recipient, text);

                    System.out.println(msg.checkRecipientCell());
                    System.out.println(msg.checkMessageLength());

                    if (msg.checkMessageLength().equals("Message ready to send.")) {

                        System.out.println("Message Hash: " + msg.createMessageHash());

                        System.out.println("\n1. Send Message");
                        System.out.println("2. Disregard Message");
                        System.out.println("3. Store Message");

                        System.out.print("Choose option: ");
                        int sendOption = input.nextInt();
                        input.nextLine();

                        System.out.println(msg.sentMessage(sendOption));

                        if (sendOption == 3) {
                            msg.storeMessage();
                        }

                        System.out.println(msg.printMessages());
                    }
                }

            } else if (option == 2) {

                System.out.println("Coming Soon.");

            } else if (option == 3) {

                System.out.println("Goodbye.");

            } else {

                System.out.println("Invalid option.");
            }
        }
    }
}
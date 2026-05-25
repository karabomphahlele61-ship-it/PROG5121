package com.mycompany.registration;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Message {

    //declarations

    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private static int totalMessages = 0;

    // Constructor
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        generateMessageID();
    }

    // Generating random 10 digit ID
    public void generateMessageID() {

        Random random = new Random();

        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        messageID = String.valueOf(number);
    }

    // Checking Message ID
    public boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    // Checking recipient number
    public String checkRecipientCell() {

        if (recipient.matches("\\+27\\d{9}")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
    }

    // Checking message length
    public String checkMessageLength() {

        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {

            int excess = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + excess +
                    ", please reduce the size.";
        }
    }

    // Create hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;
    }

    // Send message options
    public String sentMessage(int choice) {

        if (choice == 1) {

            totalMessages++;

            return "Message successfully sent.";

        } else if (choice == 2) {

            return "Press 0 to delete the message.";

        } else if (choice == 3) {

            return "Message successfully stored.";

        } else {

            return "Invalid option.";
        }
    }

    // Print message
    public String printMessages() {

        return "Message ID: " + messageID
                + "\nMessage Hash: " + createMessageHash()
                + "\nRecipient: " + recipient
                + "\nMessage: " + message;
    }

    // Return total
    public int returnTotalMessages() {
        return totalMessages;
    }

    // storing message
    public void storeMessage() {

        try {

            FileWriter file = new FileWriter("storedMessages.json", true);

            file.write(
                    "{\n" +
                            "\"MessageID\":\"" + messageID + "\",\n" +
                            "\"Recipient\":\"" + recipient + "\",\n" +
                            "\"Message\":\"" + message + "\"\n" +
                            "}\n"
            );

            file.close();

        } catch (IOException e) {

            System.out.println("Error writing to file.");
        }
    }
}
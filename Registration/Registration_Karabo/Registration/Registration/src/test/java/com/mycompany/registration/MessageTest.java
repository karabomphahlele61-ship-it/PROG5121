package com.mycompany.registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    //message test

    @Test
    public void testMessageLengthSuccess() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hi Mike, can you join us for dinner tonight?"
        );

        assertEquals(
                "Message ready to send.",
                msg.checkMessageLength()
        );
    }

    //recipient test
    @Test
    public void testRecipientSuccess() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Cell phone number successfully captured.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testRecipientFailure() {

        Message msg = new Message(
                0,
                "08575975889",
                "Hello"
        );

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code.",
                msg.checkRecipientCell()
        );
    }

    @Test
    public void testSendMessage() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage(1)
        );
    }

    @Test
    public void testDisregardMessage() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Press 0 to delete the message.",
                msg.sentMessage(2)
        );
    }

    //message store test

    @Test
    public void testStoreMessage() {

        Message msg = new Message(
                0,
                "+27718693002",
                "Hello"
        );

        assertEquals(
                "Message successfully stored.",
                msg.sentMessage(3)
        );
    }
}
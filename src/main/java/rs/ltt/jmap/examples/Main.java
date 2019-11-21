package rs.ltt.jmap.examples;

import rs.ltt.jmap.examples.method.call.contact.GetContactMethodCall;
import rs.ltt.jmap.client.JmapClient;
import rs.ltt.jmap.common.method.call.mailbox.GetMailboxMethodCall;

public class Main {

    private static final String USERNAME = "user@domain.tld";
    private static final String PASSWORD = "password";
    private static final String ACCOUNT = "user@domain.tld";

    public static void main(String[] args) {
        try (JmapClient jmapClient = new JmapClient(USERNAME,PASSWORD)) {
            jmapClient.call(new GetMailboxMethodCall(ACCOUNT)).get();
            jmapClient.call(new GetContactMethodCall(ACCOUNT)).get();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

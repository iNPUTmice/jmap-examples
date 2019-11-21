package rs.ltt.jmap.examples.method.response.contact;

import rs.ltt.jmap.examples.entity.Contact;
import rs.ltt.jmap.annotation.JmapMethod;
import rs.ltt.jmap.common.method.response.standard.GetMethodResponse;

@JmapMethod("Contact/get")
public class GetContactMethodResponse extends GetMethodResponse<Contact> {
}

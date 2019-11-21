package rs.ltt.jmap.examples.method.call.contact;

import rs.ltt.jmap.examples.entity.Contact;
import rs.ltt.jmap.annotation.JmapMethod;
import rs.ltt.jmap.common.Request;
import rs.ltt.jmap.common.method.call.standard.GetMethodCall;

@JmapMethod("Contact/get")
public class GetContactMethodCall extends GetMethodCall<Contact> {
    public GetContactMethodCall(String accountId, Request.Invocation.ResultReference idsReference) {
        super(accountId, idsReference);
    }

    public GetContactMethodCall(String accountId, String[] ids) {
        super(accountId, ids);
    }

    public GetContactMethodCall(String accountId) {
        super(accountId);
    }
}

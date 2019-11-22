package rs.ltt.jmap.examples.method.call.placeholder;

import rs.ltt.jmap.examples.entity.Placeholder;
import rs.ltt.jmap.annotation.JmapMethod;
import rs.ltt.jmap.common.Request;
import rs.ltt.jmap.common.method.call.standard.GetMethodCall;

@JmapMethod("Placeholder/get")
public class GetPlaceholderMethodCall extends GetMethodCall<Placeholder> {
    public GetPlaceholderMethodCall(String accountId, Request.Invocation.ResultReference idsReference) {
        super(accountId, idsReference);
    }

    public GetPlaceholderMethodCall(String accountId, String[] ids) {
        super(accountId, ids);
    }

    public GetPlaceholderMethodCall(String accountId) {
        super(accountId);
    }
}

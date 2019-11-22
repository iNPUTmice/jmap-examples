package rs.ltt.jmap.examples.method.response.placeholder;

import rs.ltt.jmap.examples.entity.Placeholder;
import rs.ltt.jmap.annotation.JmapMethod;
import rs.ltt.jmap.common.method.response.standard.GetMethodResponse;

@JmapMethod("Placeholder/get")
public class GetPlaceholderMethodResponse extends GetMethodResponse<Placeholder> {
}

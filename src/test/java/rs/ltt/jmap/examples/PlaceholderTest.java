package rs.ltt.jmap.examples;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Assert;
import org.junit.Test;
import rs.ltt.jmap.client.JmapClient;
import rs.ltt.jmap.examples.method.call.placeholder.GetPlaceholderMethodCall;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

public class PlaceholderTest {

    private static String ACCOUNT_ID = "test@example.com";
    private static String USERNAME = "test@example.com";
    private static String PASSWORD = "secret";
    private static String WELL_KNOWN_PATH = ".well-known/jmap";

    @Test
    public void getPlaceholder() throws IOException, ExecutionException, InterruptedException {
        final MockWebServer server = new MockWebServer();
        server.enqueue(new MockResponse().setBody(readResourceAsString("get-placeholder/01-session.json")));
        server.enqueue(new MockResponse().setBody(readResourceAsString("get-placeholder/02-placeholder.json")));
        server.start();

        Assert.assertTrue(true);

        final JmapClient jmapClient = new JmapClient(
                USERNAME,
                PASSWORD,
                server.url(WELL_KNOWN_PATH)
        );

        jmapClient.call(new GetPlaceholderMethodCall(ACCOUNT_ID)).get();

        server.takeRequest(); //session
        RecordedRequest placeholderRequest = server.takeRequest(); //placeholder

        Assert.assertEquals(
                readResourceAsString("get-placeholder/02-placeholder-request.json"),
                CharStreams.toString(new InputStreamReader(placeholderRequest.getBody().inputStream()))
        );

        server.shutdown();
    }

    private static String readResourceAsString(String filename) throws IOException {
        return Resources.asCharSource(Resources.getResource(filename), Charsets.UTF_8).read().trim();
    }
}

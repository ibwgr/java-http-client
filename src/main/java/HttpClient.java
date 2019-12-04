import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.DefaultHttpRequestFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static void main(String[] args) throws IOException {
        String url = args[0];
        HttpGet getRequest = new HttpGet(url);
        // Via HttpGet können wir den user-agent Request Header verändern.
        // Der Server erkennt den Header und kann entsprechend die Antwort anpassen.
        getRequest.setHeader(HttpHeaders.USER_AGENT, "curl");
        CloseableHttpClient client = HttpClients.createDefault();

        try (CloseableHttpResponse response = client.execute(getRequest)) {
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);
        }
    }
}

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
        getRequest.setHeader(HttpHeaders.USER_AGENT, "curl");
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;

        try {
            response = client.execute(getRequest);
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);
        } finally {
            if(response != null) response.close();
        }
    }
}

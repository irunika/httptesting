package org.irunika.testing.http;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by irunika on 10/20/17.
 */
public class HttpClient {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://localhost:9090/hello/world");
        StringEntity reqEntity = new StringEntity("Hi all");
        reqEntity.setChunked(true);
        reqEntity.setContentEncoding(new Header() {
            public String getName() {
                return "Transfer-Encoding";
            }

            public String getValue() {
                return "gzip";
            }

            public HeaderElement[] getElements() throws ParseException {
                return new HeaderElement[0];
            }
        });
        post.setEntity(reqEntity);
        CloseableHttpResponse response = httpClient.execute(post);
    }
}

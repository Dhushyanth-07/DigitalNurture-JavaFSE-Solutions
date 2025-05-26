import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientDemo {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/google"))
            .build();
        
        HttpResponse<String> response = client.send(
            request, BodyHandlers.ofString());
        
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body:\n" + response.body());
    }
}
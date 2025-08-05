import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        BodyPublisher bp = BodyPublishers.ofString("""
                {
                    _7u67u76
                }
                """);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
            .POST(bp)
            .build();
                
    try {
         HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           if (response.statusCode() == 200) {
                System.out.println("HTTP GET Request Successful!");
                System.out.println("Response Status Code: " + response.statusCode());
                System.out.println("Response Body:\n" + response.body());
            } else {
                System.err.println("HTTP GET Request Failed with status code: " + response.statusCode());
                System.err.println("Response Body:\n" + response.body());
            }
    }
    
    catch (IOException | InterruptedException e) {
         e.printStackTrace();
    }
  }
}


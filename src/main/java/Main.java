import java.net.http.HttpClient;

import io.javalin.Javalin;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        //statisk metode der kører direkte på klassen Javalin
        // når vi tilføjer flere app.get'tere, så chainer vi dem

        Javalin app = Javalin
                .create()
                .start(7007);
                .build();
    }

}
import java.net.http.HttpClient;

import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;


public class Main {


    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        // Create a new javalin server running on port 7007

        Javalin app = Javalin
                .create()
                .start(7007);
        app.routes(getDogsResource());      // router EndpointGroup til vores server

    }

    // EndpointGroup er vigtig fordi, at det er den som samler alle vores CRUD-operationer
    // på hver resource - i dette er vores resource 'dogs'.
    // Endpoints paths er dem som ses på "x" i vores get/post/osv. "/x"

    public static EndpointGroup getDogsResource() {

        DogsController dc = new DogsController();

        return () -> {
            path("/api/dogs", () -> {
                get("/", dc.getAllDogs());
                post("/dog", dc.createDog());
                get("/dog/{id}", dc.getDogById());
                put("/dog/{id}", dc.updateDog());
                delete("/dog/{id}", dc.deleteDog());

            });
        };
    }
}
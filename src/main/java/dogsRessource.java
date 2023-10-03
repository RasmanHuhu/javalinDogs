import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

public class dogsRessource {

    private static dogsController dc = new dogsController();
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
}
